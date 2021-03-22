package com.example.modular.compiler.utils;

/**
 * Created by DingJing on 2021/3/19
 * Contact me: 847467911@qq.com
 * Describe: 常量
 */
public class Constants {
    // 注解处理器支持的注解类型 这里一定要与ARouter注解的全路径相同
    public static final String IROUTER_ANNOTATION_TYPES = "com.example.modular.annotation.ARouter";
    public static final String PARAMETER_ANNOTATION_TYPES = "com.example.modular.annotation.Parameter";

    // 每个子模块的模块名
    public static final String MODULE_NAME = "moduleName";
    // 包名，用于存放APT生成的类文件
    public static final String APT_PACKAGE = "packageNameForAPT";

    // String全类名
    public static final String STRING = "java.lang.String";
    // Activity全类名
    public static final String ACTIVITY = "android.app.Activity";
    // 包名前缀封装
    static final String BASE_PACKAGE = "com.example.modular.api";
    // 路由组Group加载接口
    public static final String AROUTE_GROUP = BASE_PACKAGE + ".core.ARouterLoadGroup";
    // 路由组Group对应的详细Path加载接口
    public static final String AROUTE_PATH = BASE_PACKAGE + ".core.ARouterLoadPath";
    // 获取参数，加载接口
    public static final String PARAMETER_LOAD = BASE_PACKAGE + ".core.ParameterLoad";


    // 路由组Group，参数名
    public static final String GROUP_PARAMETER_NAME = "groupMap";
    // 路由组Group，方法名
    public static final String GROUP_METHOD_NAME = "loadGroup";
    // 路由组Group对应的详细Path，参数名
    public static final String PATH_PARAMETER_NAME = "pathMap";
    // 路由组Group对应的详细Path，方法名
    public static final String PATH_METHOD_NAME = "loadPath";
    // 获取参数，方法名
    public static final String PARAMETER_NAMR = "target";
    // 获取参数，参数名
    public static final String PARAMETER_METHOD_NAME = "loadParameter";

    // APT生成的路由组Group源文件名
    public static final String GROUP_FILE_NAME = "ARouter$$Group$$";
    // APT生成的路由组Group对应的详细Path源文件名
    public static final String PATH_FILE_NAME = "ARouter$$Path$$";
    // APT生成的获取参数类文件名
    public static final String PARAMETER_FILE_NAME = "$$Parameter";
}
