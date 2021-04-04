package lesson6.task1;

import java.util.Arrays;
import java.util.Objects;

public class Book {
    private String name;
    private Author[] authors;
    private int pagesCount;
    private int publicationDate;

    public Book(String name, int pagesCount, int publicationDate, Author... authors) {
        setName(name);
        setAuthors(authors);
        setPagesCount(pagesCount);
        setPublicationDate(publicationDate);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().length() < 3) throw new IllegalArgumentException("name < 3");
        this.name = name;
    }

    public Author[] getAuthors() {
        return authors;
    }

    public void setAuthors (Author[] authors) {
        Objects.requireNonNull(authors, "authors не может быть null"); // TODO проверить на пустой массив
        this.authors = Arrays.copyOf(authors, authors.length);
    }

    public int getPagesCount() {
        return pagesCount;
    }

    public void setPagesCount(int pagesCount) {
        if (pagesCount < 50) throw new IllegalArgumentException("pagesCount < 50");
        this.pagesCount = pagesCount;
    }

    public int getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(int publicationDate) {
        if (publicationDate < 1000) throw new IllegalArgumentException("publicationDate < 1000");
        this.publicationDate = publicationDate;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", authors=" + Arrays.toString(authors) +
                ", pagesCount=" + pagesCount +
                ", publicationDate=" + publicationDate +
                '}';
    }
}
