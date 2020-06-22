package planes;
import java.util.Objects;

public class PlanePassenger extends Plane {

    private final int passengersCapacity;

    public PlanePassenger(String model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity, int passengersCapacity) {
        super(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
        this.passengersCapacity = passengersCapacity;
    }

    public int getPassengersCapacity() {
        return this.passengersCapacity;
    }

    @Override
    public String toString() {
        return super.toString().replace("}",
                ", passengersCapacity=" + getPassengersCapacity() +
                        '}');
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PlanePassenger)) return false;
        if (!super.equals(o)) return false;
        PlanePassenger plane = (PlanePassenger) o;
        return this.passengersCapacity == plane.passengersCapacity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), this.passengersCapacity);
    }
}
