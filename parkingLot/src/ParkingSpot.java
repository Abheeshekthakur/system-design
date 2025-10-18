import Vehicle.Vehicle;

import javax.lang.model.type.NullType;

public class ParkingSpot {
    public int id;
    private Vehicle vehicle;
    private String parkingSpotType;

    public ParkingSpot(int id, String parkingType){
        this.id=id;
        this.parkingSpotType=parkingType;
        this.vehicle=null;
    }

    public boolean parkVehicle(Vehicle vehicle){
        if (this.vehicle == null && this.parkingSpotType==vehicle.getType()) {
            this.vehicle = vehicle;
            return true;
        }
        this.vehicle=null;
        return false;
    }

    public boolean unparkVehicle(Vehicle vehicle){
        if(this.vehicle!=null && this.parkingSpotType==vehicle.getType() && vehicle.getVehicleNumber() == this.vehicle.getVehicleNumber()){
            this.vehicle=null;
            return true;
        }
        return false;
    }

    public boolean isAvailable(){
        return this.vehicle==null;
    }

}
