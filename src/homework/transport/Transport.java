package homework.transport;

import homework.Validation;
import homework.driver.Driver;

import java.util.Objects;

public abstract class Transport<T extends Driver> implements Competing{
    private final String brand;
    private final String model;
    private double engineVolume;
    private T driver;

    public Transport(String brand,
                     String model,
                     double engineVolume,
                     T driver) {
        this.brand = validateCarParameter(brand);
        this.model = validateCarParameter(model);
        this.engineVolume = validateEngineVolume(engineVolume);
        this.driver = driver;
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

    @Override
    public String toString() {
        return  brand + " " + model + ", объем двигателя - " + engineVolume + " л";
    }

    public abstract void start();

    public abstract void stop();

    public abstract void printType();

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

interface Competing{
    void pitStop();

    void bestLapTime();

    void maximumSpeed();
}
