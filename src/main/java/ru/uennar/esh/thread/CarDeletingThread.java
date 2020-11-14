package ru.uennar.esh.thread;


import ru.uennar.esh.beans.Parking;

import java.util.concurrent.ThreadLocalRandom;

public class CarDeletingThread extends Thread {
    private long beginTime;
    private long interval;
    private Parking parking;


    public CarDeletingThread(long beginTime, long interval, Parking parking) {
        this.interval = interval;
        this.beginTime = beginTime;
        this.parking = parking;
    }

    @Override
    public void run() {
        while (true) {
            long rndTime = ThreadLocalRandom.current().nextLong(interval);
            while (true) {
                if (beginTime + rndTime <= System.nanoTime() && System.nanoTime() < beginTime + interval) {
                    beginTime = System.nanoTime();
                    deleteCar();
                    break;
                }
            }
        }
    }

    private synchronized void deleteCar() {
        parking.dltCar();
    }
}
