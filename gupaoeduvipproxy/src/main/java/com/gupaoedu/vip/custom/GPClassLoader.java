package com.gupaoedu.vip.custom;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

//代码生成，重新编译，重新动态load到JVM
public class GPClassLoader extends ClassLoader{

    private File baseDir;

    public GPClassLoader(){
        String path = GPClassLoader.class.getResource("").getPath();
        baseDir = new File(path);
    }

    //重写方法：

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String className = GPClassLoader.class.getPackage().getName() + "." + name;
        if(baseDir!=null){
            File classFile = new File(baseDir,name.replaceAll("\\.","/")+".class");
            if(classFile.exists()){
                FileInputStream in = null;
                ByteArrayOutputStream out = null;
                try{
                    in = new FileInputStream(classFile);
                    out = new ByteArrayOutputStream();
                    byte[] buff = new byte[1024];
                    int len;
                    while((len = in.read(buff) )!= -1){
                        out.write(buff,0,len);
                    }
                    return defineClass(className,out.toByteArray(),0,out.size());
                }catch(Exception ex){

                }finally {
                    try {
                        in.close();
                        out.close();
                        classFile.delete();//使用完毕后，可以删除.class文件
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return super.findClass(name);
    }
}
