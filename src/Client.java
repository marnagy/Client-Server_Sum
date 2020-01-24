import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader defaultBIS = new BufferedReader(new InputStreamReader(System.in));

        ObjectInput oi;
        ObjectOutput oo;
        Socket socket;
        int num1, num2, result;
        while (true){
            num1 = Integer.parseInt(defaultBIS.readLine());
            num2 = Integer.parseInt(defaultBIS.readLine());

            socket = new Socket("localhost", 5000);

            oo = new ObjectOutputStream(socket.getOutputStream());
            oo.writeInt(num1);
            oo.writeInt(num2);
            oo.flush();

            oi = new ObjectInputStream(socket.getInputStream());
            result = oi.readInt();

            System.out.println("Result: " + result);

            socket.close();
        }
    }
}
