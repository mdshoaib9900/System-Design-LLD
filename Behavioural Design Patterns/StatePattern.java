interface TrafficLightState{
    void next(TrafficLightContext context);
    String getColor();
}
class RedState implements TrafficLightState{

    @Override
    public void next(TrafficLightContext context) {
        System.out.println("Swtiching from Red to Green ");
        context.setState(new GreenState());
    }

    @Override
    public String getColor() {
        return "RED";
    }

}
class YellowState implements TrafficLightState{

    @Override
    public void next(TrafficLightContext context) {
        System.out.println("Swtiching from Yellow to Red ");
        context.setState(new RedState());
    }

    @Override
    public String getColor() {
        return "Yellow";
    }

}class GreenState implements TrafficLightState{

    @Override
    public void next(TrafficLightContext context) {
        System.out.println("Swtiching from Green to Yellow");
        context.setState(new YellowState());
    }

    @Override
    public String getColor() {
        return "Green";
    }

}
class TrafficLightContext{
    private TrafficLightState state;

    public TrafficLightContext(){
        state=new RedState();
    }
    public void setState(TrafficLightState state){
        this.state=state;
    }
    public  void next(){
        state.next(this);
    }
    public String getColor(){
        return state.getColor();
    }
}
public class StatePattern{
    public static void main(String[] args) {
        TrafficLightContext context=new TrafficLightContext();
        context.next();
        context.next();
        context.next();
        context.next();
        
    }
}