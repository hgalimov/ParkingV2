package ru.uennar.esh.thread;


import ru.uennar.esh.beans.Parking;
import ru.uennar.esh.main.App;
import ru.uennar.esh.model.Car;
import ru.uennar.esh.model.CarType;


import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class CarGeneratorThread extends Thread {

    private long beginTime;
    private long interval;
    private int maxSizeGen;
    private Parking parking;

    public CarGeneratorThread(long beginTime, long interval, int maxSizeGen, Parking parking) {
        this.interval = interval;
        this.beginTime = beginTime;
        this.maxSizeGen = maxSizeGen;
        this.parking = parking;
    }

    @Override
    public void run() {
        while (true) {
            long rndTime = ThreadLocalRandom.current().nextLong(interval);
            while (true) {
                checkGenListSize();
                if (beginTime + rndTime <= System.nanoTime() && System.nanoTime() < beginTime + interval) {
                    beginTime = System.nanoTime();
                    generateCar();
                    break;
                }
            }
        }
    }

    private synchronized void generateCar() {
        CarType carType = generateCarType();
        switch (carType) {
            case LIGHT_CAR:
                Car lightCar = App.context.getBean("lightCar", Car.class);
                System.out.println(lightCar.getType().toString() +
                        " c id = " + lightCar.getId() + " встал в очередь на въезд.");
                parking.generatedListAdd(lightCar);
                break;
            case TRUCK:
                Car truck = App.context.getBean("truck", Car.class);
                System.out.println(truck.getType().toString() + " c id = " +
                        truck.getId() + " встал в очередь на въезд.");
                parking.generatedListAdd(truck);
                break;
        }
    }

    private CarType generateCarType() {
        int random = (int) (Math.random() * 2);
        if (random == 0) {
            return CarType.TRUCK;
        }
        return CarType.LIGHT_CAR;
    }

    private synchronized void checkGenListSize(){
        if (parking.generatedListSize() >= maxSizeGen) {
            System.out.println("CARMAGEDDON!!!");
            System.exit(0);
        }
    }
}
