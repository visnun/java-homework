package multithreading.lesson27;

public class Order {
    private String status = "Создан";

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Order{" +
                "status='" + status + '\'' +
                '}';
    }
}
