package org.halilkrkn.business;

import org.halilkrkn.dataAccess.CarDao;
import org.halilkrkn.entities.Car;

import java.util.List;

public class CarManager {
    private final CarDao carDao;

    public CarManager(CarDao carDao) {
        this.carDao = carDao;
    }

    public List<Car> getAllCars() {
        return carDao.getAllCars();
    }

    public Car getCarById(int id) {
        return carDao.getCarById(id);
    }

    public void addCar(Car car) {
        carDao.addCar(car);
    }

    public void updateCar(Car car) {
        carDao.updateCar(car);
    }

    public void deleteCar(int id) {
        carDao.deleteCar(id);
    }
}
