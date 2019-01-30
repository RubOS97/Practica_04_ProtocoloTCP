package Ac_01;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cliente {

    public static void main(String[] args) throws UnknownHostException, IOException, InterruptedException {
        DataInputStream in;
        DataOutputStream out;

        try {
            Socket sc = new Socket(InetAddress.getLocalHost(), 666);
            in = new DataInputStream(sc.getInputStream());
            out = new DataOutputStream(sc.getOutputStream());

            System.out.println("Enviando mensaje al servidor");
            out.writeUTF("Hola server soy el cliente:" + args[0]);

            String mensaje = in.readUTF();
            System.out.println(mensaje);
            out.flush();
            Thread.sleep(1000);
            sc.close();
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}