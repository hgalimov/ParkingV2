package ru.uennar.esh.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.uennar.esh.model.Car;
import ru.uennar.esh.model.CarType;

@Component
@Scope("prototype")
public class Truck extends Car {
    @Autowired
    private CarTypeDeterminator typeDet;;
    @Override
    public String getId() {
        return hashCode() +"";
    }

    @Override
    public int getSize() {
        return 2;
    }

    @Override
    public CarType getType() {
        return typeDet.carTypeDeterminator(this);
    }
}
