package homework;

import homework.driver.DriverCategoryB;
import homework.driver.DriverCategoryC;
import homework.driver.DriverCategoryD;
import homework.mechanic.Mechanic;
import homework.mechanic.ServiceStation;
import homework.transport.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        List<Mechanic> mechanics1 = new ArrayList<>();

        mechanics1.add(new Mechanic("Максим", "Михайлов", "Авто-Лидер-Запад"));
        mechanics1.add(new Mechanic("Сергей", "Субботин", "АвтоГермес"));
        List<Mechanic> mechanics2 = new ArrayList<>();
        mechanics2.add(new Mechanic("Евгений", "Водолазкин", "Глобал Авто"));
        mechanics2.add(new Mechanic("Анатолий", "Карпов", "Техцентр Барс"));

        List<Transport<?>> racingCars = new ArrayList<>();

        racingCars.add(new Car("Lada", "Granta", 1.7, null,
                new DriverCategoryB("Сергей", "Сироткин", true, 15),
                mechanics1));
        racingCars.add(new Car("Audi", "A8 50", 3.0, CarBodyType.SEDAN,
                new DriverCategoryB("Виталий", "Петров", true, 9),
                mechanics1));
        racingCars.add(new Car( "BMW", "Z8", 3.0, CarBodyType.COUPE,
                new DriverCategoryB("Никита", "Мазепин", true, 7),
                mechanics2));
        racingCars.add(new Car("Kia", "Sportage", 2.4,CarBodyType.CROSSOVER,
                new DriverCategoryB("Даниил", "Квят", true, 5),
                mechanics1));
        racingCars.add(new Truck( "Scania", "P-series", 12.7, TruckCapacity.N2,
                new DriverCategoryC("Владимир", "Чагин", true, 11),
                mechanics2));
        racingCars.add(new Truck( "Hyundai", "Gold", 11.2, TruckCapacity.N1,
                new DriverCategoryC("Сергей", "Карякин", true, 8),
                mechanics2));
        racingCars.add(new Truck("Shacman", "SX3318", 11.6, null,
                new DriverCategoryC("Владимир", "Васильев", true, 6),
                mechanics1));
        racingCars.add(new Truck("KAMAZ", "65115", 11.8, TruckCapacity.N3,
                new DriverCategoryC("Сергей", "Савенко", true, 13),
                mechanics2));
        racingCars.add(new Bus( "Mercedes-Benz", "Tourismo", 11.9, BusCapacity.VERY_LARGE,
                new DriverCategoryD("Никита", "Михайлов", true, 5),
                mechanics1));
        racingCars.add(new Bus( "Scania", "A80", 9.0, null,
                new DriverCategoryD("Юрий", "Иванов", true, 9),
                mechanics2));
        racingCars.add(new Bus( "Toyota", "Coaster", 4.1, BusCapacity.VERY_SMALL,
                new DriverCategoryD("Максим", "Стрельцов", true, 10),
                mechanics1));
        racingCars.add(new Bus("Yutong", "ZK6122H9", 8.9,  BusCapacity.AVERAGE,
                new DriverCategoryD("Алексей", "Попов", true, 7),
                mechanics2));

        ServiceStation queueForInspection = new ServiceStation(new LinkedList<>());

        Map<Transport<?>, List<Mechanic>> vehicleList = new HashMap<>();

        insertSeparator();
        System.out.println("Перечень участников соревнований");
        insertSeparator();
        printAllRacingCars(racingCars);
        insertSeparator();
        System.out.println("Информация об участниках заезда");
        getInfo(racingCars);


        insertSeparator();
        System.out.println("Заезд легковых автомобилей:");

        racingCars.get(0).start();
        racingCars.get(1).start();
        racingCars.get(2).start();
        racingCars.get(3).start();
        racingCars.get(0).stop();
        racingCars.get(1).pitStop();
        racingCars.get(1).getDriver().fillCar();
        racingCars.get(1).getDriver().start();
        racingCars.get(2).bestLapTime();
        racingCars.get(3).maximumSpeed();
        racingCars.get(2).getDriver().stop();

        insertSeparator();
        System.out.println("Заезд грузовых автомобилей:");

        racingCars.get(4).start();
        racingCars.get(5).start();
        racingCars.get(6).start();
        racingCars.get(7).start();
        racingCars.get(4).stop();
        racingCars.get(4).pitStop();
        racingCars.get(4).getDriver().fillCar();
        racingCars.get(6).bestLapTime();
        racingCars.get(5).maximumSpeed();
        racingCars.get(7).getDriver().stop();

        insertSeparator();
        System.out.println("Заезд автобусов:");

        racingCars.get(8).start();
        racingCars.get(9).start();
        racingCars.get(10).start();
        racingCars.get(11).start();
        racingCars.get(10).pitStop();
        racingCars.get(10).getDriver().fillCar();
        racingCars.get(11).bestLapTime();
        racingCars.get(9).maximumSpeed();

        insertSeparator();
        System.out.println("Информация о типе транспортного средства");
        racingCars.get(0).printType();
        racingCars.get(5).printType();
        racingCars.get(11).printType();

        insertSeparator();
        System.out.println("Информация о диагностике");
        printInfoAboutDiagnostics(racingCars.get(0));
        printInfoAboutDiagnostics(racingCars.get(4));
        printInfoAboutDiagnostics(racingCars.get(10));

        insertSeparator();
        System.out.println("Информация о техническом обслуживании и ремонте");
        mechanics1.get(0).performService(racingCars.get(0));
        mechanics2.get(1).repairCar(racingCars.get(5));
        mechanics1.get(1).performService(racingCars.get(10));

        insertSeparator();
        System.out.println("Информация о водителе и механиках");
        getInfoAboutDriverAndMechanics(racingCars.get(0));
        getInfoAboutDriverAndMechanics(racingCars.get(9));

        insertSeparator();
        System.out.println("Очередь на техосмотр");
        queueForInspection.addInQueue(racingCars.get(1));
        queueForInspection.addInQueue(racingCars.get(4));
        queueForInspection.addInQueue(racingCars.get(7));
        queueForInspection.addInQueue(racingCars.get(10));
        getInfoAboutInspection(queueForInspection);
        queueForInspection.addInQueue(racingCars.get(3));
        getInfoAboutInspection(queueForInspection);

        insertSeparator();
        System.out.println("Список \"автомобиль-механики\"");
        vehicleList.put(racingCars.get(0), mechanics1);
        vehicleList.put(racingCars.get(1), mechanics1);
        vehicleList.put(racingCars.get(2), mechanics2);
        vehicleList.put(racingCars.get(3), mechanics1);
        vehicleList.put(racingCars.get(4), mechanics2);
        vehicleList.put(racingCars.get(5), mechanics2);
        vehicleList.put(racingCars.get(6), mechanics1);
        vehicleList.put(racingCars.get(7), mechanics2);
        vehicleList.put(racingCars.get(8), mechanics1);
        vehicleList.put(racingCars.get(9), mechanics2);
        vehicleList.put(racingCars.get(10), mechanics1);
        vehicleList.put(racingCars.get(11), mechanics2);
        printVehicleAndMechanics(vehicleList);
        insertSeparator();

    }

    // Метод, который выводит информацию обо всех автомобилях и водителях
    public static void printAllRacingCars(List<Transport<?>> racingCars) {
        for (Transport<?> racingCar : racingCars) {
            System.out.println(racingCar);
        }
    }

    // Метод, который выводит информацию об участниках заезда
    public static void getInfo(List<Transport<?>> racingCars) {
        for (Transport<?> racingCar : racingCars) {
            System.out.println("Водитель " + racingCar.getDriver().getDriverName() + " " + racingCar.getDriver().getDriverSurname() +
                    " управляет автомобилем " + racingCar.getBrand() + " " + racingCar.getModel() +
                    " и будет участвовать в заезде.");
        }
    }
    // Метод, который выводит информацию о проведении диагностики автомобиля (автобусы не проходят диагностику)
    public static void printInfoAboutDiagnostics(Transport<?> racingCar) {
        try {
            racingCar.goThroughDiagnostics();
        } catch (TransportTypeException e) {
            System.out.println(e.getMessage());
            //e.printStackTrace(); // для вывода сообщения StackTrace
        }
    }

    // Метод, который выводит информацию о том, как зовут водителя автомобиля и какие механики его обслуживают
    public static void getInfoAboutDriverAndMechanics(Transport<?> transport) {
        System.out.println("Водителя автомобиля " + transport.getBrand() + " " + transport.getModel() + " зовут " +
                transport.getDriver().getDriverName() + " " + transport.getDriver().getDriverSurname() +
                ". Автомобиль обслуживают механики:\n    " +
                transport.getMechanics().toString().replace("[", "").replace("]", ""));
    }

    // Метод, который выводит информацию о прохождении техосмотра перед заездом всех автомобилей, стоящих в очереди
    // (автобусы не проходят техосмотр перед заездом)
    public static void getInfoAboutInspection(ServiceStation queueForInspection) {
        try {
            queueForInspection.performInspection();
        } catch (TransportTypeException e) {
            System.out.println(e.getMessage());
        }
    }

    // Метод, который выводит пары ключ-значение (автомобиль-механики) через цикл for
    public static void printVehicleAndMechanics(Map<Transport<?>, List<Mechanic>> vehicleList) {
        for (Map.Entry<Transport<?>, List<Mechanic>> vehicle : vehicleList.entrySet()) {
            System.out.println("Автомобиль: " + vehicle.getKey().getBrand() + " " + vehicle.getKey().getModel() +
                    ", механики: " + vehicle.getValue().toString().replace("[", "").replace("]", ""));
        }
    }
    public static void insertSeparator() {
        System.out.println("=========================================================================" +
                "============================================================");
    }
}