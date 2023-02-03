package homework.mechanic;

import homework.transport.*;

import java.util.Objects;

public class Mechanic {
    private final String name;
    private final String surname;
    private String company;

    public Mechanic(String name,
                    String surname,
                    String company) {
        this.name = name;
        this.surname = surname;
        this.company = company;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return getName() + " " + getSurname() + " (компания " + getCompany() + ")";
    }

    // Метод, который выводит информацию о проведении механиком техосмотра
    public void performService(Transport<?> transport) {
        System.out.println("Механик " + getName() + " " + getSurname() + " провел техническое обслуживание автомобиля " +
                transport.getBrand() + " " + transport.getModel() + ".");
    }

    // Метод, который выводит информацию о проведении механиком ремонта
    public void repairCar(Transport<?> transport) {
        System.out.println("Механик " + getName() + " " + getSurname() + " отремонтировал автомобиль " +
                transport.getBrand() + " " + transport.getModel() + ".");
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        Mechanic mechanic = (Mechanic) other;
        return Objects.equals(name, mechanic.name) && Objects.equals(surname, mechanic.surname) && Objects.equals(company, mechanic.company);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, company);
    }
}
