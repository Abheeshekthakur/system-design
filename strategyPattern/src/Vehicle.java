import DriveStrategy.DriveStrategy;
public class Vehicle {
    DriveStrategy driveStrategy;
   Vehicle(DriveStrategy obj){
       this.driveStrategy=obj;
   }

   void drive(){
       driveStrategy.drive();
   }
}
