package multithreading.lesson27;

import java.util.concurrent.ArrayBlockingQueue;

public class App {
    public static void main(String[] args) {
        ArrayBlockingQueue<Order> clientCook = new ArrayBlockingQueue<>(1);
        ArrayBlockingQueue<Order> clientWaiter = new ArrayBlockingQueue<>(1);
        ArrayBlockingQueue<Order> waiterCook = new ArrayBlockingQueue<>(1);

        new Thread(new Client(clientWaiter, clientCook)).start();
        new Thread(new Waiter(clientWaiter, waiterCook)).start();
        new Thread(new Cook(waiterCook, clientCook)).start();
    }
}

