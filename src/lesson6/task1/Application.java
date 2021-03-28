package lesson6.task1;

public class Application {
    public static void main(String[] args) {
        Author author1 = new Author("Имя1", "Фамилия1");
        Author author2 = new Author("Имя2", "Фамилия2");
        Author author3 = new Author("Имя3", "Фамилия3");
        System.out.println(author1);
        System.out.println(author2);
        System.out.println(author3);

        Book book1 = new Book("Название1", 150, 1956, author1, author2, author3);
        Book book2 = new Book("Название2", 200, 1999, author1);
        System.out.println(book1);
        System.out.println(book2);
        System.out.println(book1.getAuthors());

        Storage storage = new Storage();
        storage.addBooks(book1);
        storage.addBooks(book2);
        storage.addBooks(book2);
        System.out.println(storage);
    }
}
