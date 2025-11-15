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
class SmartLight{
    public void connectedViaWifi(){
        System.out.println("AC connected via Wifi");
    }
    public void switchOn(){
        System.out.println("Light is truned on");
    }
    public void switchOff(){
        System.out.println("Light is turned off");
    }
    public void disconnectWifi(){
        System.out.println("Light is been disconnected via wifi");
    }
}
class CoffeMachine{
    public void initializeConnectionViaZigbee(){
        System.out.println("coffe machine connection initialized via zigbee");
    }
    public void startBrewing(){
        System.out.println("CoffeMachine is brewing coffee");
    }
    public void stopBrewing(){
        System.out.println("CoffeMachine stopped brewing");
    }
    public void teriminateConnectionViaZigbee(){
        System.out.println("coffe machine connection terminated via zigbee");
    }

}
class AirconditionerAdapter implements SmartDevice{
    private  Airconditioning airconditioning;
    public AirconditionerAdapter(Airconditioning airconditioning){
        this.airconditioning=airconditioning;
    }
    @Override
    public void turnOn() {
        airconditioning.connectedViaBluetooth();
        airconditioning.startCooling();
    }

    @Override
    public void turnOf() {
        airconditioning.disconnectBluetooth();
        airconditioning.startCooling();
    }

}
public class AdapterPattern{
    public static void main(String[] args) {
        
    }
}