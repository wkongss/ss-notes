public class Segway extends Vehicle {
    private int batteryCapacity;

    public Segway() {
        super();
    }

    public Segway(int batteryCapacity) {
        super(2, "land");
        this.batteryCapacity = batteryCapacity;
    }

    public int getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(int batteryCapacity) {
        if (batteryCapacity > 0) {
            this.batteryCapacity = batteryCapacity;
        } else {
            throw new IllegalArgumentException("argument batteryCapacity must be positive.");
        }
    }

    @Override
    public void drive() {
        System.out.println("Vroom vroom!");
    }
    
    @Override
    public void start() {
        System.out.println("Segway key has been turned!");
    }

    @Override
    public String toString() {
        return String.format("Battery: %s mWh", this.batteryCapacity);
    }
}