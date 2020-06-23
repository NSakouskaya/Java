package planes;
import java.util.List;

public class PlanePrinter {
    public static void printPlaneList(List<? extends Plane> collection) {
        if (collection == null || collection.size() == 0) {
            System.out.println("No data to display!");
            return;
        }

        for (Plane plane : collection) {
            System.out.println(plane);
        }
    }
}
