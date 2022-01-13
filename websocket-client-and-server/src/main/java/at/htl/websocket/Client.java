package at.htl.websocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client extends Thread {
    public void run() {
        Socket s = null;
        try {
            //socket connection
            s = new Socket("localhost", 4999);

            PrintWriter pr = new PrintWriter(s.getOutputStream());
            pr.println("is it working");
            pr.flush();

            //two-way connection client to server & server to client
            InputStreamReader in = new InputStreamReader(s.getInputStream());
            BufferedReader bf  = new BufferedReader(in);

            String str = bf.readLine();
            System.out.println("server: " + str);
        }

        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
