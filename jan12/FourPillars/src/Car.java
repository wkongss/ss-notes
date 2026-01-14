public class Car extends Vehicle {
    private boolean engineOn = false;
    private String make;
    private String model;

    public Car() {
        super();
    }
    
    public Car(String make, String model) {
        super(4, "land");
        this.make = make;
        this.model = model;
    }

    public boolean isEngineOn() {
        return engineOn;
    }

    public void toggleEngine() {
        this.engineOn = !this.engineOn;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
    
    @Override
    public String toString() {
        return String.format("Make: %s, Model, %s, Engine status: %s",
            this.make,
            this.model,
            this.engineOn ? "On" : "Off"
        );
    }

    @Override
    public void start() {
        if (!this.engineOn) {
            this.toggleEngine();
        }
        System.out.println("The car key has turned!");
    }

    @Override
    public void drive() {
        if (this.engineOn) {
            System.out.println("The car has started driving!");
        } else {
            System.out.println("The car must be on to start driving!");
        }
    }
}
