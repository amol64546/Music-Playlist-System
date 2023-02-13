import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Album album1 = new Album("Udd gaye","Ritviz");
        album1.addSongToAlbum("song 1",5.3);
        album1.addSongToAlbum("song 2",4.3);
        album1.addSongToAlbum("song 3",4.6);

        Album album2 = new Album("Moosa","Sidhu Moosewala");
        album2.addSongToAlbum("295",5.3);
        album2.addSongToAlbum("so high",4.3);
        album2.addSongToAlbum("same beef",4.6);

        List<Song> myPlaylist = new LinkedList<>();
        album2.addSongToPlaylistFromAlbum("295",myPlaylist);
        album2.addSongToPlaylistFromAlbum("so high",myPlaylist);
        album1.addSongToPlaylistFromAlbum(2,myPlaylist);


        play(myPlaylist);
    }

    public static void play(List<Song> playlist){
        if(playlist.size()==0){
            System.out.println("Playlist is empty");
            return;
        }

        ListIterator<Song> itr = playlist.listIterator();
        boolean isNext = true;

        System.out.println("Currently playing: ");
        System.out.println(itr.next());

        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("Enter your choice");
            int choice = sc.nextInt();

            switch (choice){
                case 1 -> {
                    if(!isNext){
                        itr.next();   // prev -> next
                        isNext = true;
                    }
                    if(itr.hasNext()){
                        System.out.println("Now playlist");
                        System.out.println(itr.next());
                    }else{
                        System.out.println("End of playlist");
                    }
                }
                case 2 -> {
                    if(isNext){
                        itr.previous(); // next -> prev
                        isNext = false;
                    }
                    if(itr.hasPrevious()){
                        System.out.println("Now playlist");
                        System.out.println(itr.previous());
                    }else{
                        System.out.println("Start of playlist");
                    }
                }
                case 3 -> {
                    if(isNext){
                        if(itr.hasPrevious()){
                            System.out.println(itr.previous());
                            isNext = false;
                        }
                    }else{
                        if(itr.hasNext()){
                            System.out.println(itr.next());
                            isNext = true;
                        }
                    }

                }
                case 4 -> {
                    if(isNext){
                        if(itr.hasPrevious()){
                            playlist.remove(itr.previous());
                            isNext = false;
                        }
                    }else{
                        if(itr.hasNext()){
                            playlist.remove(itr.next());
                            isNext = true;
                        }
                    }
                }
                case 5 -> {
                    printAllSongs(playlist);
                }
                case 6 -> {
                     printMenu();
                }
                case 7 -> {  // exit
                    return;
                }
            }
        }
    }

    public static void printAllSongs(List<Song>  playlist){
        for(Song song: playlist)
            System.out.println(song);
    }

    public static void printMenu(){
        System.out.println("1. Play next song");
        System.out.println("2. Play previous song");
        System.out.println("3. Play current song again");
        System.out.println("4. Delete current song");
        System.out.println("5. Show all songs");
        System.out.println("6. Show menu again");
        System.out.println("7. Exit");
    }
}