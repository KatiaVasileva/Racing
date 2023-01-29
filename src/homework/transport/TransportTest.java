package homework.transport;

import homework.driver.DriverCategoryB;
import homework.driver.DriverCategoryC;
import homework.driver.DriverCategoryD;

public class TransportTest {
    public static void main(String[] args) {
        Transport<DriverCategoryB> testCar = new Car("", " ", 0,
                new DriverCategoryB("", "", true, 0),
                CarBodyType.COUPE);
        Transport<DriverCategoryC> testTruck = new Truck( "", " ", 0,
                new DriverCategoryC("", " ", false, -1),
                TruckCapacity.N1);
        Transport<DriverCategoryD> testBus = new Bus("", " ", 0,
                new DriverCategoryD("Jack", " ", true, 0),
                BusCapacity.SMALL);

        System.out.println(testCar + " " + testCar.getDriver());
        System.out.println(testTruck + " " + testTruck.getDriver());
        System.out.println(testBus + " " + testBus.getDriver());
    }
}
