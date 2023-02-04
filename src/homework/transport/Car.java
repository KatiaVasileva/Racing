package homework.transport;

import homework.driver.DriverCategoryB;
import homework.mechanic.Mechanic;

import java.util.List;

public class Car extends Transport<DriverCategoryB>{

    private CarBodyType bodyType;


    public Car(String brand,
               String model,
               double engineVolume,
               CarBodyType bodyType,
               DriverCategoryB driver,
               List<Mechanic> mechanics) {
        super(brand, model, engineVolume, driver, mechanics);
        this.bodyType = bodyType;
    }

    public CarBodyType getBodyType() {
        return bodyType;
    }

    public void setBodyType(CarBodyType bodyType) {
        this.bodyType = bodyType;
    }

    @Override
    public String toString() {
        if (bodyType == null) {
            return "Легковой автомобиль " + super.toString() + "\n    Тип кузова: не указан" +
                    getDriver();
        } else {
            return " Легковой автомобиль " + super.toString() + "\n    " + bodyType +
                    getDriver();
        }
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

    @Override
    public void printType() {
        if (bodyType == null) {
            System.out.println("Данных по транспортному средству " + getBrand() + " " + getModel() + " недостаточно.");
        } else {
            System.out.println("Тип транспортного средства: легковой автомобиль " + getBrand() +
                    " " + getModel() + ". " + bodyType);
        }
    }

    @Override
    public void goThroughDiagnostics() {
        System.out.println("Легковой автомобиль " + getBrand() + " " + getModel() + " прошел диагностику.");
    }

    @Override
    public void checkInspection() {
        System.out.println("Выполнен техосмотр легкового автомобиля " + getBrand() + " " + getModel() + ".");
    }

    // Блок проверки параметров
    @Override
    public double validateEngineVolume(double engineVolume) {
        return engineVolume <= 0 ? 1.5 : engineVolume;
    }
}
