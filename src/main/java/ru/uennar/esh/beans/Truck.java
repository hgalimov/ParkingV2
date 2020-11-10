package ru.uennar.esh.beans;

import org.springframework.stereotype.Component;
import ru.uennar.esh.model.Car;

@Component
public class Truck extends Car {
    @Override
    public void getId() {
        System.out.println("Truck");
    }
}
