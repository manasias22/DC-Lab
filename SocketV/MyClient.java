import java.io.*;
import java.net.*;
import java.util.Scanner;


public class MyClient {
    public static void main(String[] args) {
      

        try {
            Scanner sc = new Scanner(System.in);
            
            Socket s = new Socket("localhost", 6666);

            DataOutputStream dout = new DataOutputStream(s.getOutputStream());

            System.out.println("Enter your message: ");
            String input = sc.nextLine();

            dout.writeUTF(input);
            dout.flush();

            dout.close();
            s.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    
    }
}