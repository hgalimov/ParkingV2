package ru.uennar.esh.beans;

import org.springframework.stereotype.Component;
import ru.uennar.esh.model.Car;
import ru.uennar.esh.model.CarType;

@Component
public class CarTypeDeterminator {
    public CarType carTypeDeterminator(Car car) {
        if (car instanceof LightCar) {
            return CarType.LIGHT_CAR;
        } else if (
                car instanceof Truck) {
            return CarType.TRUCK;
        }
        return null;
    }
}
