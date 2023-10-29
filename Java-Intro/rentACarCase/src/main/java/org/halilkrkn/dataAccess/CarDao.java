package org.halilkrkn.dataAccess;

import org.halilkrkn.entities.Car;

import java.util.List;

public interface CarDao {
    List<Car> getAllCars();
    Car getCarById(int id);
    void addCar(Car car);
    void updateCar(Car car);
    void deleteCar(int id);
}
