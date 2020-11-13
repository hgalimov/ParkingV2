package ru.uennar.esh.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.uennar.esh.model.Car;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        inputData();
        ApplicationContext context =
                new ClassPathXmlApplicationContext(new String[]{"spring.xml"});
        Car lightCar = context.getBean("lightCar", Car.class);
        Car truck = context.getBean("truck", Car.class);
        System.out.println(lightCar.getId() + " " + lightCar.getType().toString() + " " + "\n"
                + truck.getId() + " " + truck.getType().toString());
        lightCar = context.getBean("lightCar", Car.class);
        truck = context.getBean("truck", Car.class);
        System.out.println(lightCar.getId() + " " + lightCar.getType().toString() + " " + "\n"
                + truck.getId() + " " + truck.getType().toString());

    }

    private static void inputData() {
        Scanner scan = new Scanner(System.in);
        try {
            System.out.println("Размер парка");
            int parkingSize = scan.nextInt();
            System.out.println("Максимальная длина очереди");
            int maxSizeGen = scan.nextInt();
            System.out.println("Интервал генерации для вход");
            long genInterval = scan.nextLong() * 1_000_000_000;
            System.out.println("Интервал для выхода");
            long dltInterval = scan.nextLong() * 1_000_000_000;
        } catch (Exception e) {
            System.out.println("Ошибка ввода");
            System.exit(0);
        } finally {
            scan.close();
        }
    }
}
