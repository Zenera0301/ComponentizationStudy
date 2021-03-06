package com.example.compiler;

import com.example.annotation.ARouter;
import com.google.auto.service.AutoService;


import java.io.IOException;
import java.io.Writer;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedOptions;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;
import javax.tools.Diagnostic;
import javax.tools.JavaFileObject;

@AutoService(Processor.class)
@SupportedAnnotationTypes("com.example.annotation.ARouter") // 注解处理器支持的注解类型，需要把ARouter放进来，才能在process中处理, 必须是全类名
@SupportedSourceVersion(SourceVersion.RELEASE_7) // 你需要用到什么jdk的版本来进行编译，生成这个class，必填！
@SupportedOptions("content")
public class ARouterProcessor extends AbstractProcessor {

    private Elements elementUtils; // 操作Element工具类
    private Types typesUtils; // type类信息工具类
    private Messager messager; // 用来输出警告、错误等日志
    private Filer filer; // 文件生成器
    @Override
    public synchronized void init(ProcessingEnvironment processingEnvironment) {
        // 初始化工作
        super.init(processingEnvironment);
        elementUtils = processingEnvironment.getElementUtils();
        typesUtils = processingEnvironment.getTypeUtils();
        messager = processingEnvironment.getMessager();
        filer = processingEnvironment.getFiler();

        String content = processingEnvironment.getOptions().get("content");
        // 有坑，不能像Android中Log.e的写法
        messager.printMessage(Diagnostic.Kind.NOTE, content);
    }

    // 通过注解替代
//    @Override
//    public Set<String> getSupportedAnnotationTypes() {
//        // 注解处理器支持的注解类型，需要把ARouter放进来，才能在process中处理
//        return super.getSupportedAnnotationTypes();
//    }
//
//    @Override
//    public SourceVersion getSupportedSourceVersion() {
//        // 你需要用到什么jdk的版本来进行编译，生成这个class，必填！
//        return super.getSupportedSourceVersion();
//    }
//
//    @Override
//    public Set<String> getSupportedOptions() {
//        // 接收外面传来的参数
//        return super.getSupportedOptions();
//    }

    /**
     * 相当于main函数，开始处理注解
     * 注解处理器的核心方法，处理具体的注解，生成java文件
     *
     * @param set 使用了支持处理注解的节点集合（类，上面写了注解）
     * @param roundEnvironment 当前或是之前的运行环境，可以通过该对象查找找到的注解
     * @return true 表示后续处理器不再处理（已经处理完成）
     */
    @Override
    public boolean process(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment) {
        if(set.isEmpty()){
            return false;
        }
        // 获取项目中所有使用了ARouter注解的节点
        Set<? extends Element> elements = roundEnvironment.getElementsAnnotatedWith(ARouter.class);
        // 遍历所有的类节点
        for (Element element : elements) {
            // 类节点之上，就是包节点
            String packageName = elementUtils.getPackageOf(element).getQualifiedName().toString();
            // 获取简单类名
            String className = element.getSimpleName().toString();
            messager.printMessage(Diagnostic.Kind.NOTE, "备注接的类有："+className);
            // 最终想要生成的类文件,如“MainActivity$$ARouter”
            String finalClassName = className + "$$ARouter";

            try {
                JavaFileObject sourceFile = filer.createSourceFile(packageName + "." + finalClassName); // 创建源文件
                Writer writer = sourceFile.openWriter();
                // 设置包名
                writer.write("package "+packageName+";\n");
                writer.write("public class "+finalClassName+" {\n");
                writer.write("public static Class<?> findTargetClass(String path) {\n");

                // 获取类之上@ARouter注解的path值
                ARouter aRouter = element.getAnnotation(ARouter.class);

                writer.write("if (path.equalsIgnoreCase(\""+aRouter.path()+"\")) {\n");
                writer.write("return "+className+".class;\n}\n");
                writer.write("return null;\n");
                writer.write("}\n}");

                // 非常重要
                writer.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return true;
    }
}
