package lesson7.task1;

abstract class Human {
    private String fullName;
    protected int age;

    public Human(String name) {
        setFullName(name);
    }

    public String getFullName() {
        return fullName;
    }

    private void setFullName(String fullName) {
        if (fullName == null || fullName.length() < 3) throw new IllegalArgumentException("name не может быть меньше 3");
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }
}
