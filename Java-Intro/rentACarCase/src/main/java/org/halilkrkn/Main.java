package org.halilkrkn;

import org.halilkrkn.business.CarManager;
import org.halilkrkn.dataAccess.CarDao;
import org.halilkrkn.dataAccess.CarDaoImpl;
import org.halilkrkn.entities.Car;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // CarDao nesnesini oluştur
        CarDao carDao = new CarDaoImpl();

        // carManager nesnesini oluştur ve CarDao'yu enjekte et
        CarManager carManager = new CarManager(carDao);

        // Yeni bir araba oluştur
        Car car1 = new Car(1, "Toyota", "Camry", 2022);
        Car car2 = new Car(2, "Honda", "Civic", 2021);

        // Arabayı ekleyin
        carManager.addCar(car1);
        carManager.addCar(car2);

        // Tüm arabaları al
        List<Car> cars = carManager.getAllCars();
        System.out.println(" Tüm Arabalar: ");
        for (Car car : cars) {
            System.out.println("ID: " + car.getId() + ", Marka: " + car.getBrand() + ", Model: " + car.getModel() + ", Yıl: " + car.getYear());
        }

        // Araba ID'sine göre bir araba al
        Car carById = carManager.getCarById(1);
        if (carById != null) {
            System.out.println("\n ID'ye Göre Araba Bulundu: ");
            System.out.println("ID: " + carById.getId() + ", Marka: " + carById.getBrand() + ", Model: " + carById.getModel() + ", Yıl: " + carById.getYear());
        } else {
            System.out.println("\n Belirtilen ID ile Araba Bulunamadı.");
        }

        // Arabayı güncelle
        car1.setYear(2023);
        carManager.updateCar(car1);

        // Araba ID'sine göre güncellenmiş arabayı al
        Car updatedCar = carManager.getCarById(1);
        if (updatedCar != null) {
            System.out.println("\n Güncellenmiş Araba Bilgileri: ");
            System.out.println("ID: " + updatedCar.getId() + ", Marka: " + updatedCar.getBrand() + ", Model: " + updatedCar.getModel() + ", Yıl: " + updatedCar.getYear());
        }

        // Arabayı sil
        carManager.deleteCar(1);

        // Silindikten sonra tüm arabaları görüntüle
        cars = carManager.getAllCars();
        System.out.println("\n Tüm Arabalar (Silindikten Sonra): ");
        for (Car car : cars) {
            System.out.println("ID: " + car.getId() + ", Marka: " + car.getBrand() + ", Model: " + car.getModel() + ", Yıl: " + car.getYear());
        }
    }
}