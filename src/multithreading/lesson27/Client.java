package multithreading.lesson27;

import java.util.Objects;
import java.util.concurrent.ArrayBlockingQueue;

public class Client implements Runnable {
    private final ArrayBlockingQueue<Order> clientWaiter;
    private final ArrayBlockingQueue<Order> clientCook;

    public Client(ArrayBlockingQueue<Order> clientWaiter, ArrayBlockingQueue<Order> cookClient) {
        this.clientWaiter = Objects.requireNonNull(clientWaiter);
        this.clientCook = Objects.requireNonNull(cookClient);
    }

    @Override
    public void run() {
        Order order = new Order();
        try {
            clientWaiter.put(order);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            order = clientCook.take();
            order.setStatus(order.getStatus() + ", получен клиентом.");
            System.out.println(order.getStatus());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
