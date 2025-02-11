import java.io.*;
import java.net.*;
import java.util.*;

public  class KierkiServer{
    private static final int PORT = 12345;
    private static Map<String, GameRoom> rooms = new HashMap<>();
    private static List<ClientHandler> clients = new ArrayList<>();

    public static void main(String[] args) {
        try(ServerSocket serverSocket = new ServerSocket(PORT)){
            System.out.println("serwer kierków uruchomiony na porcie "+ PORT);

            while (true){
                Socket socket = serverSocket.accept();
                ClientHandler client = new ClientHandler(socket);
                clients.add(client);
                new Thred(client).start();

            }
        }catch ( IOException e){
            e.pritStackTrace();

        }
    }
    static void broadcast(String message){
        for (ClientHandler client : clients){
            client.sendMessage(message);
        }
    }

}