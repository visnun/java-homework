package lesson7.task1;

public class Teacher extends Human implements TeachAble{
    private String teaching;

    public Teacher(String name, int age, String subject) {
        super(name);
        setAge(age);
        setTeaching(subject);
    }

    public void setAge(int age) {
        if (age < 21 || age >= 65) throw new IllegalArgumentException("Неподходящий возраст учителя");
        this.age = age;
    }

    public String getTeaching() {
        return teaching;
    }

    public void setTeaching(String subject) {
        if (subject == null || subject.length() < 3) throw new IllegalArgumentException("subject < 3");
        this.teaching = subject;
    }

    @Override
    public void teach(LearnAble pupil) {
        pupil.learn();
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "teaching='" + teaching + '\'' +
                '}';
    }
}
