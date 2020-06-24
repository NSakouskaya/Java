import org.testng.Assert;
import planes.Plane;
import java.util.List;

public class AssertHelper extends Assert {
    public static boolean verifyLoadCapacity(List<? extends Plane> planes) {
        boolean flag = true;
        for (int i = 0; i < planes.size() - 1; i++) {
            Plane currentPlane = planes.get(i);
            Plane nextPlane = planes.get(i + 1);
            if (currentPlane.getMaxLoadCapacity() > nextPlane.getMaxLoadCapacity()) {
                flag = false;
                break;
            }
        }
        return flag;
    }
}
