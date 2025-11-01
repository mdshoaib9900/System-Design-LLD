interface Vehicle{
    void start();
    void stop();
}

 class Honda implements Vehicle{

    @Override
    public void start() {
        System.err.println("Honda starting..");
    }

    @Override
    public void stop() {
        System.err.println("Honda stoping..");
    }
    
}
 class Suzuki implements Vehicle{

    @Override
    public void start() {
        System.err.println("Suzuki starting..");
    }

    @Override
    public void stop() {
        System.err.println("Suzuki stoping..");
    }
    
}
class Toyota implements Vehicle{

    @Override
    public void start() {
        System.err.println("Toyota starting..");
    }

    @Override
    public void stop() {
        System.err.println("Toyota stoping..");
    }
    
}
interface  Vehiclefactory{
    Vehicle creatVehicle();

}
class HondaFactory implements Vehiclefactory{
    @Override
    public  Vehicle creatVehicle(){
        return new Honda();
    }
}
class ToyotaFactory implements Vehiclefactory{
    @Override
    public  Vehicle creatVehicle(){
        return new Toyota();
    }
}
class SuzukiFactory implements Vehiclefactory{
    @Override
    public  Vehicle creatVehicle(){
        return new Suzuki();
    }
}

public class AbstractFactoryPattern{
    public static void main(String[] args) {
        Vehiclefactory hondafactory=new HondaFactory();
        Vehicle honda=hondafactory.creatVehicle();
        honda.start();
        honda.stop();
        Vehiclefactory toyotaFactory=new ToyotaFactory();
        Vehicle toyota=toyotaFactory.creatVehicle();
        toyota.start();
        toyota.stop();

    }
}