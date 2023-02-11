package homework.transport;

import homework.driver.DriverCategoryD;
import homework.mechanic.Mechanic;

import java.util.List;
import java.util.Objects;

public class Bus extends Transport<DriverCategoryD>{

    private BusCapacity busCapacity;

    public Bus(String brand,
               String model,
               double engineVolume,
               BusCapacity busCapacity,
               DriverCategoryD driver,
               List<Mechanic> mechanics) {
        super(brand, model, engineVolume, driver, mechanics);
        this.busCapacity = busCapacity;
    }

    public BusCapacity getBusCapacity() {
        return busCapacity;
    }

    public void setBusCapacity(BusCapacity busCapacity) {
        this.busCapacity = busCapacity;
    }

    @Override
    public String toString() {
        if (busCapacity == null) {
            return "Автобус " + super.toString() + "\n    Вместимость: не указана\n    " +
                    getDriver();
        } else {
            return "Автобус " + super.toString() + "\n    " + busCapacity + "\n    " +
                    getDriver();
        }
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
        double minValue = 5;
        double maxValue = 8;
        double bestLapTime = minValue + ((maxValue - minValue) * Math.random());
        System.out.printf("Автобус %s %s показывает лучшее время круга: %.2f мин.\n", getBrand(), getModel(),
                bestLapTime);
    }

    @Override
    public void maximumSpeed() {
        int minValue = 90;
        int maxValue = 140;
        int maximumSpeed = (int) (minValue + ((maxValue - minValue) * Math.random()));
        System.out.println("Максимальная скорость автобуса " + getBrand() + " " + getModel() +
                " составляет " + maximumSpeed + " км/ч.");
    }

    @Override
    public void printType() {
        if (busCapacity == null) {
            System.out.println("Данных по транспортному средству " + getBrand() + " " + getModel() + " недостаточно.");
        } else {
            System.out.println("Тип транспортного средства: автобус " + getBrand() + " " + getModel() + ". " + busCapacity);
        }
    }

    @Override
    public void goThroughDiagnostics() throws TransportTypeException {
        throw new TransportTypeException("Автобусы не проходят диагностику.");
    }

    @Override
    public void checkInspection() throws TransportTypeException{
        throw new TransportTypeException("Автобусы не проходят техосмотр.");
    }

    // Блок проверки параметров
    @Override
    public double validateEngineVolume(double engineVolume) {
        return engineVolume <= 0 ? 8.0 : engineVolume;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        if (!super.equals(other)) {
            return false;
        }
        Bus bus = (Bus) other;
        return busCapacity == bus.busCapacity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), busCapacity);
    }
}
