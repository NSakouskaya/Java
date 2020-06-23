import planes.*;
import models.MilitaryType;
import java.util.Arrays;
import java.util.List;
import static planes.PlaneSorter.*;
import static planes.PlanePrinter.*;

public class Runner {
    static List<Plane> planes = Arrays.asList(
            new PlanePassenger("Boeing-737", 900, 12000, 60500, 164),
            new PlanePassenger("Boeing-737-800", 940, 12300, 63870, 192),
            new PlanePassenger("Boeing-747", 980, 16100, 70500, 242),
            new PlanePassenger("Airbus A320", 930, 11800, 65500, 188),
            new PlanePassenger("Airbus A330", 990, 14800, 80500, 222),
            new PlanePassenger("Embraer 190", 870, 8100, 30800, 64),
            new PlanePassenger("Sukhoi Superjet 100", 870, 11500, 50500, 140),
            new PlanePassenger("Bombardier CS300", 920, 11000, 60700, 196),
            new PlaneMilitary("B-1B Lancer", 1050, 21000, 80000, MilitaryType.BOMBER),
            new PlaneMilitary("B-2 Spirit", 1030, 22000, 70000, MilitaryType.BOMBER),
            new PlaneMilitary("B-52 Stratofortress", 1000, 20000, 80000, MilitaryType.BOMBER),
            new PlaneMilitary("F-15", 1500, 12000, 10000, MilitaryType.FIGHTER),
            new PlaneMilitary("F-22", 1550, 13000, 11000, MilitaryType.FIGHTER),
            new PlaneMilitary("C-130 Hercules", 650, 5000, 110000, MilitaryType.TRANSPORT));

    public static void main(String[] args) {
        Airport airport = new Airport(planes);
        System.out.println("Military planes sorted by max distance:");
        printPlaneList(sortByMaxDistance(airport.getMilitaryPlanes()));
        System.out.println("Passenger planes sorted by max speed:");
        printPlaneList(sortByMaxSpeed(airport.getPassengerPlanes()));
        System.out.println("Experimental planes sorted by max load capacity:");
        printPlaneList(sortByMaxLoadCapacity(airport.getExperimentalPlanes()));
        System.out.println("Plane with max passenger capacity: " + airport.getPassengerPlaneWithMaxCapacity());
    }
}
