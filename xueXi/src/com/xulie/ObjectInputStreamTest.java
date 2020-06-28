package com.xulie;

import org.junit.Test;

import java.io.*;

/**
 * @author RZ
 * @date 2020/6/9 15:09
 */
public class ObjectInputStreamTest {

    // 序列化过程：将内存中的Java对象保存到磁盘中或通过网络传输出去
    @Test
    public void testOutputStream() throws IOException {

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("object.dat"));

        oos.writeObject("我爱北京");
        oos.flush();
        oos.close();
    }


    @Test
    public void testInputStream() throws IOException, ClassNotFoundException {

        ObjectInputStream oos = new ObjectInputStream(new FileInputStream("object.dat"));

        Object obj = oos.readObject();
        String str = (String) obj;
        System.out.println(str);
        oos.close();
    }
}
