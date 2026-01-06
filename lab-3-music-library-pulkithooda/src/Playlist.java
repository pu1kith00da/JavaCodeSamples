//Pulkit Hooda
import java.util.ArrayList;
public class Playlist
{
    private ArrayList<Song> songlist;
    public Playlist()
    {
        songlist=new ArrayList<Song>();
    }
    public void addSong(Song s)
    {
        songlist.add(s);
    }
    public void deleteSong(Song s)
    {
        if(songlist.contains(s))
        {
            songlist.remove(s);
        }
        else
        {
            System.out.printf("%s is not in the playlist\n",s.toString());
        }
    }
}
