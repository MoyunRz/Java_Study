package com.tongxin;

import java.io.*;
import java.net.*;

/**
 * @author RZ
 * @date 2020/6/9 10:16
 */
public class SocketService {
    public static void main(String[] args) {
        MyTcpServer tcpserv = new MyTcpServer();
        tcpserv.getserver();
    }

}

class MyTcpServer {
    private BufferedReader reader;
    private PrintWriter writer;
    private ServerSocket server;
    private Socket socket;
    void getserver(){
        try{
            server = new ServerSocket(8570);
            System.out.println("服务器套接字已经创建成功");
            while(true){
                System.out.println("等待客户机的连接");
                socket = server.accept();	//阻塞的
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                writer = new PrintWriter(socket.getOutputStream(),true);
                getClientMessage();			}
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    private void getClientMessage(){
        try{
            while(true){
                System.out.println("客户端信息接收："+ reader.readLine());
                writer.println("欢迎您连接服务端");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        try{
            if(reader != null){
                reader.close();
            }
            if(writer != null){
                writer.close();
            }
            if(socket != null){
                socket.close();
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}

