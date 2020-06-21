import java.util.*;

public class TaxiStationMain {
    public static void main(String[] args) throws java.io.IOException {

        char choice;

        ArrayList<Car> carList = initializeData();
        Menu menu = new Menu();

        for (; ; ) {
            menu.showMenu();
            do {
                choice = (char) System.in.read();
            } while (choice == '\n');
            if (choice == 'q') break;

            switch (choice) {
                case '1':
                    printCarTypes();
                    break;
                case '2':
                    System.out.println("The cars that are present in taxi station:\n");
                    printCarList(carList);
                    break;
                case '3':
                    System.out.println("Total cost of all cars:\n");
                    sumPriceOfCars(carList);
                    break;
                case '4':
                    System.out.println("Cars are sorted by fuel consumption:\n");
                    carList.sort((o1, o2) -> o1.getFuelConsumption() - o2.getFuelConsumption());
                    printCarList(carList);
                    break;
                case '5':
                    System.out.println("Cars with 110-130 range speed:\n");
                    int maxSpeed = 130;
                    int minSpeed = 110;
                    SearchAction searchAction = new SearchAction();
                    ArrayList<Car> filteredCars = searchAction.filterCarBySpeed(minSpeed, maxSpeed, carList);
                    printCarList(filteredCars);
                    break;
                default:
                    System.out.println("Input parameter is incorrect, please provide correct choice.");
            }
            System.out.println();
        }
    }

    private static void printCarList(ArrayList<Car> carList) {
        for (Car car: carList) {
            System.out.println(car.toString());
        }
    }

    private static void sumPriceOfCars(ArrayList<Car> carList) {
        int sum = 0;
        for (Car cars: carList) {
            sum += cars.getPrice();
        }
        System.out.println(sum);
    }
    private static ArrayList<Car> initializeData() {
        ArrayList<Car> carList = new ArrayList<Car>();

        carList.add(new Car("Reno", 2019, 10, 30000, 110, "Eco", CarType.BUSINESS));
        carList.add(new Car("Lexus", 2016, 12, 50000, 150, "Leather", CarType.ECONOMY));
        carList.add(new Car("Audi", 2020, 11, 40000, 130, "Leather", CarType.VIP));
        carList.add(new Car("Nissan", 2018, 9, 35000, 115, "Eco", CarType.BUSINESS));
        carList.add(new Car("Volkswagen", 2015, 13, 25000, 100, "Textile", CarType.ECONOMY));
        carList.add(new Car("Ford Mustang", 1978, 18, 150000, 125, "Eco", CarType.VIP));
        carList.add(new Car("Porsche", 2019, 15, 180000, 180, "Leather", CarType.BUSINESS));
        return carList;
    }

    private static void printCarTypes() {
        System.out.println("Car types:");
        System.out.println(CarType.VIP.toString());
        System.out.println(CarType.BUSINESS.toString());
        System.out.println(CarType.ECONOMY.toString());
    }
}
