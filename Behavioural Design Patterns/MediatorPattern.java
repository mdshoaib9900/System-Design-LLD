
import java.util.ArrayList;

interface  Mediator{
    void registerBidder(Bidder bidder);
    void placeBid(Bidder bidder,int amount);
}
class AuctionHouse implements Mediator{
    ArrayList<Bidder> bidders=new ArrayList<>();
    @Override
    public void registerBidder(Bidder bidder) {
        bidders.add(bidder);
    }

    @Override
    public void placeBid(Bidder bidder, int amount) {
        System.out.println(bidder.getName()+" placed a bid of amount "+amount);
        for(Bidder b:bidders){
            if(b!=bidder){
                b.recievedBid(bidder,amount);
            }
        }
    }

}
class Bidder{
    private String name;
    private Mediator mediator;
    public Bidder(Mediator mediator,String name){
        this.mediator=mediator;
        this.name=name;
    }
    public String getName(){
        return name;
    }
    public void placeBid(int amount){
        mediator.placeBid(this, amount);
    }
    public void recievedBid(Bidder bidder,int amount){
        System.out.println(name + "is Notififed "+bidder.getName() + "placed a bid of "+amount );
    }
}
public class MediatorPattern{
    public static void main(String[] args) {
        Mediator mediator=new AuctionHouse();
        Bidder bidder1=new Bidder(mediator,"alice");
        Bidder bidder2=new Bidder(mediator,"bob");
        Bidder bidder3=new Bidder(mediator,"shoaib");

        mediator.registerBidder(bidder1);
        mediator.registerBidder(bidder2);
        mediator.registerBidder(bidder3);
        mediator.placeBid(bidder3, 1000);


    }
}