abstract class Beverage{
    final void Beverage(){
        boilWater();
        brew();
        pourInCup();
        addCondiments();
    }
    void boilWater(){
        System.err.println("Boiling water..");
    }
    void pourInCup(){
        System.err.println("Pouring in cup..");

    }
    abstract void brew();
    abstract void addCondiments();
}
public class TemplatePattern{
    public static void main(String[] args) {
        
    }
}