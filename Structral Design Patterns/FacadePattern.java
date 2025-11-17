
import java.util.*;

class MusicPlayer{
    public void initalizeAudioDrivers(){
        System.out.println("initializing audio drives");
    }
    public void decodeAudio(){
        System.out.println("Audio decoded");
    }
    public void startPlayBack(){
        System.out.println("starting music");
    }
}
class VideoPlayer{
    public void initalizeAudioDrivers(){
        System.out.println("initializing video drives");
    }
    public void decodeAudio(){
        System.out.println("video decoded");
    }
    public void startPlayBack(){
        System.out.println("starting video");
    }
}
class MediaFacade{
    private MusicPlayer musicPlayer;
    private VideoPlayer videoPlayer;
    public MediaFacade(){
        this.musicPlayer=new MusicPlayer();
        this.videoPlayer=new VideoPlayer();
    }

    public void performAction(String action){
        switch (action.toLowerCase()) {
            case "music"->{ musicPlayer.initalizeAudioDrivers();
                            musicPlayer.decodeAudio();
                            musicPlayer.startPlayBack();
            }
            case "video"->{
                videoPlayer.initalizeAudioDrivers();
                videoPlayer.decodeAudio();
                videoPlayer.startPlayBack();
            }
            default->System.out.println("no macth found");
        }
    }
}
public class FacadePattern{
    public static void main(String[] args) {
        MediaFacade mediaFacade=new MediaFacade();
        System.out.println("welcome back!!");
        System.out.println("choose audio or video enter below");
        Scanner sc=new Scanner(System.in);
        String ans=sc.next();
        mediaFacade.performAction(ans);
    }
}