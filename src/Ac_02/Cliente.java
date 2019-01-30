package Ac_02;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cliente {

    public static void main(String[] args) throws UnknownHostException, IOException, InterruptedException {
        Scanner tec = new Scanner(System.in);
        DataInputStream in;
        DataOutputStream out;
        String msg;
        boolean conversacionActiva = true;

        try {
            Socket sc = new Socket(args[0], 666);
            in = new DataInputStream(sc.getInputStream());
            out = new DataOutputStream(sc.getOutputStream());
            while (conversacionActiva) {
                out.writeUTF(tec.nextLine());
                msg = in.readUTF();
                System.out.printf(msg);
                System.out.println();
                out.flush();
                if (msg.contains("adios")) {
                    conversacionActiva = false;
                }
            }
            sc.close();
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}