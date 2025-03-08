import Vehicle.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class Level {
    public int levelNumber;
    private List<ParkingSpot> parkingSpots;

    private double carParking = 0.5;
    private double bikeParking = 0.2;
    private double truckParking = 0.3;

    public Level(int lvlNum, int parkingSpots){
        this.levelNumber=lvlNum;
        this.parkingSpots=new ArrayList<>(parkingSpots);
        int cParking= (int) (parkingSpots*carParking);
        int bParking= (int)  (parkingSpots*bikeParking);
        int tParking= (int)  (parkingSpots*truckParking);

        for(int i=1;i<=cParking;i++){
            this.parkingSpots.add(new ParkingSpot(i,"CAR"));
        }
        for(int i=cParking+1;i<=bParking+cParking;i++){
            this.parkingSpots.add(new ParkingSpot(i,"BIKE"));
        }
        for (int i=bParking+cParking+1;i<=parkingSpots;i++){
            this.parkingSpots.add(new ParkingSpot(i,"TRUCK"));
        }
    }

    public boolean parkVehicle(Vehicle vehicle){
        for (ParkingSpot ps: parkingSpots){
            if (ps.parkVehicle(vehicle)){
                System.out.println(vehicle.getVehicleNumber()+" is parked at parking spot with id = "+ ps.id);
                return  true;
            }
        }
        return false;
    }

    public boolean unparkVehicle(Vehicle vehicle){
        for (ParkingSpot ps: parkingSpots){
            if (ps.unparkVehicle(vehicle)){
                System.out.println(vehicle.getVehicleNumber()+" is unparked from " +ps.id);
                return true;
            }
        }
        System.out.println("vehicle not found with number "+ vehicle.getVehicleNumber());
        return false;
    }

    public boolean isSpotAvailable(){
        for (ParkingSpot ps: parkingSpots){
            if(ps.isAvailable()){
                return true;
            }
        }
        return false;
    }


}
