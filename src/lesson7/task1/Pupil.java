package lesson7.task1;

public class Pupil extends Human implements LearnAble{
    private String learning;
    private int knowledgeLevel;

    public Pupil(String name, int age, String subject) {
        super(name);
        setAge(age);
        setLearning(subject);
        knowledgeLevel = 0;
    }

    public String getLearning() {
        return learning;
    }

    public void setLearning(String subject) {
        if (subject == null || subject.length() < 3) throw new IllegalArgumentException("subject < 3");
        this.learning = subject;
    }

    public int getKnowledgeLevel() {
        return knowledgeLevel;
    }

    public void setAge(int age) {
        if (age < 7 || age >= 17) throw new IllegalArgumentException("Неподходящий возраст ученика");
        this.age = age;
    }

    @Override
    public void learn() {
        knowledgeLevel += 1;
    }

    @Override
    public String toString() {
        return "Pupil{" +
                "learning='" + learning + '\'' +
                ", knowledgeLevel=" + knowledgeLevel +
                '}';
    }
}
