import Vehicle.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private static ParkingLot instance;
    private List<Level> levels;

    private ParkingLot(){
        levels=new ArrayList<>();
    }
    public static ParkingLot getInstance(){
        if (instance==null){
            instance = new ParkingLot();
        }
        return instance;
    }

    public void addLevel(int lvlNum, int parkingSpots){
        levels.add(new Level(lvlNum,parkingSpots));
    }

    public void parkVehicle(Vehicle vehicle){
        for(Level lvl: levels){
            if (lvl.isSpotAvailable()){
                lvl.parkVehicle(vehicle);
                System.out.println("vehicle is parked at "+ lvl.levelNumber);
            }
        }
    }

    public void unparkVehicle(Vehicle vehicle){
        for(Level lvl: levels){
           if(lvl.unparkVehicle(vehicle)){
               System.out.println(vehicle.getType()+" "+vehicle.getVehicleNumber()+" is unparked.");
           }else{
               System.out.println("vehicle is not present with license plate "+ vehicle.getVehicleNumber());
           }
        }
    }

}
