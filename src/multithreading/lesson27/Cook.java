package multithreading.lesson27;

import java.util.concurrent.ArrayBlockingQueue;

public class Cook implements Runnable {
    private final ArrayBlockingQueue<Order> waiterCook;
    private final ArrayBlockingQueue<Order> clientCook;

    public Cook(ArrayBlockingQueue<Order> waiterCook, ArrayBlockingQueue<Order> clientCook) {
        this.waiterCook = waiterCook;
        this.clientCook = clientCook;
    }

    @Override
    public void run() {
        Order order = null;
        try {
            order = waiterCook.take();
            order.setStatus(order.getStatus() + ", передан повару");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            clientCook.put(order);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
