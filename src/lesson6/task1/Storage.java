package lesson6.task1;

import java.util.Arrays;
import java.util.Objects;
import java.util.UUID;

public class Storage {
    private Book[] books = new Book[20];
    private UUID uuid;

    public Storage() {
        setUuid();
    }

    public String getBooks() {
        return Arrays.toString(books);
    }

    public void setBooks(Book book) {
        Objects.requireNonNull(book, "book не може быть null");
        for (int i = 0; i < books.length; i++) {
            if (books[i] == null) {
                books[i] = book;
                return;
            }
            if (books[i].getName().equalsIgnoreCase(book.getName())) {
                System.out.println("Такая книга уже есть в хранилище");
                return;
            }

        }
        System.out.println("В хранилище нет мест");
    }

    public UUID getUuid() {
        return uuid;
    }

    private void setUuid() {
        uuid = UUID.randomUUID();
    }

    @Override
    public String toString() {
        return "Storage{" +
                "books=" + Arrays.toString(books) +
                ", uuid=" + uuid +
                '}';
    }
}


