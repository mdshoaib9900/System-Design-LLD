interface Command{
    void execute();
}

class  TurnOnCommand implements Command{
    private Tv tv;
    public TurnOnCommand(Tv tv){
        this.tv=tv;
    }

    @Override
    public void execute() {
       tv.trunOn();
    }
}
class  TurnOffCommand implements Command{
    private Tv tv;
    public TurnOffCommand(Tv tv){
        this.tv=tv;
    }

    @Override
    public void execute() {
       tv.trunOf();
    }
}
class ChangeChannelCommand implements Command{
     private Tv tv;
     private int channel;
     public ChangeChannelCommand(Tv tv,int channel){
        this.tv=tv;
        this.channel=channel;
     }

    @Override
    public void execute() {
       tv.changeChannel(channel);
    }

}
class  AdjustVolumeCommand implements Command{
    private Tv tv;
    private int volume;
    public AdjustVolumeCommand(Tv tv,int volume){
        this.tv=tv;
        this.volume=volume;
    }

    @Override
    public void execute() {
       tv.adjustVolume(volume);
    }
}
class RemoteControl{
    private  Command onCommand;
    private Command offCommand;

    public void setOnCommand(Command onCommand){
        this.onCommand=onCommand;
    }
    public void setOffCommand(Command offCommand){
        this.offCommand=offCommand;
    }

    public void pressOnButton(){
        onCommand.execute();
    }
    public void pressOffButton(){
        offCommand.execute();
    }
}
class Tv{
    public void trunOn(){
        System.out.println("turning the tv on..");
    }
    public void turnOff(){
        System.out.println("turning tv off..");
    }
    public void changeChannel(int channel){
        System.out.println("Changed channel to "+channel);
    }
     public void adjustVolume(int vol){
        System.out.println("Changed volume to "+vol);
    }
}
public class CommandPattern{
    public static void main(String[] args) {
        
    }
}