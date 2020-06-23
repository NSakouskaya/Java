import planes.PlaneExperimental;
import planes.PlaneMilitary;
import planes.PlanePassenger;
import planes.Plane;
import models.MilitaryType;
import java.util.*;

public class Airport {
    private final List<? extends Plane> allPlanes;

    public Airport(List<? extends Plane> planes) {
        this.allPlanes = planes;
    }

    public List<? extends Plane> getAllPlanes() {
        return this.allPlanes;
    }

    public List<PlanePassenger> getPassengerPlanes() {
        List<PlanePassenger> passengerPlane = new ArrayList<>();
        for (Plane plane : this.allPlanes) {
            if (plane instanceof PlanePassenger) {
                passengerPlane.add((PlanePassenger) plane);
            }
        }
        return passengerPlane;
    }

    public List<PlaneMilitary> getMilitaryPlanes() {
        List<PlaneMilitary> militaryPlanes = new ArrayList<>();
        for (Plane plane : this.allPlanes) {
            if (plane instanceof PlaneMilitary) {
                militaryPlanes.add((PlaneMilitary) plane);
            }
        }
        return militaryPlanes;
    }

    public List<PlaneExperimental> getExperimentalPlanes() {
        List<PlaneExperimental> experimentalPlanes = new ArrayList<>();
        for (Plane plane : this.allPlanes) {
            if (plane instanceof PlaneExperimental) {
                experimentalPlanes.add((PlaneExperimental) plane);
            }
        }
        return experimentalPlanes;
    }

    public PlanePassenger getPassengerPlaneWithMaxCapacity() {
        List<PlanePassenger> passengerPlanes = getPassengerPlanes();
        PlanePassenger planeWithMaxCapacity = passengerPlanes.get(0);
        for (PlanePassenger plane: passengerPlanes) {
            if (plane.getPassengersCapacity() > planeWithMaxCapacity.getPassengersCapacity()) {
                planeWithMaxCapacity = plane;
            }
        }
        return planeWithMaxCapacity;
    }

    public List<PlaneMilitary> getTransportMilitaryPlanes() {
        List<PlaneMilitary> transportMilitaryPlanes = new ArrayList<>();
        List<PlaneMilitary> militaryPlanes = getMilitaryPlanes();
        for (PlaneMilitary plane: militaryPlanes) {
            if (plane.getType() == MilitaryType.TRANSPORT) {
                transportMilitaryPlanes.add(plane);
            }
        }
        return transportMilitaryPlanes;
    }

    public List<PlaneMilitary> getBomberMilitaryPlanes() {
        List<PlaneMilitary> bomberMilitaryPlanes = new ArrayList<>();
        List<PlaneMilitary> militaryPlanes = getMilitaryPlanes();
        for (PlaneMilitary plane: militaryPlanes) {
            if (plane.getType() == MilitaryType.BOMBER) {
                bomberMilitaryPlanes.add(plane);
            }
        }
        return bomberMilitaryPlanes;
    }

    @Override
    public String toString() {
        return "Airport{" +
                "Planes=" + allPlanes.toString() +
                '}';
    }
}
