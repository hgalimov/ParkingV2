package ru.uennar.esh.beans;

import org.springframework.stereotype.Component;
import ru.uennar.esh.model.Car;
import ru.uennar.esh.model.CarType;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class Parking {
    private int parkingSize;
    private int curLoad;
    private int lightCarCount;
    private int truckCount;
    private int freePlace;
    private List<Car> inParkingList;
    private List<Car> generatedList;

    public Parking() {
        inParkingList = new ArrayList<>();
        generatedList = new ArrayList<>();
    }

    public int getFreePlace() {
        return freePlace;
    }

    public int getSize() {
        return parkingSize;
    }

    public void setSize(int parkingSize) {
        this.parkingSize = parkingSize;
        freePlace = parkingSize;
    }

    public int getCurLoad() {
        return curLoad;
    }

    public void setCurLoad(int curLoad) {
        this.curLoad = curLoad;
    }

    public int getLightCarCount() {
        return lightCarCount;
    }

    public void setLightCarCount(int lightCarCount) {
        this.lightCarCount = lightCarCount;
    }

    public int getTruckCount() {
        return truckCount;
    }

    public void setTruckCount(int truckCount) {
        this.truckCount = truckCount;
    }

    public void dltCar() {
        int size = inParkingList.size();
        if (size > 0) {
            Car car = inParkingList.remove(new Random().nextInt(size));
            curLoad -= car.getSize();
            freePlace += car.getSize();
            CarType carType = car.getType();
            if (carType.equals(CarType.LIGHT_CAR)) {
                lightCarCount--;
            } else if (
                    carType.equals(CarType.TRUCK)) {
                truckCount--;
            }
            System.out.println(car.getType().toString() + " c id = " +
                    car.getId() + " покинул парковку.");
        }

    }

    public boolean addCar() {
        if (generatedList == null || generatedList.isEmpty()) {
            return false;
        }
        Car car = generatedList.get(0);
        if (car != null) {
            int carSize = car.getSize();
            if (carSize + curLoad <= parkingSize) {
                if (inParkingList.add(car)) {
                    CarType carType = car.getType();
                    if (carType.equals(CarType.LIGHT_CAR)) {
                        lightCarCount++;
                    } else if (
                            carType.equals(CarType.TRUCK)) {
                        truckCount++;
                    }
                    curLoad += carSize;
                    freePlace -= carSize;
                    System.out.println(carType.toString() + " c id = " +
                            car.getId() + " припарковался.");
                    generatedListRemove(car);
                    return true;
                }
            }
        }
        return false;
    }

    public void generatedListAdd(Car car) {
        generatedList.add(car);
    }

    public int generatedListSize() {
        if (generatedList == null) {
            return 0;
        }
        return generatedList.size();
    }

    public void generatedListRemove(Car car) {
        generatedList.remove(car);
    }
}
