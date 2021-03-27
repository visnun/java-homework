package lesson6.task1;

public class Author {
    private String name;
    private String lastName;

    public Author(String name, String lastName) {
        setName(name);
        setLastName(lastName);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.length() < 3) throw new IllegalArgumentException("name < 3");
        this.name = name.trim();
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName == null || lastName.length() < 3) throw new IllegalArgumentException("lastName < 3");
        this.lastName = lastName.trim();
    }

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
