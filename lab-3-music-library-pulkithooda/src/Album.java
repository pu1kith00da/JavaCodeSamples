//Pulkit Hooda
import java.util.ArrayList;

public class Album extends Entity {
    protected ArrayList<Song> songs;
    protected Artist artist;

    public Album(String name)
    {
        super(name);
    }
    public Artist getArtist()
    {
        return artist;
    }

    public void setArtist(Artist artist)
    {
        this.artist = artist;
    }
    public void addSong(Song s)
    {
        songs.add(s);

    }
    public boolean equals(Album other)
    {
        return (this.name.equals(other.name)&&this.artist.equals(other.artist));
    }
    public  String toString()
    {
        return "Name: "+this.name+" Artist: "+this.artist+" ID: "+this.entityID;
    }
    public String toHTML()
    {
        return "<b>"+this.name+"</b>"+this.artist+"<i>"+this.entityID+"</i>";
    }
    public String toXML()
    {
        return "<entity><name>"+this.name+"</name><artist>"+this.artist+"</artist><id>"+this.entityID+"</id></entity> ";
    }
}
