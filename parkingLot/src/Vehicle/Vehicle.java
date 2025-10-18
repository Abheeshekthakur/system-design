package Vehicle;

public class Vehicle {
    private String vehicleType;
    private String vehicleNumber;
    public Vehicle(String number, String type){
        vehicleType=type;
        vehicleNumber=number;
    }

    public String getType(){
        return vehicleType;
    }

    public String getVehicleNumber(){
        return vehicleNumber;
    }


}
