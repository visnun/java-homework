package lesson14;

import java.util.*;

public class MapTask {
    public static void main(String[] args) {
        // TODO:: написать статический метод, который принимает на вход мапу (например, firstTaskMap) и город (например, city),
        //  формирует и возвращает список (List) логинов, которые соответствуют переданному городу

        HashMap<String, String> firstTaskMap = new HashMap<>();
        firstTaskMap.put("qwe", "Тверь");
        firstTaskMap.put("asd", "Тверь");
        firstTaskMap.put("zxc", "Москва");
        firstTaskMap.put("rty", "Тверь");
        firstTaskMap.put("fgh", "Магадан");

        String city = "Тверь";
        List<String> cities = containsCity(firstTaskMap, city);
        System.out.println(cities);


        // TODO:: дан список слов (например, words).
        //  Написать статический метод, который будет возвращать количество одинаковых слов с списке
        //  в виде Map<String, Integer>, где String - слово и Integer - количество повторений

        List<String> words = new ArrayList<>();
        words.add("may");
        words.add("august");
        words.add("june");
        words.add("may");
        words.add("may");
        words.add("july");
        words.add("may");
        words.add("august");
        words.add("august");

        Map<String, Integer> wordsCount = MapTask.wordsCount(words);
        System.out.println(wordsCount);



        // TODO:: дана мапа (например, customerMap).
        //  Написать статический метод, который принимает на вход аргументы int from и int to и возвращает
        //  новую мапу, в которую войдут все покупатели, возраст которых находится в диапазоне [from, to)

        HashMap<String, Customer> customerMap = new HashMap<>();
        customerMap.put("1", new Customer("Павел", "1", 23));
        customerMap.put("2", new Customer("Олег", "2", 17));
        customerMap.put("3", new Customer("Максим", "3", 48));
        customerMap.put("4", new Customer("Евгения", "4", 67));

        Map<Integer, Customer> customerByAge = customerByAge(customerMap, 15, 30);
        System.out.println(customerByAge);


        // TODO:: Задания по тексту (text). На каждый пункт - минимум один метод:
        //  1. написать метод, принимающий на вход слово и возвращающий частоту
        //  встречаемости данного слова в тексте
        //  2. написать метод, который собирает все слова в группы
        //  по количеству букв:
        //  например, в одну группу попадут слова:
        //  3 - [the, war, jar, get, met...],
        //  в другую 2 - [on, up, no, of...] и тд
        //  результат сохранить в Map<Integer, ArrayList>
        //  3. написать метод, который выводит в консоль топ 10 самых частых слов
        //  4. вывести частоту встречаемости букв английского алфавита в данном тексте. Вывести в процентах для каждой буквы

        // в тексте содержатся только буквы и пробельные символы
        String text = "It is a uncover long established fact that a reader will be distracted uncover by the readable content of a page " +
                "when looking at its layout The point of using uncover Lorem Ipsum is that sites it has a more-or-less normal distribution of letters" +
                "as uncover opposed to still using Content here humour uncover content here making it look like readable English Many desktop publishing " +
                "packages and web page editors now use Lorem Ipsum as their default model text and a search for lorem ipsum will " +
                "uncover many web sites still uncover in their infancy Various versions uncover have evolved over the years uncover sometimes by accident" +
                " sometimes on purpose injected humour and the like";

        int count = wordCount(text, "it");
        System.out.println(count);

        Map<Integer, ArrayList<String>> wordsByLength = wordsByLength(text);
        System.out.println(wordsByLength);

        // topTenWords(text);

    }

    public static List<String> containsCity(HashMap<String, String> map, String city) {
        List<String> cityList = new ArrayList<>();
        for (Map.Entry<String, String> stringStringEntry : map.entrySet()) {
            if (stringStringEntry.getValue().equalsIgnoreCase(city)) cityList.add(stringStringEntry.getKey());
        }
        return cityList;
    }

    public static Map<String, Integer> wordsCount(List<String> words) {
        Map<String, Integer> wordsCountMap = new HashMap<>();
        for (String word : words) {
            wordsCountMap.put(word, wordsCountMap.getOrDefault(word, 0) + 1);
        }
        return wordsCountMap;
    }

    public static Map<Integer, Customer> customerByAge(HashMap<String,Customer> customerMap, int from, int to) {
    HashMap<Integer, Customer> customerByAgeMap = new HashMap<>();
    int index = 0;
        for (Customer customer : customerMap.values()) {
            if (customer.getAge() >= from && customer.getAge() < to) {
                customerByAgeMap.put(index, customer);
                index++;
            }
        }
        return customerByAgeMap;
    }

    public static int wordCount(String text, String word) {
        String[] textArr = text.split(" ");
        int count = 0;
        for (String w : textArr) {
            if (w.equalsIgnoreCase(word)) count++;
        }
        return count;
    }

    public static Map<Integer, ArrayList<String>> wordsByLength(String text) {
        HashSet<String> wordHashSet = new HashSet<>(Arrays.asList(text.split(" ")));
        HashMap<Integer, ArrayList<String>> wordByLength = new HashMap<>();
        for (String w : wordHashSet) {
            if (!wordByLength.containsKey(w.length())) wordByLength.put(w.length(), new ArrayList<>());
            wordByLength.get(w.length()).add(w);
        }
        return wordByLength;
    }

//    public static void topTenWords(String text) {
//    HashMap<String, Integer> topTen = new HashMap<>();
//        for (String w : text.split(" ")) {
//            topTen.put(w, topTen.getOrDefault(w, 0) + 1);
//        }
//        topTen
//        System.out.println(topTen);
//    }
}


