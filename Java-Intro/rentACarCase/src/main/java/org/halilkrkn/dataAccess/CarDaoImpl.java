package org.halilkrkn.dataAccess;

import org.halilkrkn.entities.Car;

import java.util.ArrayList;
import java.util.List;

public class CarDaoImpl implements CarDao {

    private final List<Car> cars = new ArrayList<>();

    @Override
    public List<Car> getAllCars() {
        return cars;
    }

    @Override
    public Car getCarById(int id) {
        for (Car car : cars) {
            if (car.getId() == id) {
                return car;
            }
        }
        return null;
    }

    @Override
    public void addCar(Car car) {
        cars.add(car);
    }

    @Override
    public void updateCar(Car car) {
        for (int i = 0; i < cars.size(); i++) {
            if (cars.get(i).getId() == car.getId()) {
                cars.set(i, car);
                return;
            }
        }
    }

    @Override
    public void deleteCar(int id) {
        cars.removeIf(car -> car.getId() == id);
    }
}
