interface Renderer{
    void renderCircle(double radius);
    void renderReactangle(double  width,double height);
}

class ResterRenderer implements Renderer{

    @Override
    public void renderCircle(double radius) {
        System.out.println("Rester rendering : drawing a circle of radius  "+radius);
    }

    @Override
    public void renderReactangle(double width, double height) {
        System.out.println("Rester rendering : drawing a reactangle of height  "+height+" width "+width);
        
    }

}
class VectorRenderer implements Renderer{

    @Override
    public void renderCircle(double radius) {
        System.out.println("Vector rendering : drawing a circle of radius  "+radius);
        
    }

    @Override
    public void renderReactangle(double width, double height) {
        System.out.println("Vector rendering : drawing a reactangle of width  "+width +" height "+height);
        
    }

}
abstract class Shape{
    protected Renderer renderer;
    public  Shape(Renderer renderer){
        this.renderer=renderer;
    }

    public abstract void draw();
}

 class Circle extends  Shape{
    private double radius;

    public Circle(Renderer renderer,double radius){
        super(renderer);
        this.radius=radius;
    }

    @Override
    public void draw() {
       renderer.renderCircle(radius);
    }

}
 class Reactangle extends  Shape{
    private double width;
    private double height;


    public Reactangle(Renderer renderer,double width,double height){
        super(renderer);
        this.width=width;
        this.height=height;
    }

    @Override
    public void draw() {
       renderer.renderReactangle(width,height);
    }

}
public class BridgePattern{
    public static void main(String[] args) {
        
    }
}