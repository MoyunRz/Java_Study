package com.Chat;

import java.io.IOException;
import java.net.Socket;

/**
 * @author RZ
 * @date 2020/6/9 11:45
 */
public class ClientServer {
    public static void main(String[] args) throws IOException {
        String host = "127.0.0.1";
        int port = 9000;
        Socket client = new Socket(host, port);

    }
}
