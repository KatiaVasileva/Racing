package homework.driver;

import homework.Validation;

import java.util.Objects;
import java.util.regex.Pattern;

public class Driver {
    private final String driverName;
    private final String driverSurname;
    private boolean driversLicence;
    private int drivingExperience;

    public Driver(String driverName,
                  String driverSurname,
                  boolean driversLicence,
                  int drivingExperience) {
        this.driverName = validateName(driverName);
        this.driverSurname = validateName(driverSurname);
        this.driversLicence = Validation.validateBoolean(driversLicence);
        this.drivingExperience = validateDrivingExperience(drivingExperience);
    }

    public String getDriverName() {
        return driverName;
    }

    public String getDriverSurname() {
        return driverSurname;
    }

    public boolean isDriversLicence() {
        return driversLicence;
    }

    public void setDriversLicence(boolean driversLicence) {
        this.driversLicence = driversLicence;
    }

    public int getDrivingExperience() {
        return drivingExperience;
    }

    public void setDrivingExperience(int drivingExperience) {
        this.drivingExperience = drivingExperience;
    }

    // // Метод, который выводит информацию о том, что водитель начал движение
    public void start() {
        System.out.println("Водитель " + getDriverName() + " " + getDriverSurname() + " начинает движение.");
    }

    // Метод, который выводит информацию о том, что водитель остановился
    public void stop() {
        System.out.println("Водитель " + getDriverName() + " " + getDriverSurname() + " останавливается.");
    }

    // Метод, который выводит информацию о том, что водитель заправляет автомобиль
    public void fillCar() {
        System.out.println("Водитель " + getDriverName() + " " + getDriverSurname() + " заправляет автомобиль.");
    }

    @Override
    public String toString() {
        if (driversLicence) {
            return "Водитель: " + driverName + " " + driverSurname + ", водительские права - есть" +
                    ", стаж вождения - " + drivingExperience + " лет";
        } else {
            return "\n    Водитель: " + driverName + " " + driverSurname + ", водительские права - нет. " +
                    "Водитель не допускается до соревнований!";
        }
    }

    // Блок проверки параметров
    public String validateName(String name) {
        if (Pattern.matches("[А-Я][а-я]+", name)) {
            return name;
        } else {
            return "имя или фамилия указаны неправильно!";
        }
    }

    public int validateDrivingExperience(int years) {
        return years <= 0 ? 5 : years;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        Driver driver = (Driver) other;
        return Objects.equals(driverName, driver.driverName) && Objects.equals(driverSurname, driver.driverSurname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(driverName, driverSurname);
    }
}
