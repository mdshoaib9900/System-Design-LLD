interface SmartDevice{
    void turnOn();
    void turnOf();
}
class Airconditioning{
    public void connectedViaBluetooth(){
        System.out.println("AC connected via bluetooth");
    }
    public void startCooling(){
        System.out.println("Ac has started cooling..");
    }
    public void stopCooling(){
        System.out.println("Ac has stopped cooling..");
    }
    public void disconnectBluetooth(){
        System.out.println("Ac has been disconnected from bluetooth");
    }
}
public class AdapterPattern{
    public static void main(String[] args) {
        
    }
}