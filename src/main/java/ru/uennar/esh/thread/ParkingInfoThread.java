package ru.uennar.esh.thread;

import org.springframework.beans.factory.annotation.Autowired;
import ru.uennar.esh.beans.Parking;

public class ParkingInfoThread extends Thread {

    private Parking parking;

    public ParkingInfoThread(Parking parking) {
        this.parking = parking;
    }

    @Override
    public void run() {
        printInfo();
    }

    private synchronized void printInfo() {
        while (true) {
            System.out.println("Свободных мест: " + parking.getFreePlace());
            System.out.println("Занято мест: " + parking.getCurLoad() + " (" +
                    parking.getLightCarCount() + " легков.авто и " + parking.getTruckCount() + " груз.авто" + ")");
            System.out.println("Количество автомобилей, ожидающих в очереди: " + parking.generatedListSize());
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
