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
        double minValue = 2;
        double maxValue = 4;
        double bestLapTime = minValue + ((maxValue - minValue) * Math.random());
        System.out.printf("Легковой автомобиль %s %s показывает лучшее время круга: %.2f мин.\n", getBrand(), getModel(),
                bestLapTime);
    }

    @Override
    public void maximumSpeed() {
        int minValue = 160;
        int maxValue = 250;
        int maximumSpeed = (int) (minValue + ((maxValue - minValue) * Math.random()));
        System.out.println("Максимальная скорость легкового автомобиля " + getBrand() + " " + getModel() +
                " составляет " + maximumSpeed + " км/ч.");
    }

    // Блок проверки параметров
    @Override
    public double validateEngineVolume(double engineVolume) {
        return engineVolume <= 0 ? 1.5 : engineVolume;
    }
}
