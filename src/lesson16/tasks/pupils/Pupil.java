package lesson16.tasks.pupils;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

public class Pupil {
    enum Gender {
        MALE, FEMALE
    }
    private final UUID number; // уникальное значение для каждого ученика
    private String name;
    private Gender gender;
    private LocalDate birth;

    // TODO: добавить все необходимые методы


    public Pupil(String name, Gender gender, LocalDate birth) {
        number = UUID.randomUUID();
        setName(name);
        setGender(gender);
        setBirth(birth);
    }

    public UUID getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        Objects.requireNonNull(gender);
        this.gender = gender;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(LocalDate birth) {
        Objects.requireNonNull(birth);
        this.birth = birth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pupil pupil = (Pupil) o;

        if (number != null ? !number.equals(pupil.number) : pupil.number != null) return false;
        if (name != null ? !name.equals(pupil.name) : pupil.name != null) return false;
        if (gender != pupil.gender) return false;
        return birth != null ? birth.equals(pupil.birth) : pupil.birth == null;
    }

    @Override
    public int hashCode() {
        int result = number != null ? number.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (birth != null ? birth.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Pupil{" +
                "name='" + name + '\'' +
                ", gender=" + gender +
                ", birth=" + birth +
                ", number=" + number +
                '}';
    }
}