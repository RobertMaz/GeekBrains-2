import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(8181))
        {
            System.out.println("Server started");
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            while(true){
                String s = in.readUTF();
                System.out.println(s    );
                out.writeUTF("echo: " + s);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
