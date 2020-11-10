package ru.uennar.esh;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.uennar.esh.model.Car;

public class App {
    public static void main(String[] args) {
        System.out.println("Crt project ParkingV2 using SpringFramework");
        ApplicationContext context =
                new ClassPathXmlApplicationContext(new String[] {"spring.xml"});
        Car lightCar = context.getBean("lightCar", Car.class);
        Car truck = context.getBean("truck", Car.class);
        lightCar.getId();
        truck.getId();
    }
}
