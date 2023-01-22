package homework.transport;

import homework.driver.DriverCategoryD;

public class Bus extends Transport<DriverCategoryD>{

    public Bus(String brand,
               String model,
               double engineVolume,
               DriverCategoryD driver) {
        super(brand, model, engineVolume, driver);
    }

    @Override
    public void start() {
        System.out.println("Автобус " + getBrand() + " " + getModel() + " начинает движение.");
    }

    @Override
    public void stop() {
        System.out.println("Автобус " + getBrand() + " " + getModel() + " останавливается.");
    }

    @Override
    public void pitStop() {
        System.out.println("Автобус " + getBrand() + " " + getModel() + " останавливается на пит-стоп.");
    }

    @Override
    public void bestLapTime() {
        System.out.println("Автобус " + getBrand() + " " + getModel() + " показывает лучшее время круга.");
    }

    @Override
    public void maximumSpeed() {
        System.out.println("Максимальная скорость автобуса " + getBrand() + " " + getModel() +
                " составляет 150 км/ч.");
    }

    // Блок проверки параметров
    @Override
    public double validateEngineVolume(double engineVolume) {
        return engineVolume <= 0 ? 8.0 : engineVolume;
    }
}
