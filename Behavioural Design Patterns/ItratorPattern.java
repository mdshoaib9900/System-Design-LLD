
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
       return index<shuffeledSongs.size();
    }

    @Override
    public String next() {
       return shuffeledSongs.get(index++);
    }

}
class FavPlaylist implements PlaylistIterator{
    private Playlist playlist;
    int index;
    public FavPlaylist(Playlist playlist){
        this.playlist=playlist;
        this.index=0;
    }
    @Override
    public boolean hasNext() {
        while(index<playlist.getSongs().size()){
            if(playlist.getSongs().get(index).contains("Fav")){
                return true;
            }index++;
        }
        return false;
    }

    @Override
    public String next() {
       return playlist.getSongs().get(index++);
    }

}
class Playlist{
    private ArrayList<String> songs;
    public Playlist(){
        this.songs=new ArrayList<>();
    }

    public void addSong(String song){
        songs.add(song);
    }
    public PlaylistIterator iterator(String type){
        switch (type) {
            case "simple":
                    return new SimplePlaylistItrator(this);
                
            case "shuffle":
                return new ShuffledPlaylist(this);
            case "fav":
                return new FavPlaylist(this);

            default:
                return null;
        }

    }
    public ArrayList<String> getSongs(){
        return songs;
    }
}
public class ItratorPattern{
    public static void main(String[] args) {
        Playlist playlist=new Playlist();
        playlist.addSong("new song");
        playlist.addSong("new song 1");
        playlist.addSong("new song 2");
        playlist.addSong("new song Fav 1 ");
        playlist.addSong("new song 3");
        playlist.addSong("new song Fav 2 ");

        System.out.println("SimplePlaylistItrator");
        PlaylistIterator simple=playlist.iterator("simple");
        while(simple.hasNext()){
            System.out.println("Playing "+simple.next());
        }
        System.out.println("shuffelled");
        PlaylistIterator shuffeled=playlist.iterator("shuffle");
        while(shuffeled.hasNext()){
            System.out.println("Playing shuffeled "+shuffeled.next());
        }
        System.out.println("Fav");
        PlaylistIterator fav=playlist.iterator("Simple");
        while(fav.hasNext()){
            System.out.println("Playing fav "+fav.next());
        }

    }
}