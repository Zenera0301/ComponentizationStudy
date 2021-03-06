package com.example.compiler;

import com.example.annotation.ARouter;
import com.google.auto.service.AutoService;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;

import java.io.IOException;
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
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;
import javax.tools.Diagnostic;

@AutoService(Processor.class)
@SupportedAnnotationTypes("com.example.annotation.ARouter")
@SupportedSourceVersion(SourceVersion.RELEASE_7)
@SupportedOptions("content")
public class ARouterProcessor extends AbstractProcessor {

    private Elements eLementsUtils;
    private Types typesUtils;
    private Messager messager;
    private Filer filer;

    @Override
    public synchronized void init(ProcessingEnvironment processingEnvironment) {
        super.init(processingEnvironment);
        eLementsUtils = processingEnvironment.getElementUtils();
        typesUtils = processingEnvironment.getTypeUtils();
        messager = processingEnvironment.getMessager();
        filer = processingEnvironment.getFiler();

        String content = processingEnvironment.getOptions().get("content");
        messager.printMessage(Diagnostic.Kind.NOTE, content);
    }

    @Override
    public boolean process(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment) {
        if (set.isEmpty()) {
            return false;
        }

        // 获取所有被@ARouter注解的类节点
        Set<? extends Element> elements = roundEnvironment.getElementsAnnotatedWith(ARouter.class);
        for (Element element : elements) {
            // 类节点的上一个节点：包节点
            String packageName = eLementsUtils.getPackageOf(element).getQualifiedName().toString();
            // 获取简单类名
            String className = element.getSimpleName().toString();
            messager.printMessage(Diagnostic.Kind.NOTE, "被@ARouter注解的类有："+className);
            // 最终生成的类文件名
            String finalClassName = className + "$$ARouter";

            ARouter aRouter = element.getAnnotation(ARouter.class);

            // 方法：public static Class<?> findTargetClass(String path){}
            MethodSpec methodSpec = MethodSpec.methodBuilder("findTargetClass") // 方法名
                    .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
                    .returns(Class.class) // 返回值类型是Class
                    .addParameter(String.class, "path") // 参数类型和参数名
                    // return path.equalsIgnoreCase("app/MainActivity") ? MainActivity.class : null;
                    .addStatement("return path.equalsIgnoreCase($S) ? $T.class : null",
                            aRouter.path(),
                            ClassName.get((TypeElement) element))
                    .build();

            // 类：public class XActivity$$ARouter {}
            TypeSpec typeSpec = TypeSpec.classBuilder(finalClassName) // 类名
                    .addModifiers(Modifier.PUBLIC, Modifier.FINAL)
                    .addMethod(methodSpec) // 将方法添加到类中
                    .build();

            // 包：package com.example.componetaptjavapoet;
            JavaFile javaFile = JavaFile.builder(packageName, typeSpec) // 包名，类名
                    .build();

            try {
                javaFile.writeTo(filer);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return true;
    }
}
