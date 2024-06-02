import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class client {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 6000);
                Scanner scanner = new Scanner(System.in);
                DataInputStream inputStream = new DataInputStream(socket.getInputStream());
                DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream())) {
            System.out.println("Connected to server.");
            Thread inputThread = new Thread(() -> {
                try {
                    while (true) {
                        String response = inputStream.readUTF();
                        System.out.println("Server: " + response);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            inputThread.start();
            while (true) {
                System.out.print("You: ");
                String message = scanner.nextLine();
                outputStream.writeUTF(message);
                outputStream.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
