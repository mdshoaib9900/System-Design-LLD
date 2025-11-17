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
}
public class FacadePattern{
    public static void main(String[] args) {
        
    }
}