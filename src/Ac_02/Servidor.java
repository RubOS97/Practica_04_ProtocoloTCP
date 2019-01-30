package Ac_02;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Servidor {

    public static void main(String[] args) throws IOException {
        Scanner tec = new Scanner(System.in);
        ServerSocket servidor = null;
        Socket sc = null;
        DataInputStream in;
        DataOutputStream out;
        String msg;
        boolean conversacionActiva = true;

        try {
            servidor = new ServerSocket(666);
            System.out.println("--- Servidor iniciado ---");
            sc = servidor.accept();
            in = new DataInputStream(sc.getInputStream());
            out = new DataOutputStream(sc.getOutputStream());
            while (conversacionActiva){
                msg = in.readUTF();
                out.writeUTF("[Servidor] " + msg);
                System.out.println(msg);

                if (msg.contains("adios")){
                    conversacionActiva = false;
                    out.writeUTF("Adios Cliente");
                }
            }
            System.out.println("Finalizando la conexión...");
            sc.close();
            System.out.println("Conexión finalizada");
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}