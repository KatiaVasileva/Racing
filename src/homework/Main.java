package homework;

import homework.driver.DriverCategoryB;
import homework.driver.DriverCategoryC;
import homework.driver.DriverCategoryD;
import homework.transport.Bus;
import homework.transport.Car;
import homework.transport.Transport;
import homework.transport.Truck;

public class Main {
    public static void main(String[] args) {

        Car car1 = new Car("Lada", "Granta", 1.7,
                new DriverCategoryB("Сергей", "Сироткин", true, 15));
        Car car2 = new Car("Audi", "A8 50", 3.0,
                new DriverCategoryB("Виталий", "Петров", true, 9));
        Car car3 = new Car("BMW", "Z8", 3.0,
                new DriverCategoryB("Никита", "Мазепин", true, 7));
        Car car4 = new Car("Kia", "Sportage", 2.4,
                new DriverCategoryB("Даниил", "Квят", true, 5));

        Truck truck1 = new Truck("Scania", "P-series", 12.7,
                new DriverCategoryC("Владимир", "Чагин", true, 11));
        Truck truck2 = new Truck("Hyundai", "Gold", 11.2,
                new DriverCategoryC("Сергей", "Карякин", true, 8));
        Truck truck3 = new Truck("Shacman", "SX3318", 11.6,
                new DriverCategoryC("Владимир", "Васильев", true, 6));
        Truck truck4 = new Truck("KAMAZ", "65115", 11.8,
                new DriverCategoryC("Сергей", "Савенко", true, 13));

        Bus bus1 = new Bus("Mercedes-Benz", "Tourismo", 11.9,
                new DriverCategoryD("Никита", "Михайлов", true, 5));
        Bus bus2 = new Bus("Scania", "A80", 9.0,
                new DriverCategoryD("Юрий", "Иванов", true, 9));
        Bus bus3 = new Bus("Toyota", "Coaster", 4.1,
                new DriverCategoryD("Максим", "Стрельцов", true, 10));
        Bus bus4 = new Bus("Yutong", "ZK6122H9", 8.9,
                new DriverCategoryD("Алексей", "Попов", true, 7));

        insertSeparator();
        System.out.println("Перечень участников соревнований (легковые автомобили)");
        insertSeparator();

        System.out.println(car1 + " " + car1.getDriver());
        System.out.println(car2 + " " + car2.getDriver());
        System.out.println(car3 + " " + car3.getDriver());
        System.out.println(car4 + " " + car4.getDriver());

        insertSeparator();
        System.out.println("Перечень участников соревнований (грузовые автомобили)");
        insertSeparator();

        System.out.println(truck1 + " " + truck1.getDriver());
        System.out.println(truck2 + " " + truck2.getDriver());
        System.out.println(truck3 + " " + truck3.getDriver());
        System.out.println(truck4 + " " + truck4.getDriver());

        insertSeparator();
        System.out.println("Перечень участников соревнований (автобусы)");
        insertSeparator();

        System.out.println(bus1 + " " + bus1.getDriver());
        System.out.println(bus2 + " " + bus2.getDriver());
        System.out.println(bus3 + " " + bus3.getDriver());
        System.out.println(bus4 + " " + bus4.getDriver());

        insertSeparator();

        System.out.println("Информация");
        getInfo(car1);
        getInfo(truck2);
        getInfo(bus3);

        insertSeparator();
        System.out.println("Заезд легковых автомобилей:");

        car1.start();
        car2.start();
        car3.start();
        car4.start();
        car1.stop();
        car2.pitStop();
        car2.getDriver().fillCar();
        car2.getDriver().start();
        car3.bestLapTime();
        car4.maximumSpeed();
        car3.getDriver().stop();

        insertSeparator();
        System.out.println("Заезд грузовых автомобилей:");

        truck1.start();
        truck2.start();
        truck3.start();
        truck4.start();
        truck1.stop();
        truck1.pitStop();
        truck1.getDriver().fillCar();
        truck3.bestLapTime();
        truck2.maximumSpeed();
        truck4.getDriver().stop();

        insertSeparator();
        System.out.println("Заезд автобусов:");

        bus1.start();
        bus2.start();
        bus3.start();
        bus4.start();
        bus3.pitStop();
        bus3.getDriver().fillCar();
        bus4.bestLapTime();
        bus2.maximumSpeed();

        insertSeparator();
    }

    public static void getInfo(Transport<?> transport) {
            System.out.println("Водитель " + transport.getDriver().getDriverName() + " " + transport.getDriver().getDriverSurname() +
                    " управляет автомобилем " + transport.getModel() + " " + transport.getBrand() +
                    " и будет участвовать в заезде.");
    }

    public static void insertSeparator() {
        System.out.println("=========================================================================" +
                "================================================================");
    }
}