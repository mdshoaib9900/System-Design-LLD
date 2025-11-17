interface Coffee{
    String getDescription();
    double getCost();
}
class Expresso implements Coffee{

    @Override
    public String getDescription() {
       return "Expresso";
    }

    @Override
    public double getCost() {
       return 20.00;
    }

}
class Cappucino implements Coffee{

    @Override
    public String getDescription() {
       return "Cappucino";
    }

    @Override
    public double getCost() {
       return 40.00;
    }

}
abstract class CoffeeDecorator implements Coffee{
    protected Coffee coffee;
    public CoffeeDecorator(Coffee coffee){
        this.coffee=coffee;
    }
    @Override
    public String getDescription() {
       return coffee.getDescription();
    }

    @Override
    public double getCost() {
       return coffee.getCost();
    }

}
class MilkDecorator extends CoffeeDecorator{
    public MilkDecorator(Coffee coffee){
        super(coffee);
    }
    @Override
    public String getDescription() {
       return coffee.getDescription()+" Milk";
    }

    @Override
    public double getCost() {
       return coffee.getCost()+10.0;
    }
}
class SugarDecorator extends CoffeeDecorator{
    public SugarDecorator(Coffee coffee){
        super(coffee);
    }
    @Override
    public String getDescription() {
       return coffee.getDescription()+" Sugar";
    }

    @Override
    public double getCost() {
       return coffee.getCost()+5.0;
    }
}
class VanillaDecorator extends CoffeeDecorator{
    public VanillaDecorator(Coffee coffee){
        super(coffee);
    }
    @Override
    public String getDescription() {
       return coffee.getDescription()+" Vanilla";
    }

    @Override
    public double getCost() {
       return coffee.getCost()+15.0;
    }
}
public class DecoratorPattern{
    public static void main(String[] args) {
        
    }
}