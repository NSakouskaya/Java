import models.ClassificationLevel;
import models.ExperimentalTypes;
import models.MilitaryType;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import planes.Plane;
import planes.PlaneExperimental;
import planes.PlaneMilitary;
import planes.PlanePassenger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import static planes.PlaneSorter.sortByMaxLoadCapacity;

public class AirportTest {
    private final List<Plane> planeList = Arrays.asList(
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
            new PlaneMilitary("C-130 Hercules", 650, 5000, 110000, MilitaryType.TRANSPORT),
            new PlaneExperimental("Bell X-14", 277, 482, 500, ExperimentalTypes.HIGH_ALTITUDE, ClassificationLevel.SECRET),
            new PlaneExperimental("Ryan X-13 Vertijet", 560, 307, 500, ExperimentalTypes.VTOL, ClassificationLevel.TOP_SECRET),
            new PlaneExperimental("XXX", 560, 307, 500, ExperimentalTypes.VTOL, ClassificationLevel.UNCLASSIFIED)
    );

    private Airport airport;

    @BeforeTest
    public void init() {
        airport = new Airport(planeList);
    }

    @Test
    public void testGetTransportMilitaryPlanes() {
        List<PlaneMilitary> actual = airport.getTransportMilitaryPlanes();
        List<PlaneMilitary> expected = Collections.singletonList(new PlaneMilitary("C-130 Hercules", 650, 5000, 110000, MilitaryType.TRANSPORT));
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testGetPassengerPlaneWithMaxCapacity() {
        PlanePassenger expectedResult = new PlanePassenger("Boeing-747", 980, 16100, 70500, 242);
        PlanePassenger result = airport.getPassengerPlaneWithMaxCapacity();
        Assert.assertEquals(result, expectedResult);
    }

    @Test
    public void testNextPlaneLoadCapacityIsHigherThanCurrent() {
        List<? extends Plane> planes = sortByMaxLoadCapacity(airport.getAllPlanes());
        Assert.assertTrue(AssertHelper.verifyLoadCapacity(planes));
    }

    @Test
    public void testHasAtLeastOneBomberInMilitaryPlanes() {
        List<PlaneMilitary> actual = airport.getBomberMilitaryPlanes();

        List<Plane> expected = Arrays.asList(
                new PlaneMilitary("B-1B Lancer", 1050, 21000, 80000, MilitaryType.BOMBER),
                new PlaneMilitary("B-2 Spirit", 1030, 22000, 70000, MilitaryType.BOMBER),
                new PlaneMilitary("B-52 Stratofortress", 1000, 20000, 80000, MilitaryType.BOMBER)
        );

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testExperimentalPlanesHasAtLeastOneUnclassifiedPlane() {
        List<PlaneExperimental> experimentalPlanes = airport.getExperimentalPlanes();
        PlaneExperimental expected = new PlaneExperimental("XXX", 560, 307, 500, ExperimentalTypes.VTOL, ClassificationLevel.UNCLASSIFIED);

        Assert.assertTrue(experimentalPlanes.contains(expected));
    }
}
