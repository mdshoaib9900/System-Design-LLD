interface Patient{
    void accept(Visitor visitor);
}
class ChildPatient implements Patient{

    @Override
    public void accept(Visitor visitor) {
       visitor.visit(this);
    }

}
class AdultPatient implements Patient{

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

}
class SeniorPatient implements Patient{

    @Override
    public void accept(Visitor visitor) {
       visitor.visit(this);
    }

}
interface Visitor{
    void visit(ChildPatient patient);
    void visit(AdultPatient patient);
    void visit(SeniorPatient patient);
}
class DiagnosisVisitor implements Visitor{

    @Override
    public void visit(ChildPatient patient) {
       System.out.println("child visitor");
    }

    @Override
    public void visit(AdultPatient patient) {
       System.out.println("adult visitor");

    }

    @Override
    public void visit(SeniorPatient patient) {
       System.out.println("Senior visitor");
    }

}
class BillingVisitor implements Visitor{

    @Override
    public void visit(ChildPatient patient) {
        System.out.println("billing child patient");
    }

    @Override
    public void visit(AdultPatient patient) {
    System.out.println("billing Adult patient");
    }

    @Override
    public void visit(SeniorPatient patient) {
        System.out.println("billing Senior patient");
    }

}
public class VisitorPattern{
    public static void main(String[] args) {
        Patient[] patients={
            new ChildPatient(),
            new AdultPatient(),
            new SeniorPatient()
        };
        Visitor diagnosis=new DiagnosisVisitor();
        Visitor  billing =new BillingVisitor();

        for(Patient p:patients){
            p.accept(diagnosis);
            p.accept(billing);
        }
    }
}