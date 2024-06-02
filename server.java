import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class server {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(6000)) {
            System.out.println("Server started. Waiting for clients...");
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected: " + clientSocket);
            DataInputStream inputStream = new DataInputStream(clientSocket.getInputStream());//read data from the client
            DataOutputStream outputStream = new DataOutputStream(clientSocket.getOutputStream());//send data to the client
            Thread inputThread = new Thread(() -> {//created to handle server side input
                try {
                    Scanner scanner = new Scanner(System.in);
                    while (true) {
                        System.out.print("Server: ");
                        String message = scanner.nextLine();
                        outputStream.writeUTF(message);//sends message to the connected client
                        outputStream.flush();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            inputThread.start();
            while (true) {
                String receivedMessage = inputStream.readUTF();

                System.out.println("Client: " + receivedMessage);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
