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

        int n1 = Integer.parseInt(in.readLine());
        int n2 = Integer.parseInt(in.readLine());
        int op = Integer.parseInt(in.readLine());

        out.println(svolgiOperazione(n1, n2, op));

        mioServerSocket.close();

    }

    public static double svolgiOperazione(int num1, int num2, int ope) throws Exception {

        double ris;

        switch (ope) {
            case 1:
                ris = num1 + num2;
                break;

            case 2:
                ris = num1 - num2;
                break;

            case 3:
                ris = num1 / num2;
                break;

            case 4:
                ris = num1 * num2;
                break;

            default:
                throw new Exception("Codice operazione non valido");

        }

        return ris;
    }
}