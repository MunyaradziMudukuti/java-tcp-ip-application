package client;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class SocketClientApplication {

    static int port = 2021;
    static String ip = "127.0.0.1";
    static int close = 0;

    public static void main(String[] args) throws IOException {

                Socket client = new Socket(ip, port); // client creation (start after server)

                //Send a message to the server
                PrintWriter pw = new PrintWriter(client.getOutputStream());

                //Read the message from the server
                Scanner scan = new Scanner(client.getInputStream());
                String msg = scan.nextLine();
                System.out.println("Message from the server is: " + msg);

        System.out.println("-----------------> Connection Closed");
    }

}
