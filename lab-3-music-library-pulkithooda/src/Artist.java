//Pulkit Hooda
import java.util.ArrayList;

public class Artist extends Entity {

    protected ArrayList<Song> songs;
    protected ArrayList<Album> albums;

    public Artist(String name)
    {
        super(name);
    }

    public void addAlbum(Album a)
    {
        albums.add(a);
    }

    public void addSong(Song s)
    {
        songs.add(s);

    }
    public  String toString()
    {
        return "Name: "+this.name+" ID: "+this.entityID;
    }
    public String toHTML()
    {
        return "<b>"+this.name+"</b><i>"+this.entityID+"</i>";

    }
    public String toXML()
    {
        return "<entity><name>"+this.name+"</name><id>"+this.entityID+"</id></entity> ";
    }
}
