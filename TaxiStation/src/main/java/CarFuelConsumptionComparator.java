import java.util.Comparator;

public class CarFuelConsumptionComparator implements Comparator<Car> {

    @Override
    public int compare(Car o1, Car o2) {
        if (o1.getFuelConsumption() == o2.getFuelConsumption()) {
            return 0;
        }
        if (o1.getFuelConsumption() > o2.getFuelConsumption()) {
            return 1;
        } else {
            return -1;
        }
    }
}