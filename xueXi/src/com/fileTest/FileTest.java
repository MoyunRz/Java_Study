package com.fileTest;

import org.junit.Test;

import java.io.*;

/**
 * File类的使用
 *
 * 1.File类的一个对象，代表一个文件或者一个文件目录（俗称：文件夹）
 * 2.File类声明在java.io包下
 * @author RZ
 * @date 2020/6/4 16:03
 */
public class FileTest {

    /**
     * 1.如何创建File实例:
     * File(String filePath)
     * File(String pathname,String child)
     * File(File parentFile,String childPath)
     *
     * 2.
     * 相对路径：相对于某国的路径下
     * 绝对路径：包含盘符在内的文件或者文件目录的路径
     *
     */
    @Test
    public void test1(){

        /**
         * 构造器1
         */
        // 相对于module
        File file =new File("hello.txt");
        // 绝对路径
        File files =new File("C:\\Users\\admin\\Java_Study\\xueXi\\IOTest\\hello.txt");
        System.out.println(file);
        System.out.println(files);
        /**
         * 构造器2
         */
        File file1 = new File("C:\\Users\\admin\\Java_Study\\xueXi","IOTest");
        System.out.println(file1);

        /**
         * 构造器3
         */
        File file3 = new File(file1,"hello.txt");
        System.out.println(file3);
    }

    /**
     * public  String getAbsolutePath(): 获取绝对路径
     * public  String getPath(): 获取路径
     * public  String getName(): 获取名称
     * public  String getParent(): 获取上层文件目录路径。若无，返回null
     * public  Long length(): 获取文件长度（即字节数）。不能获取目录长度。
     * public  Long lastModified(): 获取最后一次的修改时间，毫秒值
     * public  String[] list(): 获取指定目录下的所有文件或者文件目录的名称数组
     * public  File[] listFiles(): 获取指定目录下的所有文件或者文件目录下的File数组
     *
     */
    @Test
    public void test2(){
        File file =new File("IOTest\\hello.txt");
        // 绝对路径
        File files =new File("C:\\Users\\admin\\Java_Study\\xueXi\\IOTest");
        File newfile =new File("C:\\Users\\admin\\Java_Study\\xueXi\\笔记\\hello.txt");
        boolean b=file.renameTo(newfile);
        System.out.println(b);
        System.out.println(file.getAbsoluteFile());
        System.out.println(file.getPath());
        System.out.println(file.getName());
        System.out.println(file.length());
        System.out.println(file.lastModified());
        String[] fileList= files.list();

        for (String s : fileList) {
            System.out.println(s);
        }

        File[] filesLists = files.listFiles();
        for (File filesList : filesLists) {
            System.out.println(filesList.length());
        }

    }

    /**
     * public boolean isDirectory(): 判断是否是文件目录
     * public boolean isFile(): 判断是否是文件
     * public boolean exists(): 判断是否存在
     * public boolean canRead(): 判断是否可读
     * public boolean canWrite(): 判断是否能写
     * public boolean isHidden(): 判断是否是隐藏文件
     *
     */
    @Test
    public void test3(){

    }

    /**
     * 创建硬盘中对应的文件或者文件目录
     * public boolean createNewFile(): 创建文件。若文件存在，则不创建，返回false
     * public boolean mkdir(): 创建文件目录。如果此文件目录存在，就不创建了。如果此文件目录的上层目录不存在，也不创建
     * public boolean mkdirs(): 创建文件目录。如果上层文件不存在就一并创建
     * public boolean delete(): 删除文件或者文件夹（ps:java的删除不走回收站）
     */
    @Test
    public void test4() throws IOException {

        File file1=new File("IOTest\\hi.txt");
        if(!file1.exists()){
            file1.createNewFile();
            System.out.println("创建成功");
        }else{
            file1.delete();
            System.out.println("删除成功");
        }
    }

