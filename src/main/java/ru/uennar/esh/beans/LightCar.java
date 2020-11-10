package ru.uennar.esh.beans;

import org.springframework.stereotype.Service;
import ru.uennar.esh.model.Car;

@Service
public class LightCar extends Car {
    @Override
    public void getId() {
        System.out.println("LightCar");
    }
}
