package com.fortuna;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class MioThread extends Thread {
    Socket s;

    public MioThread(Socket mioSocket) throws NumberFormatException, IOException {
        this.s = mioSocket;
    }

    public void run() {
        try {
            System.out.println("Qualcuno si è collegato");
            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            PrintWriter out;
            out = new PrintWriter(s.getOutputStream(), true);

            out.println("Versione server: 1.3");
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
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}