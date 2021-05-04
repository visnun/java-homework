package lesson19;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private int port;
    private Connection connection;
    private int connectionCount;
    private String commandList = "/help\n /count\n /ping\n /exit\n";

    public Server(int port) {
        this.port = port;
    }

    public void start() {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Сервер запущен");

            while (true) {
                Socket newClient = serverSocket.accept();
                connection = new Connection(newClient);
                connectionCount++;
                SimpleMessage message = connection.readMessage();
                if ("/count".equalsIgnoreCase(message.getText())) {
                    connection.sendMessage(SimpleMessage.getMessage("Сервер", "Количество клиентов, которые подключались к серверу " + connectionCount));
                }
                if ("/ping".equalsIgnoreCase(message.getText())) {
                    connection.sendMessage(SimpleMessage.getMessage("Сервер", "time: 6.10 ms"));
                }
            }
        } catch (IOException e) {
            System.out.println("Ошибка сервера");
        } catch (ClassNotFoundException e) {
            System.out.println("Ошибка чтения сообщения");
        }
    }
}
