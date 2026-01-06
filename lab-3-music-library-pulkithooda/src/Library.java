//Pulkit Hooda
import java.util.ArrayList;

public class Library
{
    private ArrayList<Song> songs=new ArrayList<Song>();
    public Library()
    {
        songs=new ArrayList<Song>();
    }
    public void addSong(Song s)
    {
        songs.add(s);
    }
    public Song findSong(String n)
    {
        for(int i=0;i<songs.size();i++)
        {
            if(songs.get(i).getName().equals(n))
            {
                return songs.get(i);
            }
        }
        return null;
    }
    public ArrayList<Song> getLiked()
    {
        ArrayList<Song> likedSongs=new ArrayList<Song>();
        for(int i=0;i<songs.size();i++)
        {
            if(songs.get(i).isLiked())
            {
                likedSongs.add(songs.get(i));
            }
        }
        return likedSongs;
    }
}
