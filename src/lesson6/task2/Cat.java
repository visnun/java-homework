package lesson6.task2;

import java.util.Arrays;
import java.util.Objects;

public class Cat {
    // Кот: имя, цвет, скорость, вес, пойманные мыши;
    private String name;
    private String color;
    private int speed;
    private double weight;
    private Mouse[] mice = new Mouse[40];

    public Cat(String name, String color, int speed, double weight) {
        setName(name);
        setColor(color);
        setSpeed(speed);
        setWeight(weight);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.length() < 3) throw new IllegalArgumentException("name < 3");
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        if (color == null || color.length() < 3) throw new IllegalArgumentException("color < 3");
        this.color = color;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        if (speed <= 0) throw new IllegalArgumentException("speed < =0");
        this.speed = speed;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        if (weight <= 0) throw new IllegalArgumentException("weight < 0");
        this.weight = weight;
    }

    public Mouse[] getMice() {
        return mice;
    }

    public void catChMouse(Mouse mouse) {
        Objects.requireNonNull(mouse, "mouse не может быть null");
        if (this.getSpeed() > mouse.getSpeed()) {
            for (int i = 0; i < mice.length; i++) {
                if (mice[i] == null) {
                    mice[i] = mouse;
                    return;
                }
                System.out.println("Нет мест для мышей");
            }
        } else {
            System.out.println("Мышь убежала");
        }
    }

    public void attackOtherCat(Cat cat) {
        Objects.requireNonNull(cat, "cat не может быть null");
        if (this.weight > cat.getWeight()) {
            for (int i = 0; i < cat.getMice().length; i++) {
                if (cat.getMice()[i] == null) break;
                catChMouse(cat.getMice()[i]);
            }
            cat.mousesToNull();
            return;
        }
        System.out.println("Этот кот больше. Его нельзя атаковать");
    }

    public void mousesToNull() {
        this.mice = new Mouse[40];
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", speed=" + speed +
                ", weight=" + weight +
                ", mouses=" + Arrays.toString(mice) +
                '}';
    }
}
