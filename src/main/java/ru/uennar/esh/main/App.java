package ru.uennar.esh.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.uennar.esh.beans.Parking;
import ru.uennar.esh.model.Car;
import ru.uennar.esh.thread.CarDeletingThread;
import ru.uennar.esh.thread.CarGeneratorThread;
import ru.uennar.esh.thread.CarMovingToParkThread;
import ru.uennar.esh.thread.ParkingInfoThread;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {
    private static int parkingSize;
    private static int maxSizeGen;
    private static long genInterval;
    private static long dltInterval;
    public static ApplicationContext context;

    public static void main(String[] args) {
        inputData();
        context =
                new ClassPathXmlApplicationContext(new String[]{"spring.xml"});
        Parking parking = context.getBean("parking", Parking.class);
        parking.setSize(parkingSize);
        ExecutorService service = Executors.newFixedThreadPool(4);
        service.submit(new CarGeneratorThread(System.nanoTime(), genInterval, maxSizeGen, parking));
        service.submit(new CarMovingToParkThread(parking));
        service.submit(new CarDeletingThread(System.nanoTime(), dltInterval, parking));
        service.submit(new ParkingInfoThread(parking));
        service.shutdown();
    }

    private static void inputData() {
        Scanner scan = new Scanner(System.in);
        try {
            System.out.println("Размер парка");
            parkingSize = scan.nextInt();
            System.out.println("Максимальная длина очереди");
            maxSizeGen = scan.nextInt();
            System.out.println("Интервал генерации для входа");
            genInterval = scan.nextLong() * 1_000_000_000;
            System.out.println("Интервал для выхода");
            dltInterval = scan.nextLong() * 1_000_000_000;
        } catch (Exception e) {
            System.out.println("Ошибка ввода");
            System.exit(0);
        } finally {
            scan.close();
        }
    }
}
