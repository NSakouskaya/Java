package planes;
import java.util.Comparator;
import java.util.List;

public class PlaneSorter {

    public static List<? extends Plane> sortByMaxDistance(List<? extends Plane> planes) {
        planes.sort(Comparator.comparingInt(Plane::getMaxFlightDistance));
        return planes;
    }

    public static List<? extends Plane> sortByMaxSpeed(List<? extends Plane> planes) {
        planes.sort(Comparator.comparingInt(Plane::getMaxSpeed));
        return planes;
    }

    public static List<? extends Plane> sortByMaxLoadCapacity(List<? extends Plane> planes) {
        planes.sort(Comparator.comparingInt(Plane::getMaxLoadCapacity));
        return planes;
    }
}
