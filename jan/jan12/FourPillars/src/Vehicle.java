public abstract class Vehicle implements Driveable {
    private int numWheels;
    private String type;

    public Vehicle() {

    }

    public Vehicle(int numWheels, String type) {
        this.numWheels = numWheels;
        this.type = type;
    }

    public int getNumWheels() {
        return numWheels;
    }

    public void setNumWheels(int numWheels) throws IllegalArgumentException {
        if (numWheels >= 0) {
            this.numWheels = numWheels;
        } else {
            throw new IllegalArgumentException("argument numWheels must be a non-negative integer.");
        }
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public abstract void start();
}
