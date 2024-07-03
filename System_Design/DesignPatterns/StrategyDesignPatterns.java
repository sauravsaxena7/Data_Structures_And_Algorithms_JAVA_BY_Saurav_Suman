package System_Design.DesignPatterns;

interface DriveInterface{
    void drive(String Strategy);
}

class NormalDriveStrategy implements DriveInterface{

    @Override
    public void drive(String Strategy) {
        System.out.println(Strategy);
    }
}
class SpecialDriveStrategy implements DriveInterface{

    @Override
    public void drive(String Strategy) {
        System.out.println(Strategy);
    }
}

class Vehicle{

    DriveInterface obj;
    String Strategy;
    Vehicle(DriveInterface obj,String Strategy){
        this.obj = obj;
        this.Strategy=Strategy;
    }

    public void drive(){
        obj.drive(Strategy);
    }
}

class OffRoadVehicle extends Vehicle{
    OffRoadVehicle(){super(new SpecialDriveStrategy(),"SpecialDriveStrategy OffRoad");}
}

class SPORTSVehicle extends Vehicle{
    SPORTSVehicle(){super(new SpecialDriveStrategy(),"SpecialDriveStrategy SPORTS");}
}

class PassegerVehicle extends Vehicle{
    PassegerVehicle(){super(new NormalDriveStrategy(),"NormalDriveStrategy Passenger");}
}

public class StrategyDesignPatterns {
    public static void main(String[] args){
        Vehicle vehicle = new SPORTSVehicle();
        vehicle.drive();
    }
}
