package chatapp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        Socket s = new Socket("localhost", 9999);
        System.out.println("connected to server.\n");

        DataInputStream inputFromServer = new DataInputStream(s.getInputStream());
        DataOutputStream outputToServer = new DataOutputStream(s.getOutputStream());

        System.out.print("Client :");
        String str = sc.nextLine();

        while (!str.equals("exit")) {

            outputToServer.writeUTF(str);
            System.out.println("Server :" + inputFromServer.readUTF());
            System.out.print("Client :");
            str = sc.nextLine();
        }
        s.close();


    }
}
