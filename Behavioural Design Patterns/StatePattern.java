interface TrafficLightState{
    void next(TrafficLightContext context);
    String getColor();
}
class RedState implements TrafficLightState{

    @Override
    public void next(TrafficLightContext context) {
        System.out.println("Swtiching from Red to Green ");
    }

    @Override
    public String getColor() {
        return "RED";
    }

}
class YellowState implements TrafficLightState{

    @Override
    public void next(TrafficLightContext context) {
        System.out.println("Swtiching from Yellow to Green ");
    }

    @Override
    public String getColor() {
        return "Yellow";
    }

}class GreenState implements TrafficLightState{

    @Override
    public void next(TrafficLightContext context) {
        System.out.println("Swtiching from Yellow to Green ");
    }

    @Override
    public String getColor() {
        return "Green";
    }

}
public class StatePattern{
    public static void main(String[] args) {
        
    }
}