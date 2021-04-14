package exams.first;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Objects;

public class FitnessClub {
    private final int zoneCapacity = 20;

    private Membership[] pool = new Membership[zoneCapacity];
    private Membership[] groupLessons = new Membership[zoneCapacity];
    private Membership[] gym = new Membership[zoneCapacity];

    public Membership[] getPool() {
        return pool;
    }

    public Membership[] getGroupLessons() {
        return groupLessons;
    }

    public Membership[] getGym() {
        return gym;
    }

    private boolean isRegistered(Membership membership) {
        Objects.requireNonNull(membership, "Абонемент указан некорректно");
        boolean isRegistered = false;
        for (int i = 0; i < zoneCapacity; i++) {
            if (gym[i] == membership || pool[i] == membership ||
                groupLessons[i] == membership) {
                isRegistered = true;
                break;
            }
        }
        return isRegistered;
    }

    private void registerToZone(Membership[] zone, Membership membership, String zoneName) {
        Objects.requireNonNull(zone, "Должен быть указан массив-зона");
        Objects.requireNonNull(membership, "Должен быть указан абонемент");
        if (zoneName == null) throw new IllegalArgumentException("Должна быть указана зона");
        for (int i = 0; i < zone.length; i++) {
            if (zone[i] == null) {
                zone[i] = membership;
                System.out.println("Имя: " + membership.getOwner().getName() + " " + membership.getOwner().getLastName());
                System.out.println("Посещаемая зона:" + zoneName);
                System.out.println("Дата и время посещения " + LocalDateTime.now());
                return;
            }
        }
        System.out.println("Мест нет");
    }

    public void register(Membership membership, String zone) {
        Objects.requireNonNull(membership,"Должен быть передан абонемент");
        if (LocalDateTime.now().isAfter(membership.getExpired())) {
            System.out.println("Данный абонемент просрочен");
            return;
        }
        if (isRegistered(membership)) {
            System.out.println("Данный абонемент уже зарегистрирован");
            return;
        }
        if (!(Arrays.binarySearch(membership.getType().getZones(), zone.toLowerCase()) > 0)) {
            System.out.println("Данный абонемент не может посещать " + zone.toLowerCase());
            return;
        }
        if (!(LocalTime.now().isAfter(membership.getType().getVisitTime()[0]) &&
                LocalTime.now().isBefore(membership.getType().getVisitTime()[1]))) {
            System.out.println("Данный абонемент не может посещать фитнес-клуб в это время");
            return;
        }
        if ("Бассейн".equalsIgnoreCase(zone.trim())) {
            registerToZone(pool, membership, zone);
        } else if ("Групповое занятие".equalsIgnoreCase(zone.trim())) {
            registerToZone(groupLessons, membership, zone);
        } else if ("Тренажерный зал".equalsIgnoreCase(zone.trim())) {
            registerToZone(gym, membership, zone);
        } else {
            throw new IllegalArgumentException("Зона указана некорректно");
        }
    }


    public void endOfTHeDay() {
        pool = new Membership[20];
        groupLessons = new Membership[20];
        gym = new Membership[20];
    }
}

