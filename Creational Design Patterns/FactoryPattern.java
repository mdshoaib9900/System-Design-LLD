interface Vehicle{
    void start();
    void stop();
}

class Car implements Vehicle{

    @Override
    public void start() {
        System.err.println("starting..car");
    }

    @Override
    public void stop() {
        System.err.println("stoping..car");
    }
    
}
class Truck implements Vehicle{

    @Override
    public void start() {
        System.err.println("starting..truck");
    }

    @Override
    public void stop() {
        System.err.println("stoping..truck");
    }
    
}

class Vehiclefactory{
    public static Vehicle getVehicle(String vehicleType){
        if(vehicleType.equals("car")){
            return new Car();
        }else if(vehicleType.equals("truck")){
            return new Truck();
        }else{
            throw new IllegalArgumentException("no matching found");
        }
    }
}

public class FactoryPattern{
    public static void main(String[] args) {
        Vehicle vf= Vehiclefactory.getVehicle("car");
        vf.start();
        vf.stop();
        Vehicle vt=Vehiclefactory.getVehicle("truck");
        vt.start();
        vt.stop();

    }
}