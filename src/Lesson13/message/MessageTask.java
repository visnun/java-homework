package Lesson13.message;

import java.util.*;

public class MessageTask {
    public static void countEachPriority(List<Message> messageList) {
        // TODO:  Подсчитать количество сообщений для каждого приоритета
        //  Ответ в консоль
//        for (Message.MessagePriority priority : Message.MessagePriority.values()) {
//            int count = 0;
//            for (Message message : messageList) {
//                if (message.getPriority().name().equals(priority.name())) count++;
//            }
//            System.out.println("Сообщений с приоритетом " + priority.name() + ": " + count);
//        }

        int[] counts = new int[Message.MessagePriority.values().length];
        for (Message message : messageList) {
            counts[message.getPriority().ordinal()]++;
        }


    }

    public static void countEachCode(List<Message> messageList) {
        // TODO: Подсчитать количество сообщений для каждого кода сообщения
        //  Ответ в консоль
//        HashSet<Integer> codes = new HashSet<>();
//        for (Message message : messageList) {
//            codes.add(message.getCode());
//        }
//        for (Integer code : codes) {
//            int count = 0;
//            for (Message message : messageList) {
//                if (message.getCode() == code) count++;
//            }
//
//            System.out.println("Сообщений с кодом " +code + ": " + count);
//        }
//        codes.clear();
        HashMap<Integer, Integer> countMap = new HashMap<>();
//        for (Message message : messageList) {
//            if (countMap.containsKey(message.getCode())) {
//                countMap.put(message.getCode(), countMap.get(message.getCode()) + 1);
//            } else {
//                countMap.put(message.getCode(), 1);
//            }
//        }

        for (Message message : messageList) {
            countMap.put(message.getCode(), countMap.getOrDefault(message.getCode(), 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void uniqueMessageCount(List<Message> messageList) {
        // TODO: Подсчитать количество уникальных сообщений
        //  Ответ в консоль
        System.out.println("Количество уникальных сообщений: " + new HashSet<>(messageList).size());
    }

    public static List<Message> uniqueMessagesInOriginalOrder(List<Message> messageList) {
        // TODO: вернуть только неповторяющиеся сообщения и в том порядке,
        //  в котором они встретились в первоначальном списке
        //  Например, было: [{URGENT, 4}, {HIGH, 9}, {LOW, 3}, {HIGH, 9}]
        //  на выходе: [{URGENT, 4}, {HIGH, 9}, {LOW, 3}]
        //  LinkHashSet - сделать
//        ArrayList<Message> messageArrayList = new ArrayList<>();
//        for (Message message : messageList) {
//            if (!messageArrayList.contains(message)) messageArrayList.add(message);
//        }
//        return messageArrayList;
        return new ArrayList<>(new LinkedHashSet<>(messageList));
    }

    public static List<Message> copyEach(List<Message> messageList, Message.MessagePriority priority) {
        // TODO: создать коллекцию и передать в нее ссылки на каждое сообщение с заданным приоритетом
        //  метод должен вернуть новую коллекцию
        List<Message> messagesWithGivenPriority = new ArrayList<>();
        for (Message message : messageList) {
            if (message.getPriority().name().equals(priority.name())) messagesWithGivenPriority.add(message);
        }
        return messagesWithGivenPriority;
    }

    public static List<Message> copyOther(List<Message> messageList, Message.MessagePriority priority) {
        // TODO: создать коллекцию и передать в нее ссылки на все сообщения, кроме тех, которые имеют заданный приоритет
        //  метод должен вернуть новую коллекцию
        return null;
    }

    public static void main(String[] args) {
        List<Message> messages = Message.MessageGenerator.generate(34);
        System.out.println(messages);
        // вызов методов
        MessageTask.countEachPriority(messages);
        MessageTask.countEachCode(messages);
        MessageTask.uniqueMessageCount(messages);
        List<Message> messageList = uniqueMessagesInOriginalOrder(messages);

    }
}
