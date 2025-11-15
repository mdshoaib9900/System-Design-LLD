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
class SmartLightAdapter implements SmartDevice{
    private SmartLight smartLight;
    public SmartLightAdapter(SmartLight smartLight){
        this.smartLight=smartLight;
    }

    @Override
    public void turnOn() {
        smartLight.connectedViaWifi();
        smartLight.switchOn();
    }

    @Override
    public void turnOf() {
        smartLight.disconnectWifi();
        smartLight.switchOff();
    }


}
class CoffeMachineAdapter implements SmartDevice{

    private CoffeMachine coffeMachine;

    public CoffeMachineAdapter(CoffeMachine coffeMachine){
        this.coffeMachine=coffeMachine;
    }


    @Override
    public void turnOn() {
        coffeMachine.initializeConnectionViaZigbee();
        coffeMachine.startBrewing();
    }

    @Override
    public void turnOf() {
        coffeMachine.teriminateConnectionViaZigbee();
        coffeMachine.stopBrewing();
    }

}
public class AdapterPattern{
    public static void main(String[] args) {
        SmartDevice ac=new AirconditionerAdapter(new Airconditioning());
        SmartDevice light=new SmartLightAdapter(new SmartLight());
        SmartDevice coffe=new CoffeMachineAdapter(new CoffeMachine());
        ac.turnOn();
        light.turnOn();
        coffe.turnOn();
        ac.turnOf();   
        light.turnOf();
        coffe.turnOf();
    }
}