
import java.util.*;

interface VideoServiceInterface{
    void playVideo(String userType,String videoName);
}
class RealVideoService implements VideoServiceInterface{

    @Override
    public void playVideo(String userType, String videoName) {
       System.out.println("Streaming video "+videoName);
    }

}
class ProxyVideoService implements  VideoServiceInterface{
    private  RealVideoService realVideoService;
    private Map<String,String> cachedVideos=new HashMap<>();
    private Map<String,Integer> requestCount=new HashMap<>();

    public ProxyVideoService(RealVideoService realVideoService){
        this.realVideoService=realVideoService;
    }


    @Override
    public void playVideo(String userType, String videoName) {
        if(!userType.equals("premium") && videoName.startsWith("premium")){
            System.out.println("Access denied :premium video requires premium services ");
            return;
        }
        requestCount.put(userType, requestCount.getOrDefault(userType,0)+1);
        if(requestCount.get(userType)>3){
            System.out.println("Access denied..");
            return;
        }
        if(cachedVideos.containsKey(videoName)){
            System.out.println("Streaming cached video "+videoName);
        }else{
            realVideoService.playVideo(userType, videoName);
            cachedVideos.put(videoName, videoName);
        }
    }


}
public class ProxyPattern{
    public static void main(String[] args) {
        RealVideoService realVideoService=new RealVideoService();
        ProxyVideoService proxyVideoService=new ProxyVideoService(realVideoService);

        proxyVideoService.playVideo("free", "free video 1");
        proxyVideoService.playVideo("premium", "premium video 1");
        proxyVideoService.playVideo("guest", "video 1");


        for(int i=0;i<3;i++){
            proxyVideoService.playVideo("free", "free video 2");
        }

    }
}