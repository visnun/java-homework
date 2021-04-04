package lesson7.task1;

public class Principal extends Human{
    public Principal(String name, int age) {
        super(name);
        setAge(age);
    }

    public void setAge(int age) {
        if (age < 40 || age >= 65) throw new IllegalArgumentException("Неподходящий возраст директора");
        this.age = age;
    }

    public void startLessonsAnnouncement() {
        System.out.println("Начало занятий");
    }

    public void endLessonsAnnouncement() {
        System.out.println("Окончание занятий");
    }

    @Override
    public String toString() {
        return "Principal{}";
    }
}
