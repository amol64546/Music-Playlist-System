import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Album {
    private String name;
    private String artist;
    private List<Song> songs;

    public Album(String title, String artist) {
        this.name = title;
        this.artist = artist;
        this.songs = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public List<Song> getSong() {
        return songs;
    }

    public void setSong(List<Song> songs) {
        this.songs = songs;
    }

    // find song
    public boolean findSong(String title){
        for(Song song: songs){
            if(song.getTitle().equals(title))
                return true;
        }
        return false;
    }

    // add song to album
    public String addSongToAlbum(String title, double duration){
        if(!findSong(title)){
            songs.add(new Song(title,duration));
            return "Song added to Album";
        }
        return "Song already exists";
    }

    public String addSongToPlaylistFromAlbum(String title, List<Song> playlist){
        if(findSong(title)){
            for(Song s: this.songs){
                if(s.getTitle().equals(title)){
                    playlist.add(s);
                    return "Song added to your playlist";
                }
            }
        }
        return "Song not present in Album";
    }

    public String addSongToPlaylistFromAlbum(int trackNo, List<Song> playlist){
        int index = trackNo-1;
        if(index>=0 && index<this.songs.size()){
            playlist.add(this.songs.get(index));
            return "Song has been added to your playlist";
        }
        return "Invalid position of song";
    }
}
