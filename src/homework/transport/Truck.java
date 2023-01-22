package homework.transport;

import homework.driver.DriverCategoryC;

public class Truck extends Transport<DriverCategoryC>{

    public Truck(String brand,
                 String model,
                 double engineVolume,
                 DriverCategoryC driver) {
        super(brand, model, engineVolume, driver);
    }

    @Override
    public void start() {
        System.out.println("Грузовой автомобиль " + getBrand() + " " + getModel() + " начинает движение.");
    }

    @Override
    public void stop() {
        System.out.println("Грузовой автомобиль " + getBrand() + " " + getModel() + " останавливается.");
    }

    @Override
    public void pitStop() {
        System.out.println("Грузовой автомобиль " + getBrand() + " " + getModel() + " останавливается на пит-стоп.");
    }

    @Override
    public void bestLapTime() {
        System.out.println("Грузовой автомобиль " + getBrand() + " " + getModel() + " показывает лучшее время круга.");
    }

    @Override
    public void maximumSpeed() {
        System.out.println("Максимальная скорость грузового автомобиля " + getBrand() + " " + getModel() +
                " составляет 180 км/ч.");
    }

    // Блок проверки параметров
    @Override
    public double validateEngineVolume(double engineVolume) {
        return engineVolume <= 0 ? 10.0 : engineVolume;
    }
}
