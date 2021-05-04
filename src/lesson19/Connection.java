package lesson19;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Connection implements AutoCloseable{
    private Socket socket;
    private ObjectInputStream input;
    private ObjectOutputStream output;

    public Connection(Socket socket) throws IOException {
        this.socket = socket;
        // getOutputStream() - получаем стрим от сокета
        // здесь важна последовательность. Сначала outputStream, потом inputStream
        output = new ObjectOutputStream(socket.getOutputStream());
        input = new ObjectInputStream(socket.getInputStream());
    }

    public void sendMessage(SimpleMessage message) throws IOException {
        message.setDateTime();
        output.writeObject(message);
        // flush() - передаем преобразованные байты в outputStream
        output.flush();
    }

    public SimpleMessage readMessage() throws IOException, ClassNotFoundException {
        return (SimpleMessage) input.readObject();
    }

    // Т.к. реализовали AutoCloseable нужно переопределить метод close() в котором нужно закрыть все ресурсы.
    @Override
    public void close() throws Exception {
        input.close();
        output.close();
        socket.close();
    }
}
