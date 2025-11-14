
import java.util.*;

abstract class Room{
    protected String type;
    protected double price;

    public String getType(){
        return type;
    }
    public double getPrice(){
        return price;
    }

    public String toString(){
        return type+" Room (₹" + price + ")";
    }
}
class SingleRoom extends Room {
    public SingleRoom() { this.type = "Single"; this.price = 2000; }
}
class DoubleRoom extends Room {
    public DoubleRoom() { this.type = "Double"; this.price = 3500; }
}
class DeluxeRoom extends Room {
    public DeluxeRoom() { this.type = "Deluxe"; this.price = 6000; }
}

class RoomFactory{
    public static Room createRoom(String type){
        switch (type.toLowerCase()) {
            case "single": return new SingleRoom();
            case "double":return new DoubleRoom();
            case "deluxe":return new DeluxeRoom();
            default:
                throw new IllegalArgumentException("Invalid room type");
        }
    }
}

interface HotelFactory{
    Room createStandardRoom();
    Room createPremiumRoom();
}

class LuxuryHotelFactory implements HotelFactory{

    @Override
    public Room createStandardRoom() {
       return new DeluxeRoom();
    }

    @Override
    public Room createPremiumRoom() {
        return new DeluxeRoom();
    }

}
class BudgetHotelFactory implements HotelFactory{

    @Override
    public Room createStandardRoom() {
       return new SingleRoom();
    }

    @Override
    public Room createPremiumRoom() {
        return new DoubleRoom();
    }

}

class Booking{
    Room room;
    boolean breakfast;
    boolean pickup;
    double totalAmount;
    public Booking(){

    }
    public Booking(BookingBuilder bookingBuilder){
        this.room=bookingBuilder.room;
        this.breakfast=bookingBuilder.breakfast;
        this.pickup=bookingBuilder.pickup;
        this.totalAmount=room.getPrice()+
        (breakfast ? 300:0)+
        (pickup ? 500:0);
    }

    public Room getRoom(){
        return room;
    }
    public boolean getBreakfast(){
        return breakfast;
    }
    public boolean getPickUp(){
        return pickup;
    }

     @Override
    public String toString() {
        return """
               
               --- Booking Summary ---
               Room: """ + room +
               "\nBreakfast: " + (breakfast?"Yes":"No") +
               "\nPickup: " + (pickup?"Yes":"No") +
               "\nTotal Amount: ₹" + totalAmount +
               "\n------------------------";
    }

}

class BookingBuilder{
    Room room;
    boolean breakfast;
    boolean pickup;

    public BookingBuilder setRoom(Room room){
        this.room=room;
        return this;
    }
    public BookingBuilder setBreakfast(boolean  breakfast){
        this.breakfast=breakfast;
        return this;
    }
     public BookingBuilder addPickup(boolean p) {
        this.pickup = p; 
        return this;
    }
    public Booking build(){
        return new Booking(this);
    }
   
}
class BookingPrototypeRegistry{
   private static Map<String , Booking> register=new HashMap<>();

   public void addPrototype(String name,Booking booking){
    register.put(name, booking);
   }

    public static Booking clone(String name){
        try {
            Booking prototype=register.get(name);
            Booking clone=new Booking();
            clone.room=prototype.room;
            clone.breakfast=prototype.breakfast;
            clone.pickup=prototype.pickup;
            clone.totalAmount=prototype.totalAmount;
            return clone;

        } catch (Exception e) {
            throw new RuntimeException("No clone found");
        }
    }
}
public class BookingManagement{
    public static void main(String[] args) {
        
    }
}