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

        // ???????????????@ARouter??????????????????
        Set<? extends Element> elements = roundEnvironment.getElementsAnnotatedWith(ARouter.class);
        for (Element element : elements) {
            // ???????????????????????????????????????
            String packageName = eLementsUtils.getPackageOf(element).getQualifiedName().toString();
            // ??????????????????
            String className = element.getSimpleName().toString();
            messager.printMessage(Diagnostic.Kind.NOTE, "???@ARouter??????????????????"+className);
            // ???????????????????????????
            String finalClassName = className + "$$ARouter";

            ARouter aRouter = element.getAnnotation(ARouter.class);

            // ?????????public static Class<?> findTargetClass(String path){}
            MethodSpec methodSpec = MethodSpec.methodBuilder("findTargetClass") // ?????????
                    .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
                    .returns(Class.class) // ??????????????????Class
                    .addParameter(String.class, "path") // ????????????????????????
                    // return path.equalsIgnoreCase("app/MainActivity") ? MainActivity.class : null;
                    .addStatement("return path.equalsIgnoreCase($S) ? $T.class : null",
                            aRouter.path(),
                            ClassName.get((TypeElement) element))
                    .build();

            // ??????public class XActivity$$ARouter {}
            TypeSpec typeSpec = TypeSpec.classBuilder(finalClassName) // ??????
                    .addModifiers(Modifier.PUBLIC, Modifier.FINAL)
                    .addMethod(methodSpec) // ????????????????????????
                    .build();

            // ??????package com.example.componetaptjavapoet;
            JavaFile javaFile = JavaFile.builder(packageName, typeSpec) // ???????????????
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
