import java.util.ArrayList;

public class SearchAction {

    private ArrayList<Car> carListFiltered;

    public ArrayList<Car> filterCarBySpeed (int minSpeed, int maxSpeed, ArrayList<Car> carList) {
        carListFiltered = new ArrayList<>();

        for (Car car: carList) {
            if(car.getSpeed() >= minSpeed && car.getSpeed() <= maxSpeed) {
                carListFiltered.add(car);
            }
        }
        return carListFiltered;
    }
}