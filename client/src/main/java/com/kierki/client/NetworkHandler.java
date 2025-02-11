import java.io.*;
import java.net.Socket;

public class NetworkHandler {
    private static Socket socket;
    private static PrintWriter out;
    private static BufferedReader in;

    static {
        try {
            socket = new Socket("localhost", 12345);
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String sendRequest(String request) {
        try {
            out.println(request);
            return in.readLine();
        } catch (IOException e) {
            return "ERROR";
        }
    }
}
