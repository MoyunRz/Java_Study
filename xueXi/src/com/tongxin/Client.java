package com.tongxin;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author RZ
 * @date 2020/6/9 10:18
 */
public class Client {

    public static void main(String[] args) throws IOException {

        String host = "127.0.0.1";
        int port = 9000;
        System.out.println("-----------客户端启动-----------");
        Socket client = new Socket(host, port);
        // 写出字节流到连接的主机
        Writer writer = new OutputStreamWriter(client.getOutputStream());
        Scanner in = new Scanner(System.in);
        writer.write(in.nextLine());
        writer.flush();
        writer.close();
        client.close();
        in.close();

    }
}