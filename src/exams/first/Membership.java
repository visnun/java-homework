package exams.first;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Objects;

public class Membership {
    private Type type;
    private final LocalDateTime created;
    private LocalDateTime expired;
    private Owner owner;

    public Membership(String type, Owner owner) {
        created = LocalDateTime.now();
        setType(type);
        setOwner(owner);
        setExpired();
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public LocalDateTime getExpired() {
        return expired;
    }

    public void setExpired() {
        expired = created.plusYears(1);
    }

    public Type getType() {
        return type;
    }

    public void setType(String type) {
        if ("Разовый".equalsIgnoreCase(type.trim())) {
            this.type = Type.SINGLE;
        }
        else if ("Дневной".equalsIgnoreCase(type.trim())) {
            this.type = Type.FULL_DAY;
        }
        else if ("Полный".equalsIgnoreCase(type.trim())) {
            this.type = Type.FULL;
        }
        else {
            throw new IllegalArgumentException("Тип абонемента указан некорректно");
        }
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        Objects.requireNonNull(owner, "Владелец указан некорректно");
        this.owner = owner;
    }


    enum Type {
        SINGLE("По разовому абонементу клиенты могут посещать бассейн и тренажерный зал с 8 до 22 часов.",
                new String[]{"бассейн", "тренажерный зал"},
                new LocalTime[]{LocalTime.of(8,0), LocalTime.of(22,0)}),
        FULL_DAY("По данному абонементу клиенты могут посещать тренажерный зал и групповые занятия (но не бассейн) с 8 до 16 часов.",
                new String[]{"тренажерный зал", "групповые занятия"},
                new LocalTime[]{LocalTime.of(8,0), LocalTime.of(16,0)}),
        FULL("По данному абонементу клиенты могут посещать тренажерный зал, бассейн и групповые занятия с 8 до 22 часов.",
                new String[]{"тренажерный зал", "бассейн", "групповые занятия"},
                new LocalTime[]{LocalTime.of(8,0), LocalTime.of(22,0)});
        private final String[] zones;
        private final LocalTime[] visitTime;
        private final String description;

        Type(String description, String[] zones, LocalTime[] time) {
            this.description = description;
            this.zones = zones;
            this.visitTime = time;
        }

        public String getDescription() {
            return description;
        }

        public String[] getZones() {
            return zones;
        }

        public LocalTime[] getVisitTime() {
            return visitTime;
        }
    }
}
