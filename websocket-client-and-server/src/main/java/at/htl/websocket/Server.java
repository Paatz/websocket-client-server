package at.htl.websocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Thread{
    public void run() {
        ServerSocket ss = null;
        try {
            //socket connection
            ss = new ServerSocket(4999);

            Socket s = ss.accept();

            System.out.println("client connected");

            InputStreamReader in = new InputStreamReader(s.getInputStream());
            BufferedReader bf  = new BufferedReader(in);

            String str = bf.readLine();
            System.out.println("client: " + str);

            //two-way communication  client to server & server to client
            PrintWriter pr = new PrintWriter(s.getOutputStream());
            pr.println("yes");
            pr.flush();

        }

        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
