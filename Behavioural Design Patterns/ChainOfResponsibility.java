abstract class Approver{
    protected Approver nextApprover;
    public void setNextApprover(Approver nextApprover){
        this.nextApprover=nextApprover;
    }

    public abstract void processLeaveRequest(int leaveDays);
}
class Supervisor extends Approver{

    @Override
    public void processLeaveRequest(int leaveDays) {
        if(leaveDays<=3){
            System.out.println("Supervisor approved the leave");
        }else if(nextApprover!=null){
            nextApprover.processLeaveRequest(leaveDays);
        }
    }

}
class Manager extends Approver{

    @Override
    public void processLeaveRequest(int leaveDays) {
        if(leaveDays<=7){
            System.out.println("Manager approved the leave");
        }else if(nextApprover!=null){
            nextApprover.processLeaveRequest(leaveDays);
        }
    }

}
class Director extends Approver{

    @Override
    public void processLeaveRequest(int leaveDays) {
        if(leaveDays<=14){
            System.out.println("Director approved the leave");
        }else if(nextApprover!=null){
            nextApprover.processLeaveRequest(leaveDays);
        }else{
            System.out.println("leave request denied becuz too many days");
        }
    }

}
public class ChainOfResponsibility{
    public static void main(String[] args) {
        Approver supervisor=new Supervisor();
        Approver manager=new Manager();
        Approver director=new Director();
        supervisor.setNextApprover(manager);
        manager.setNextApprover(director);
        int leaveDays=7;
        System.out.println("employee requets for "+leaveDays+" of leave");
        supervisor.processLeaveRequest(leaveDays);


    }
}