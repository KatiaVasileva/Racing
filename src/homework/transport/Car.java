package homework.transport;

import homework.driver.DriverCategoryB;

public class Car extends Transport<DriverCategoryB>{

    public Car(String brand,
               String model,
               double engineVolume,
               DriverCategoryB driver) {
        super(brand, model, engineVolume, driver);
    }

    @Override
    public void start() {
        System.out.println("Легковой автомобиль " + getBrand() + " " + getModel() + " начинает движение.");
    }

    @Override
    public void stop() {
        System.out.println("Легковой автомобиль " + getBrand() + " " + getModel() + " останавливается.");
    }

    @Override
    public void pitStop() {
        System.out.println("Легковой автомобиль " + getBrand() + " " + getModel() + " останавливается на пит-стоп.");
    }

    @Override
    public void bestLapTime() {
        System.out.println("Легковой автомобиль " + getBrand() + " " + getModel() + " показывает лучшее время круга.");
    }

    @Override
    public void maximumSpeed() {
        System.out.println("Максимальная скорость легкового автомобиля " + getBrand() + " " + getModel() +
                " составляет 250 км/ч.");
    }

    // Блок проверки параметров
    @Override
    public double validateEngineVolume(double engineVolume) {
        return engineVolume <= 0 ? 1.5 : engineVolume;
    }
}
