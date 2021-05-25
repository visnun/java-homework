package multithreading.lesson27;

import java.util.Objects;
import java.util.concurrent.ArrayBlockingQueue;

public class Waiter implements Runnable {
    private final ArrayBlockingQueue<Order> clientWaiter;
    private final ArrayBlockingQueue<Order> waiterCook;

    public Waiter(ArrayBlockingQueue<Order> clientWaiter, ArrayBlockingQueue<Order> waiterCook) {
        this.clientWaiter = Objects.requireNonNull(clientWaiter);
        this.waiterCook = Objects.requireNonNull(waiterCook);
    }

    @Override
    public void run() {
        Order order = null;
        try {
            order = clientWaiter.take();
            order.setStatus(order.getStatus() + ", передан официанту");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            waiterCook.put(order);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
