public class Car {
    private String brand;
    private int year;
    private int fuelConsumption;
    private int price;
    private int speed;
    private String interior;
    private CarType type;

    public Car(String brand, int year, int fuelConsumption, int price, int speed, String interior, CarType type) {
        this.brand = brand;
        this.year = year;
        this.fuelConsumption = fuelConsumption;
        this.price = price;
        this.speed = speed;
        this.interior = interior;
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) { this.brand = brand; }

    public int getYear() { return year; }

    public void setYear(int year) { this.year = year; }

    public int getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(int fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String getInterior() { return interior; }

    public void setInterior(String interior) { this.interior = interior; }

    public CarType getType() { return type; }

    public void setTypes(CarType type) { this.type = type; }

    @Override
    public String toString() {
        return "Cars{" +
                "brand='" + this.getBrand() + '\'' +
                ", year=" + this.getYear() +
                ", fuelConsumption=" + this.getFuelConsumption() +
                ", price=" + this.getPrice() +
                ", speed=" + this.getSpeed() +
                ", interior='" + this.getInterior() + '\'' +
                ", types=" + this.getType() +
                '}';
    }
}