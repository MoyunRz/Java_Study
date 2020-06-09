package com.IOTest;

import org.junit.Test;

import java.io.*;

/**
 * 一、流的分类
 * 1. 操作数据单位：字节流、字符流
 * 2. 数据的流向：输入流、输出流
 * 3. 流的角色： 节点流、处理流
 * @author RZ
 * @date 2020/6/4 18:14
 */
public class FileReaderWriterTest {

    @Test
    public void testFileReader(){
        FileReader fr =null;
        try {
            // 1.实例化File类的对象，指明要操作的文件
            File file=new File("IOTest\\hello.txt");
            // 2.提供具体的流
            fr = new FileReader(file);
            // 3.数据的读取
            // read():返回读入的一个字符。如果达到文件末尾，返回-1
//        int data= fr.read();
//        while (data!=-1){
//            System.out.print((char)data);
//            data= fr.read();
//        }
//        fr.close();

            int data;
            while ((data= fr.read())!=-1){
                System.out.print((char)data);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Test
    public void testFileReader1(){
        FileReader fr =null;
        try {
            // 1.实例化File类的对象，指明要操作的文件
            File file=new File("IOTest\\hello.txt");
            // 2.提供具体的流
            fr = new FileReader(file);
            // 3.数据的读取
            // read():返回读入的一个字符。如果达到文件末尾，返回-1
            char[] cbuf = new char[5];
            int len;
//            while((len = fr.read(cbuf)) != -1){
//
//                for (int i = 0; i <len ; i++) {
//                    System.out.println(cbuf[i]);
//                }
//            }
            while((len = fr.read(cbuf)) != -1){
                String str = new String(cbuf,0,len);
                System.out.print(str);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Test
    public void testFileWriter() throws IOException {

        File file = new File("IOTest\\hi.txt");
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write("1234567897");
        fileWriter.close();

    }
}
