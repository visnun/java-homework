package lesson19;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.Socket;

public class Connection implements AutoCloseable{
    private Socket socket;
    private ObjectInputStream input;
    private ObjectOutputStream output;

    public Connection(Socket socket) throws IOException {
        this.socket = socket;
        output = new ObjectOutputStream(socket.getOutputStream());
        input = new ObjectInputStream(socket.getInputStream());
    }

    public void sendMessage(SimpleMessage message) throws IOException {
        message.setDateTime();
        output.writeObject(message);
        output.flush();
    }

    public SimpleMessage readMessage() throws IOException, ClassNotFoundException {
        return (SimpleMessage) input.readObject();
    }

    public void sendImage(File file) throws IOException {
        OutputStream stream = socket.getOutputStream();
        BufferedImage bufferedImage = ImageIO.read(file);
        ImageIO.write(bufferedImage, "jpg", stream);
        stream.flush();
    }

    public BufferedImage getImage() throws IOException {
        InputStream inputStream = socket.getInputStream();
        return ImageIO.read(inputStream);
    }

    @Override
    public void close() throws Exception {
        input.close();
        output.close();
        socket.close();
    }
}
