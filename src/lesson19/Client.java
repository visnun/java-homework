package lesson19;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private final String ip;
    private final int port;
    private final Scanner scanner;


    public Client(String ip, int port) {
        this.ip = ip;
        this.port = port;
        scanner = new Scanner(System.in);
    }
    
    public void start() {
        String command;
        while (true) {
            System.out.println("Введите команду (/help - список команд) :");
            command = scanner.nextLine();
            sendCommandAndPrintAnswer(SimpleMessage.getMessage("user", command));
            if ("/exit".equalsIgnoreCase(command)) break;
        }
    }

    private void sendCommandAndPrintAnswer(SimpleMessage message) {
        try (Connection connection = new Connection(new Socket(ip, port))) {
            connection.sendMessage(message);

            SimpleMessage fromServer = connection.readMessage();
            System.out.println(fromServer.getText());
        } catch (IOException e) {
            System.out.println("Соединение потеряно");
        } catch (ClassNotFoundException e) {
            System.out.println("Ошибка чтения сообщения");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
