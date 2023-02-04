package homework.transport;

import homework.driver.DriverCategoryB;
import homework.driver.DriverCategoryC;
import homework.driver.DriverCategoryD;
import homework.mechanic.Mechanic;

import java.util.ArrayList;
import java.util.List;

public class TransportTest {
    public static void main(String[] args) {
        List<Mechanic> testMechanics = new ArrayList<>();
        testMechanics.add(new Mechanic("", "", ""));
        Transport<DriverCategoryB> testCar = new Car("", " ", 0, CarBodyType.COUPE,
                new DriverCategoryB("", "", true, 0),
                testMechanics);
        Transport<DriverCategoryC> testTruck = new Truck( "", " ", 0, TruckCapacity.N1,
                new DriverCategoryC("", " ", false, -1),
                testMechanics);
        Transport<DriverCategoryD> testBus = new Bus("", " ", 0, BusCapacity.SMALL,
                new DriverCategoryD("Jack", " ", true, 0),
                testMechanics);

        System.out.println(testCar + " " + testCar.getDriver());
        System.out.println(testTruck + " " + testTruck.getDriver());
        System.out.println(testBus + " " + testBus.getDriver());
    }
}
