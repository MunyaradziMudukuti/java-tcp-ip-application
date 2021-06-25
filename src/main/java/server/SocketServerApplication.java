package server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class SocketServerApplication {

    static int close = 0;

    public static void main(String args[]) throws IOException {

        ServerSocket server = new ServerSocket(2021); // server creation

       START: while (close == 0) {

            try {

                Socket s = server.accept(); // server in waiting state

                Scanner sc = new Scanner(System.in);

                Scanner scan = new Scanner(s.getInputStream());

                String message = scan.nextLine();

                String messageToClient = sc.nextLine();

                System.out.println("The client said: " + message);

                //Send a message to the client
                PrintWriter pw = new PrintWriter(s.getOutputStream());

                System.out.println("Please enter message:");

                if (messageToClient.equalsIgnoreCase("exit")) {
                    close = 1;
                    server.close();

                }

                pw.println(messageToClient);

                pw.flush(); //From the buffer to you, and refresh the buffer

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        System.out.println("-----------------> Connection Closed");

    }

}
