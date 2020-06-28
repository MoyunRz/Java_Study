package com.tongxin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class MyTcpClient {
    private PrintWriter writer;
    private BufferedReader reader;
    Socket socket;
    public void connect(){
        System.out.println("尝试连接");
        try{
            socket = new Socket("127.0.0.1",9000);
            writer = new PrintWriter(socket.getOutputStream(),true);
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println("连接成功");
            writer.println("你好，来自客户端的连接");
            getserverMessage();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    private void getserverMessage(){
        try{
            while(true){
                System.out.println("："+ reader.readLine());
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

class Main {
    public static void main(String[] args) {
        MyTcpClient tcpclient;
        tcpclient = new MyTcpClient();
        tcpclient.connect();
    }

}
