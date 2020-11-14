package ru.uennar.esh.thread;

import ru.uennar.esh.beans.Parking;

public class CarMovingToParkThread extends Thread {
    private Parking parking;

    public CarMovingToParkThread(Parking parking) {
        this.parking = parking;
    }

    @Override
    public void run() {
        while (true) {
            moveCarToPark();
        }
    }

    private synchronized void moveCarToPark() {
        parking.addCar();
    }
}
