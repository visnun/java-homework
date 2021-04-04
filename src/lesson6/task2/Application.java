package lesson6.task2;

public class Application {
    public static void main(String[] args) {
        /*
        Кот: имя, цвет, скорость, вес, пойманные мыши;
        Мышь: скорость.
        Кот хранит информацию о пойманных мышах (максимум 100).
        Кот ловит мышь, только, если его скорость выше, чем у мыши.
        Кот может напасть на другого кота и, если он больше противника (по весу),
        то может отобрать его мышей (если скорость мыши выше, чем скорость кота, она убежит),
        массив с мышами противника нужно обнулить (всем элементам присвоить значение null).
         */
        Mouse mouse1 = new Mouse(5);
        Cat cat1 = new Cat("cat1", "black", 6, 8.5);
        cat1.setSpeed(6);
        cat1.catchMouse(mouse1);
//        System.out.println(cat1);
        Cat cat2 = new Cat("cat2", "white", 6, 7);
//        System.out.println(cat2);
        cat2.catchMouse(mouse1);
        cat1.attackOtherCat(cat2);
        System.out.println(cat1);
        System.out.println(cat2);

    }
}
