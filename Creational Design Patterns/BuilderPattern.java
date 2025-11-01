class Car {
    private String engine;
    private int wheels;
    private int seats;
    private String color;
    private boolean sunroof;
    private boolean navigationSystem;


    public Car(CarBuilder builder){
        this.engine=builder.engine;
        this.wheels=builder.wheels;
        this.seats=builder.seats;
        this.color=builder.color;
        this.sunroof=builder.sunroof;
        this.navigationSystem=builder.navigationSystem;

    }

    public String getEngine() {
        return engine;
    }

    public int getWheels() {
        return wheels;
    }

    public int getSeats() {
        return seats;
    }

    public String getColor() {
        return color;
    }

    public boolean isSunroof() {
        return sunroof;
    }

    public boolean isNavigationSystem() {
        return navigationSystem;
    }

    @Override
    public String toString(){
        return getEngine()+" "+getColor()+" "+getSeats()+" "+getWheels()+" "+isSunroof()+" "+isNavigationSystem();
    }
}

class CarBuilder {
     String engine;
     int wheels ;
     int seats ;
     String color;
     boolean sunroof ;
     boolean navigationSystem;

    public CarBuilder setEngine(String engine) {
        this.engine = engine;
        return this;
    }

    public CarBuilder setWheels(int wheels) {
        this.wheels = wheels;
        return this;
    }

    public CarBuilder setSeats(int seats) {
        this.seats = seats;
        return this;
    }

    public CarBuilder setColor(String color) {
        this.color = color;
        return this;
    }

    public CarBuilder setSunroof(boolean sunroof) {
        this.sunroof = sunroof;
        return this;
    }

    public CarBuilder setNavigationSystem(boolean navigationSystem) {
        this.navigationSystem = navigationSystem;
        return this;
    }

    public Car build() {
      return new Car(this);
    }
}

public  class BuilderPattern{
    public static void main(String[] args) {
        Car car1=new CarBuilder().setEngine("v5")
        .setColor("red")
        .setWheels(4)
        .setSeats(6)
        .setNavigationSystem(true)
        .setSunroof(true)
        .build();
        System.err.println(car1.toString());

        Car car2=new CarBuilder()
        .setEngine("v4")
        .setColor("blue")
        .setSunroof(false)
        .setNavigationSystem(true)
        .setWheels(4)
        .build();
        System.err.println(car2.toString());

    }
}