package lesson19;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private String ip;
    private int port;
    private Scanner scanner;
    private String[] commandList = {"/help", "/count", "/ping", "/exit"};
    

    public Client(String ip, int port) {
        this.ip = ip;
        this.port = port;
        scanner = new Scanner(System.in);
    }
    
    public void start() {
        String command;
        while (true) {
            System.out.println("Введите команду. Для получения списка команд введите /help");
            command = scanner.nextLine();
            if ("/exit".equalsIgnoreCase(command)) {
                break;
            } else if ("/help".equalsIgnoreCase(command)) {
                printCommandList();
            } else {
                sendCommandAndPrintAnswer(SimpleMessage.getMessage("user", command));
            }
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

    private void printCommandList() {
        for (String command : commandList) {
            System.out.println(command);
        }
    }
}
