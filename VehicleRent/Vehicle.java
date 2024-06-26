package VehicleRent;

public abstract class Vehicle implements Maintainable {
    String licensePlate;

    public Vehicle(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    abstract double calculateRentalCost(int days);
}

class Car extends Vehicle implements Maintainable {
    double dailyRate;

    public Car(String licensePlate, double dailyRate) {
        super(licensePlate);
        this.dailyRate = dailyRate;
    }

    @Override
    double calculateRentalCost(int days) {
        return dailyRate * days;
    }
    @Override
    public void performMaintenance(){
       System.out.println("Performing maintenance on car");
    }
}

class Truck extends Vehicle implements Maintainable{
    double dailyRate;
    double weight;

    public Truck(String licensePlate, double dailyRate, double weight) {
        super(licensePlate);
        this.dailyRate = dailyRate;
        this.weight = weight;
    }

    @Override
    double calculateRentalCost(int days) {
        return (dailyRate * days) + (weight * 0.1 * days);
    }

    @Override
    public void performMaintenance(){
        System.out.println("Performing maintenance on truck");
    }
}

class Motorcycle extends Vehicle implements Maintainable {
    double dailyRate;

    public Motorcycle(String licensePlate, double dailyRate) {
        super(licensePlate);
        this.dailyRate = dailyRate;
    }

    @Override
    double calculateRentalCost(int days) {
        return dailyRate * days;
    }

    @Override
    public void performMaintenance(){
        System.out.println("Performing maintenance on motorcycle");
    }
}

class VehicleRentalSystem {
    public static void main(String[] args) {

        Vehicle[] vehicles = {
                new Car("ABC123", 50.0),
                new Truck("XYZ789", 80.0, 2000.0),
                new Motorcycle("DEF456", 20.0)
        };

        int rentalDays = 7;
        for (Vehicle vehicle : vehicles) {
            double rentalCost = vehicle.calculateRentalCost(rentalDays);
            String vehicleType = vehicle.getClass().getSimpleName();
            System.out.println("Rental cost for " + vehicleType + " " + vehicle.licensePlate + " for " + rentalDays + " days is: $" + rentalCost);
            vehicle.performMaintenance();
            System.out.println();
        }







    }
}







