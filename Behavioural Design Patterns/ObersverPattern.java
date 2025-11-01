
import java.util.*;


interface Subscriber{
    void update(String video);
}

class YoutubeSubscriber implements Subscriber{
    private String name;
    public YoutubeSubscriber(String name){
        this.name=name;
    }

    @Override
    public void update(String video) {
         System.out.println(name + " is watching the new video: " + video);
    }


}
class EmailSubscriber implements Subscriber{
    private String email;
    public EmailSubscriber(String email){
        this.email=email;
    }

    @Override
    public void update(String video) {
          System.out.println("📧 Sending email to " + email + ": New video uploaded → " + video);
    }


}
class  PushNotificationSubscriber implements Subscriber{
    private String DeviceName;
    public PushNotificationSubscriber(String DeviceName){
        this.DeviceName=DeviceName;
    }

    @Override
    public void update(String video) {
        System.out.println("📱 Sending push notification to " + DeviceName + ": New video uploaded → " + video);
    }


}

interface YouTubeChannel {
    void addSubscriber(Subscriber subscriber);
    void removeSubscriber(Subscriber subscriber);
    void notifySubscribers();
}

class YouTubeChannelImpl implements YouTubeChannel{
    List<Subscriber> subscribers=new ArrayList<>();
    public String video;

    @Override
    public void addSubscriber(Subscriber subscriber) {
       subscribers.add(subscriber);
    }

    @Override
    public void removeSubscriber(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

    @Override
    public void notifySubscribers() {
        for(Subscriber subscriber:subscribers)
        {
            subscriber.update(video);
        }
    }

    public void uploadNewVideo(String video) {
        System.out.println("\n Uploading new video: " + video);
        this.video = video;
        notifySubscribers();
    }


}
public class ObersverPattern{
    public static void main(String[] args) {
        YouTubeChannelImpl channel=new YouTubeChannelImpl();
        Subscriber alice=new YoutubeSubscriber("alice");
        Subscriber bob=new YoutubeSubscriber("bob");
        Subscriber emailSub=new EmailSubscriber("shoaib@gmail.com");
        Subscriber pushNot=new PushNotificationSubscriber("Alice's Phone");


        channel.addSubscriber(alice);
        channel.addSubscriber(bob);
        channel.addSubscriber(pushNot);
        channel.addSubscriber(emailSub);


        channel.uploadNewVideo("java lld playlist");

        channel.removeSubscriber(bob);

        channel.uploadNewVideo("ObersverPattern video is uploaded");

    }
}