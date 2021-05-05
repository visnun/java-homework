package lesson19;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private final int port;
    private Connection connection;
    private int connectionCount;
    private final String commandList = "Список доступных команд\n/help\n/count\n/ping\n/exit\n";

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
                commandHandler(message.getText());
            }
        } catch (IOException e) {
            System.out.println("Ошибка сервера");
        } catch (ClassNotFoundException e) {
            System.out.println("Ошибка чтения сообщения");
        }
    }



    public void receiveImage() {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Принимаю изображение");
            while (true) {
                Socket newClient = serverSocket.accept();
                connection = new Connection(newClient);
                BufferedImage bufferedImage = connection.getImage();
                ImageIO.write(bufferedImage, "jpg", new File("newFile.jpg"));
            }
        } catch (IOException e) {
            System.out.println("Ошибка");
        }
    }

    private void commandHandler(String command) throws IOException {
        if ("/exit".equalsIgnoreCase(command)) {
            connection.sendMessage(SimpleMessage.getMessage("Сервер", "Выход"));
        }
        if ("/count".equalsIgnoreCase(command)) {
            connection.sendMessage(SimpleMessage.getMessage("Сервер", "Количество клиентов, которые подключались к серверу " + connectionCount));
        }
        if ("/ping".equalsIgnoreCase(command)) {
            connection.sendMessage(SimpleMessage.getMessage("Сервер", "time: 6.10 ms"));
        }
        if ("/help".equalsIgnoreCase(command)) {
            connection.sendMessage(SimpleMessage.getMessage("Сервер", commandList));
        } else {
            connection.sendMessage(SimpleMessage.getMessage("Сервер", "Команда не найдена"));
        }
    }

}
