package homework.transport;

import homework.driver.DriverCategoryC;
import homework.mechanic.Mechanic;

import java.util.List;
import java.util.Objects;

public class Truck extends Transport<DriverCategoryC>{

    private TruckCapacity truckCapacity;

    public Truck(String brand,
                 String model,
                 double engineVolume,
                 TruckCapacity truckCapacity,
                 DriverCategoryC driver,
                 List<Mechanic> mechanics) {
        super(brand, model, engineVolume, driver, mechanics);
        this.truckCapacity = truckCapacity;
    }

    public TruckCapacity getTruckCapacity() {
        return truckCapacity;
    }

    public void setTruckCapacity(TruckCapacity truckCapacity) {
        this.truckCapacity = truckCapacity;
    }

    @Override
    public String toString() {
        if (truckCapacity == null) {
            return "Грузовой автомобиль " + super.toString() + "\n    Грузоподъемность: не указана\n    " +
                    getDriver();
        } else {
            return "Грузовой автомобиль " + super.toString() + "\n    " + truckCapacity + "\n    " +
                    getDriver();
        }
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

    @Override
    public void printType() {
        if (truckCapacity == null) {
            System.out.println("Данных по транспортному средству " + getBrand() + " " + getModel() + " недостаточно.");
        } else {
            System.out.println("Тип транспортного средства: грузовой автомобиль " + getBrand() + " " + getModel() + ". " + truckCapacity);
        }
    }

    @Override
    public void goThroughDiagnostics() {
        System.out.println("Грузовой автомобиль " + getBrand() + " " + getModel() + " прошел диагностику.");
    }

    @Override
    public void checkInspection() {
        System.out.println("Выполнен техосмотр грузового автомобиля " + getBrand() + " " + getModel() + ".");
    }

    // Блок проверки параметров
    @Override
    public double validateEngineVolume(double engineVolume) {
        return engineVolume <= 0 ? 10.0 : engineVolume;
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
        Truck truck = (Truck) other;
        return truckCapacity == truck.truckCapacity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), truckCapacity);
    }
}
