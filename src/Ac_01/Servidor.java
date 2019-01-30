package Ac_01;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Servidor {

    public static void main(String[] args) throws IOException {
        ServerSocket servidor = null;
        Socket sc = null;
        DataInputStream in;
        DataOutputStream out;
        String msg;

        try {
            servidor = new ServerSocket(666);
            System.out.println("--- Servidor iniciado ---");
            for (int i = 0; i < 3; i++) {
                sc = servidor.accept();
                System.out.println("--- Cliente conectado ---");
                in = new DataInputStream(sc.getInputStream());
                out = new DataOutputStream(sc.getOutputStream());
                msg = in.readUTF();
                System.out.println(msg);
                out.writeUTF("Hola Cliente " + msg);
                System.out.println("Cliente desconectado");
            }
            System.out.println("Servidor full");
            sc.close();
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}