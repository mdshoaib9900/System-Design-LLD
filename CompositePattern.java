
import java.util.ArrayList;
import java.util.List;

interface SmartComponents{
    void turnOn();
    void turnOff();
}
class Ac implements SmartComponents{

    @Override
    public void turnOn() {
        System.out.println("turn on ac..");
    }

    @Override
    public void turnOff() {
        System.out.println("turn off ac");
    }

}
class Light implements SmartComponents{

    @Override
    public void turnOn() {
        System.out.println("turn on light..");
    }

    @Override
    public void turnOff() {
        System.out.println("turn off light");
    }

}
class Fan implements SmartComponents{

    @Override
    public void turnOn() {
        System.out.println("turn on fan..");
    }

    @Override
    public void turnOff() {
        System.out.println("turn off fan");
    }

}
class CompositeSmartComponents implements SmartComponents{
    private  List<SmartComponents> components=new ArrayList<>();
    
    public void addComponent(SmartComponents component){
        components.add(component);
    }
    public void removeComponent(SmartComponents component){
        components.remove(component);
    }
    @Override
    public void turnOn() {
        for(SmartComponents  component:components){
            component.turnOn();
        }
    }

    @Override
    public void turnOff() {
        for(SmartComponents component:components){
            component.turnOff();
        }
    }

}
public class CompositePattern{
    public static void main(String... args) {
        SmartComponents ac=new Ac();
        SmartComponents light=new Light();

        CompositeSmartComponents room1=new CompositeSmartComponents();
        room1.addComponent(ac);
        room1.addComponent(light);
        CompositeSmartComponents room2=new CompositeSmartComponents();
        room2.addComponent(ac);
        room2.addComponent(light);
        CompositeSmartComponents room3=new CompositeSmartComponents();
        room3.addComponent(ac);
        room3.addComponent(light);
    }
}