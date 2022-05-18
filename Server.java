package chatapp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        ServerSocket ss = new ServerSocket(9999);
        System.out.println("Waiting for client...");
        Socket s = ss.accept();
        System.out.println("Client connected.");

        DataOutputStream outputToClient = new DataOutputStream(s.getOutputStream());
        DataInputStream inputFromClient = new DataInputStream(s.getInputStream());

        while (!s.isClosed()) {
            System.out.println("Client :" + inputFromClient.readUTF());
            System.out.print("Server :");
            String str = sc.nextLine();
            outputToClient.writeUTF(str);

        }
    }
}
