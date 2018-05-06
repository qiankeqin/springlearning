package com.gupaoedu.vip.custom;

import com.sun.tools.doclets.internal.toolkit.FieldWriter;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 生成代理对象的代码
 */
public class GPProxy {

    private static String ln = "\r\n";

    public static Object newProxyInstance(GPClassLoader classLoader,
                                          Class<?>[] interfaces,
                                          GPInvocationHandler h)
            throws IllegalArgumentException, IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //1.生成源代码
        String proxySrc = generateSrc(interfaces[0]);

        //2.将生成的源代码输出到磁盘，保存为.java文件
        String path = GPProxy.class.getResource("").getPath();
        System.out.println(path);
        File f = new File(path + "$Proxy0.java");
        FileWriter fw = new FileWriter(f);
        fw.write(proxySrc);
        fw.flush();
        fw.close();


        //3.编译源代码，并且生成.class文件
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager manager = compiler.getStandardFileManager(null,null,null);
        Iterable iterable = manager.getJavaFileObjects(f);

        JavaCompiler.CompilationTask task = compiler.getTask(null,manager,null,null,null,iterable);
        task.call();
        manager.close();


        //4.将class文件中到内容，动态加载到JVM中来

        //5.返回被代理到代理对象
        Class<?> proxyClass = classLoader.findClass("$Proxy0");
        //获取到代理类中到构造函数
        Constructor<?> constructor = proxyClass.getConstructor(GPInvocationHandler.class);

        f.delete();//使用完毕后，可以删除java文件
        return constructor.newInstance(h);
    }


    public static String generateSrc(Class<?> interfaces){
        StringBuffer src = new StringBuffer();
        src.append("package com.gupaoedu.vip.custom;"+ln);
        src.append("import java.lang.reflect.Method;"+ln);
        src.append("public class $Proxy0 implements "+interfaces.getName()+"{"+ln);

        src.append("GPInvocationHandler h;"+ln);
        src.append("public $Proxy0(GPInvocationHandler h){"+ln);
        src.append("this.h = h;}"+ln);

        for(Method m : interfaces.getMethods()){
            src.append("public "+m.getReturnType().getName() + " "+m.getName() + "() {"+ln);

            src.append("try{"+ln);
            src.append("Method m = "+interfaces.getName()+".class.getMethod(\""+m.getName()+"\",new Class[]{});"+ln);
            src.append("this.h.invoke(this,m,null);"+ln);
            src.append("} catch(Throwable ex){"+ln);
            src.append("}"+ln);

            if(!m.getReturnType().getName().equals("void")){
                src.append("return;"+ln);
            }
            src.append("}"+ln);
        }

        src.append("}"+ln);

        return src.toString();
    }
}
