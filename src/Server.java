import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException, InterruptedException {
        ServerSocket s = new ServerSocket(5000);

        //init
        ObjectInput oi;
        ObjectOutput oo;
        int num1, num2;
        Socket socket;
        while (true){
            System.out.println("Waiting for connection.");
            socket = s.accept();

            oi = new ObjectInputStream(socket.getInputStream());
            num1 = oi.readInt();
            num2 = oi.readInt();
            socket.shutdownInput();

            System.out.println("Got numbers " + num1 + " and " + num2 + ".");
            System.out.println("Sum is " + (num1 + num2));

            oo = new ObjectOutputStream(socket.getOutputStream());
            oo.writeInt(num1 + num2);
            oo.flush(); // pri .close() nastane chyba !!

            socket.shutdownOutput();

            System.out.println("Connection served.");
        }
    }
}
