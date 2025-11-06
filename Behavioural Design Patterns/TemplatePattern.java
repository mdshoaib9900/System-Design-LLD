abstract class Beverage{
    final void Beverage(){
        boilWater();
        brew();
        pourInCup();
        addCondiments();
    }
    void boilWater(){
        System.out.println("Boiling water..");
    }
    void pourInCup(){
        System.out.println("Pouring in cup..");

    }
    abstract void brew();
    abstract void addCondiments();
}
class CoffeeBeverage extends Beverage{

    @Override
    void brew() {
       System.out.println("Brewing coffee");
    }

    @Override
    void addCondiments() {
        System.out.println("adding milk and sugar");
    }

}
class TeaBeverage extends Beverage{

    @Override
    void brew() {
       System.out.println("Brewing Tea");
    }

    @Override
    void addCondiments() {
        System.out.println("adding milk,TeaPowder and sugar");
    }

}
public class TemplatePattern{
    public static void main(String[] args) {
        
    }
}