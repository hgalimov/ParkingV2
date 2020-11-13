package ru.uennar.esh.model;

import org.springframework.stereotype.Component;

@Component
public enum CarType {
    LIGHT_CAR("Легковой автомобиль"), TRUCK("Грузовой автомобиль");
    private final String name;

    CarType(String name) {
        this.name = name;
    }

    public String toString() {
        return this.name;
    }
}
