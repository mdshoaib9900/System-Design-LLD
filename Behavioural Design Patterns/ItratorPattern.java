
import java.util.*;

interface PlaylistIterator{
    boolean hasNext();
    String next();
}
class  SimplePlaylistItrator implements PlaylistIterator{
    private Playlist playlist;
    private int index;
    public SimplePlaylistItrator(Playlist playlist){
        this.playlist=playlist;
        this.index=0;
    }

    @Override
    public boolean hasNext() {
        return index<playlist.getSongs().size();
    }

    @Override
    public String next() {
       return playlist.getSongs().get(index++);
    }

}
class ShuffledPlaylist implements PlaylistIterator{
    private Playlist playlist;
    private int index;
    private ArrayList<String> shuffeledSongs;
    public  ShuffledPlaylist(Playlist playlist){
        this.playlist=playlist;
        this.index=0;
        this.shuffeledSongs=new ArrayList<>(playlist.getSongs());
        Collections.shuffle(shuffeledSongs);
    }
    

    @Override
    public boolean hasNext() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String next() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
public class ItratorPattern{
    public static void main(String[] args) {
       
    }
}