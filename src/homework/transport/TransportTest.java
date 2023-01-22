package homework.transport;

import homework.driver.DriverCategoryB;
import homework.driver.DriverCategoryC;
import homework.driver.DriverCategoryD;

public class TransportTest {
    public static void main(String[] args) {
        Transport<DriverCategoryB> testCar = new Car("", " ", 0,
                new DriverCategoryB("", "", true, 0));
        Transport<DriverCategoryC> testTruck = new Truck("", " ", 0,
                new DriverCategoryC("", " ", false, -1));
        Transport<DriverCategoryD> testBus = new Bus("", " ", 0,
                new DriverCategoryD("Jack", " ", true, 0));

        System.out.println(testCar + "\n  " + testCar.getDriver());
        System.out.println(testTruck + "\n  " + testTruck.getDriver());
        System.out.println(testBus + "\n  " + testBus.getDriver());
    }
}
