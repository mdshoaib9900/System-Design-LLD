interface PaymentStratergy{
    void pay(double amount);
}


class UpiPayments implements  PaymentStratergy{
    private String upiId;
    public UpiPayments(String upiId){
        this.upiId=upiId;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid rs"+amount+"using upi "+upiId);
    }
}
class CreditCardPayments implements  PaymentStratergy{
    private String cardNumber;
    public CreditCardPayments(String cardNumber){
        this.cardNumber=cardNumber;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid rs"+amount+"using credit card "+cardNumber);
    }
}
class DebitCardPayments implements  PaymentStratergy{
    private String cardNumber;
    public DebitCardPayments(String cardNumber){
        this.cardNumber=cardNumber;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid rs"+amount+"using debit card "+cardNumber);
    }
}
class CryptoPayments implements  PaymentStratergy{
    private String tokenNo;
    public CryptoPayments(String tokenNo){
        this.tokenNo=tokenNo;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid rs"+amount+"using Crypto "+tokenNo);
    }
}

class PaymentContext{
    private PaymentStratergy stratergy;
    public void setPaymentStratergy(PaymentStratergy stratergy){
        this.stratergy=stratergy;
    }

    public void check(double amount){
        if(stratergy==null){
            System.out.println("please select a payment method first");
            return;
        }
        stratergy.pay(amount);
    }
}
public class StratergyPattern{
    public static void main(String[] args) {
        PaymentContext context=new PaymentContext();
        context.setPaymentStratergy(new CreditCardPayments("123-456-789"));
        context.check(1000);


        context.setPaymentStratergy(new UpiPayments("shoaib@ybl"));
        context.check(2000);
    }
}