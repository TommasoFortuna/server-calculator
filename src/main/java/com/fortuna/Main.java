package com.fortuna;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Server avviato");

        ServerSocket mioServerSocket = new ServerSocket(3000);
        Socket mioSocket = mioServerSocket.accept();
        System.out.println("Qualcuno si è collegato");

        BufferedReader in = new BufferedReader(new InputStreamReader(mioSocket.getInputStream()));
        PrintWriter out = new PrintWriter(mioSocket.getOutputStream(), true);

        out.println("Versione server: 1.2");
        System.out.println(in.readLine());

        int op;
        do {
            int n1 = Integer.parseInt(in.readLine());
            int n2 = Integer.parseInt(in.readLine());
            op = Integer.parseInt(in.readLine());

            if (op == 0) {
                out.println("Connection closed");
                break;

            }

            float ris;

            switch (op) {
                case 1:
                    ris = n1 + n2;
                    break;

                case 2:
                    ris = n1 - n2;
                    break;

                case 3:
                    ris = (float) n1 / n2;
                    break;

                case 4:
                    ris = n1 * n2;
                    break;

                default:
                    ris = -1;
                    break;
            }

            if (ris == -1)
                out.println("error 104");
            else
                out.println(ris);

        } while (true);

        mioServerSocket.close();

    }
}