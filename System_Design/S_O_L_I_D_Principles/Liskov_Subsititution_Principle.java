package System_Design.S_O_L_I_D_Principles;


import java.util.ArrayList;
import java.util.List;

interface Bike{
    void turnOnEngine();
    void accelerate();
}

class MotorCycle implements Bike{
    boolean isEngineOn;
    int speed;


    @Override
    public void turnOnEngine() {
        //turn on the engine
        isEngineOn=true;
    }

    @Override
    public void accelerate() {
        //increase the speed
        speed=speed+10;
    }
}

class Bicycle implements Bike{

    //here we are narrow down the capability of Bike
    //we are changing the default behaviour of
    // object of bike by throwing exception
    @Override
    public void turnOnEngine() {
        throw new AssertionError("There is no engine bicycle");
    }

    @Override
    public void accelerate() {
        //do something
    }
}

//solution
class Vehicle{
    public Integer getNumberOfWheels(){
        return 2;
    }
}

class EngineVehicle extends Vehicle{
    public Boolean hasEngine(){
        return true;
    }
}


class MotorCyclee extends EngineVehicle{

}

 class Car extends EngineVehicle{

    @Override
    public Integer getNumberOfWheels(){
        return 4;
    }


}

class Bycyclee extends Vehicle{

}

public class Liskov_Subsititution_Principle {
    public static void main(String[] args){
        List<Vehicle> vehicleList = new ArrayList<>();
        vehicleList.add(new MotorCyclee());
        vehicleList.add(new Car());
        vehicleList.add(new Bycyclee());

        for(Vehicle v : vehicleList){
            //compile time errpr
            //System.out.println(v.hasEngine().toString());
            System.out.println(v.getNumberOfWheels().toString());
        }
    }
}
