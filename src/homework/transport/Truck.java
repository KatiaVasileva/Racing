package homework.transport;

import homework.driver.DriverCategoryC;

public class Truck extends Transport<DriverCategoryC>{

    TruckCapacity truckCapacity;

    public Truck(String brand,
                 String model,
                 double engineVolume,
                 DriverCategoryC driver,
                 TruckCapacity truckCapacity) {
        super(brand, model, engineVolume, driver);
        this.truckCapacity = truckCapacity;
    }

    @Override
    public String toString() {
        return super.toString() + "\n   " + truckCapacity;
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
        double minValue = 4;
        double maxValue = 7;
        double bestLapTime = minValue + ((maxValue - minValue) * Math.random());
        System.out.printf("Грузовой автомобиль %s %s показывает лучшее время круга: %.2f мин.\n", getBrand(), getModel(),
                bestLapTime);
    }

    @Override
    public void maximumSpeed() {
        int minValue = 100;
        int maxValue = 180;
        int maximumSpeed = (int) (minValue + ((maxValue - minValue) * Math.random()));
        System.out.println("Максимальная скорость грузового автомобиля " + getBrand() + " " + getModel() +
                " составляет " + maximumSpeed + " км/ч.");
    }

    // Блок проверки параметров
    @Override
    public double validateEngineVolume(double engineVolume) {
        return engineVolume <= 0 ? 10.0 : engineVolume;
    }
}
