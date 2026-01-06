//Pulkit Hooda
import java.util.ArrayList;
public class LibraryTest
{
    public static void main(String[] args)
    {
        Library lib=new Library();
        Song s1=new Song("My Generation");
        s1.setLiked(true);
        Song s2=new Song("Whip it");
        lib.addSong(s1);
        lib.addSong(s2);
        System.out.printf("Finding My Generation: %s",lib.findSong("My Generation").getName());
        ArrayList<Song> liked=lib.getLiked();
        for(Song s:liked)
        {
            System.out.printf("%s\n",s.toString());
        }
    }
}
