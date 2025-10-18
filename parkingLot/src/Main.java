import Vehicle.Car;
import Vehicle.Truck;
import Vehicle.Vehicle;

public class Main {
    public static void main(String[] args) {
        ParkingLot parkingLot = ParkingLot.getInstance();
        parkingLot.addLevel(1,100);

        Vehicle car= new Car("ABC","CAR");
        parkingLot.parkVehicle(car);

        Vehicle truck = new Truck("XYZ","TRUCK");
        parkingLot.parkVehicle(truck);

        parkingLot.unparkVehicle(truck);
    }
}