    @Test
    public void test5() throws IOException {

        File file1=new File("IOTest1\\hi.txt");
        if(!file1.exists()){
            file1.mkdirs();
            System.out.println("创建成功");
        }else{
            file1.delete();
            System.out.println("删除成功");
        }
    }

    /**
     * 从内存中写出数据到硬盘的文件中
     */
    @Test
    public void test6() {
        // 1.根据路径获取文件
        File file1=new File("IOTest1\\hello.txt");
        // 初始化实例
        FileWriter fw = null;
        try{
            // 3.提供FileWriter的对象，用于数据的写出
            fw = new FileWriter(file1);
            // 4.写出操作
            fw.write("857");

        }catch (IOException e){
            // 抛出异常
            e.printStackTrace();
        }finally {
            try{
                // 关闭IO
                fw.close();
            }catch (IOException e){
                e.printStackTrace();

            }finally {

            }

        }

    }

    /**
     * 从内存中写入数据
     */
    @Test
    public void test7() {
        // 1.根据路径获取文件
        File file1=new File("IOTest1\\hello.txt");
        // 初始化实例
        FileReader fr = null;
        try{
            // 3.FileReader，用于数据的写入
            fr = new FileReader(file1);
            // 4.写出操作
            int len;
            char[] cbuf = new char[5];
            while ((len = fr.read(cbuf))!=-1){
                fr.read(cbuf,0,len);
            }
        }catch (IOException e){
            // 抛出异常
            e.printStackTrace();
        }finally {
            try{
                // 关闭IO
                fr.close();
            }catch (IOException e){
                e.printStackTrace();

            }
        }

    }

    /**
     * 从内存中写入数据
     */
    @Test
    public void test8() {
        // 1.根据路径获取文件
        File file1=new File("IOTest\\QQ.jpg");
        File file2=new File("IOTest1\\QQ.jpg");
        // 初始化实例
        FileInputStream fis = null;
        FileOutputStream fos = null;

        try{
            fis = new FileInputStream(file1);
            fos = new FileOutputStream(file2);
            int len;
            // 定义字节数组存储大小
            byte[] cbyte = new byte[5];

            while ((len = fis.read(cbyte))!=-1){
                fos.write(cbyte,0,len);
            }

        }catch (IOException e){
            // 抛出异常
            e.printStackTrace();
        }finally {
            try{
                fis.close();
                fos.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }

    }

    @Test
    public void test9() {

        copyFile("IOTest\\QQ.jpg","IOTest1\\QQ.jpg");
    }


    public void copyFile(String oldFile,String newFile){
        // 1.根据路径获取文件
        File file1=new File(oldFile);
        File file2=new File(newFile);

        FileInputStream fis = null;
        FileOutputStream fos = null;
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        try{
            fis = new FileInputStream(file1);
            fos = new FileOutputStream(file2);
            bufferedInputStream = new BufferedInputStream(fis);
            bufferedOutputStream =new BufferedOutputStream(fos);
            int len;
            // 定义字节数组存储大小
            byte[] cbyte = new byte[1024];

            while ((len = bufferedInputStream.read(cbyte))!=-1){
                bufferedOutputStream.write(cbyte,0,len);
            }
        }catch (IOException e){
            // 抛出异常
            e.printStackTrace();
        }finally {
            try{
                bufferedInputStream.close();
                bufferedOutputStream.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    /**
     * 加密
     */
    @Test
    public void test10() {
        FileInputStream fis =null;
        FileOutputStream fio =null;
        try {
            fis = new FileInputStream("IOTest\\QQ.jpg");
            fio = new FileOutputStream("IOTest1\\QQ1.jpg");
            byte[] buffer = new byte[1024];
            int len;
            while ((len = fis.read(buffer))!=-1){

                for (int i = 0; i < len; i++) {
                    buffer[i] = (byte) (buffer[i]^5);
                    buffer[i] = (byte) (buffer[i]^5);
                }
                fio.write(buffer,0,len);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {

            try {
                fis.close();
                fio.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

}
