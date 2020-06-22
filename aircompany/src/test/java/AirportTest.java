import planes.*;
import models.ClassificationLevel;
import models.ExperimentalTypes;
import models.MilitaryType;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.Arrays;
import java.util.List;

public class AirportTest {
    private static final List<Plane> PLANE_BASES = Arrays.asList(
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
            new PlaneExperimental("Ryan X-13 Vertijet", 560, 307, 500, ExperimentalTypes.VTOL, ClassificationLevel.TOP_SECRET)
    );
    private static final PlanePassenger planeWithMaxPassengerCapacity = new PlanePassenger("Boeing-747", 980, 16100, 70500, 242);

    private Airport airport;

    @BeforeTest
    public void init() {
        airport = new Airport(PLANE_BASES);
    }

    @Test
    public void testGetTransportMilitaryPlanes() {
        List<PlaneMilitary> transportMilitaryPlanes = airport.getTransportMilitaryPlanes();
        boolean flag = false;
        for (PlaneMilitary militaryPlane : transportMilitaryPlanes) {
            if ((militaryPlane.getType() == MilitaryType.TRANSPORT)) {
                flag = true;
                break;
            }
        }
        Assert.assertTrue(flag);
    }

    @Test
    public void testGetPassengerPlaneWithMaxCapacity() {
        PlanePassenger expectedPlaneWithMaxPassengersCapacity = airport.getPassengerPlaneWithMaxPassengersCapacity();
        Assert.assertEquals(planeWithMaxPassengerCapacity, expectedPlaneWithMaxPassengersCapacity);
    }

    @Test
    public void testNextPlaneMaxLoadCapacityIsHigherThanCurrent() {
        List<? extends Plane> planesSortedByMaxLoadCapacity = PlaneSorter.sortByMaxLoadCapacity(airport.getAllPlanes());

        boolean nextPlaneMaxLoadCapacityIsHigherThanCurrent = true;
        for (int i = 0; i < planesSortedByMaxLoadCapacity.size() - 1; i++) {
            Plane currentPlane = planesSortedByMaxLoadCapacity.get(i);
            Plane nextPlane = planesSortedByMaxLoadCapacity.get(i + 1);
            if (currentPlane.getMinLoadCapacity() > nextPlane.getMinLoadCapacity()) {
                nextPlaneMaxLoadCapacityIsHigherThanCurrent = false;
                break;
            }
        }
        Assert.assertTrue(nextPlaneMaxLoadCapacityIsHigherThanCurrent);
    }

    @Test
    public void testHasAtLeastOneBomberInMilitaryPlanes() {
        List<PlaneMilitary> bomberMilitaryPlanes = airport.getBomberMilitaryPlanes();
        boolean flag = false;
        for (PlaneMilitary militaryPlane : bomberMilitaryPlanes) {
            if ((militaryPlane.getType() == MilitaryType.BOMBER)) {
                flag = true;
                break;
            }
        }
        Assert.assertTrue(flag);
    }

    @Test
    public void testExperimentalPlanesHasClassificationLevelHigherThanUnclassified(){
        List<PlaneExperimental> experimentalPlanes = airport.getExperimentalPlanes();
        boolean hasUnclassifiedPlanes = false;
        for(PlaneExperimental experimentalPlane : experimentalPlanes){
            if(experimentalPlane.getClassificationLevel() == ClassificationLevel.UNCLASSIFIED){
                hasUnclassifiedPlanes = true;
                break;
            }
        }
        Assert.assertFalse(hasUnclassifiedPlanes);
    }
}
