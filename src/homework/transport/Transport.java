package homework.transport;

import homework.Validation;
import homework.driver.Driver;
import homework.mechanic.Mechanic;

import java.util.List;
import java.util.Objects;

public abstract class Transport<T extends Driver> implements Competing{
    private final String brand;
    private final String model;
    private double engineVolume;
    private T driver;
    private List<Mechanic> mechanics;

    public Transport(String brand,
                     String model,
                     double engineVolume,
                     T driver,
                     List<Mechanic> mechanics) {
        this.brand = validateCarParameter(brand);
        this.model = validateCarParameter(model);
        this.engineVolume = validateEngineVolume(engineVolume);
        this.driver = driver;
        this.mechanics = mechanics;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public double getEngineVolume() {
        return engineVolume;
    }

    public void setEngineVolume(double engineVolume) {
        this.engineVolume = engineVolume;
    }

    public T getDriver() {
        return driver;
    }

    public void setDriver(T driver) {
        this.driver = driver;
    }

    public List<Mechanic> getMechanics() {
        return mechanics;
    }

    public void setMechanics(List<Mechanic> mechanics) {
        this.mechanics = mechanics;
    }

    @Override
    public String toString() {
        return  brand + " " + model + ", объем двигателя - " + engineVolume + " л";
    }

    // Метод "начать движение"
    public abstract void start();

    // Метод "остановиться"
    public abstract void stop();

    // Метод, который выводит информацию о типе транспортного средства
    public abstract void printType();

    // Метод, который выводит информацию о проведении диагностики (автобусы не проходят диагностику)
    public abstract void goThroughDiagnostics() throws TransportTypeException;

    // Метод, который проверяет необходимо ли добавлять в очередь на СТО каждый объект дочернего класса
    // (автобусы не проходят СТО перед заездом)
    public abstract void checkInspection() throws TransportTypeException;

    // Блок проверки параметров
    public String validateCarParameter(String brand) {
        return Validation.validateString(brand, "default");
    }

    public abstract double validateEngineVolume(double engineVolume);

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        Transport<?> transport = (Transport<?>) other;
        return Objects.equals(brand, transport.brand) && Objects.equals(model, transport.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model);
    }
}

