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
public class BookingManagement{
    public static void main(String[] args) {
        
    }
}