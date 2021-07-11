package server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class SocketServerApplication {

    static int close = 0;

    public static void main(String args[]) throws IOException {

        ServerSocket server = new ServerSocket(2021); // server creation

       START: while (close == 0) {

            try {

                Socket s = server.accept(); // server in waiting state

//                //Send a message to the client
               PrintWriter pw = new PrintWriter(s.getOutputStream());

                pw.println(LocalTime.now().toString());

                pw.flush(); //From the buffer to you, and refresh the buffer

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        System.out.println("-----------------> Connection Closed");

    }

}
