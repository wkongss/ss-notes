public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        Vehicle car = new Car("Honda", "Civic");

        System.out.println(String.format("Car has %s wheels!", car.getNumWheels()));
        System.out.println(car.toString());
        
        car.drive();
        car.start();
        car.drive();
        
        Vehicle segway = new Segway(5000);
        
        System.out.println(String.format("Segway has %s wheels!", segway.getNumWheels()));
        System.out.println(segway.toString());

        segway.start();
        segway.drive();
    }
}
