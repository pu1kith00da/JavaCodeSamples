//Pulkit Hooda
import java.util.ArrayList;

public class Song extends Entity {
    protected Album album;
    protected Artist artist;
    protected SongInterval interval;
    protected String genre;
    protected boolean liked;

    public boolean isLiked()
    {
        return liked;
    }

    public void setLiked(boolean liked)
    {
        this.liked = liked;
    }

    public Song(String name)
    {
        super(name);
    }

    public String getGenre()
    {
        return genre;
    }

    public void setGenre(String genre)
    {
        this.genre = genre;
    }

    public void setLength(int length)
   {
        interval=new SongInterval(length);
   }
   public SongInterval getInterval()
   {
       return interval;
   }


    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public Artist getArtist()
    {
        return artist;
    }

    public void setArtist(Artist artist)
    {
        this.artist = artist;
    }


    public boolean equals(Song other)
    {
        return (this.name.equals(other.name)&&this.artist.equals(other.artist)&&this.album.equals(other.album));
    }
    public  String toString()
    {
        return "Name: "+this.name+" Artist: "+this.artist+" Album: "+this.album+" ID: "+this.entityID;
    }
    public String toHTML()
    {
        return "<b>"+this.name+"</b>"+this.artist+this.album+"<i>"+this.entityID+"</i>";
    }
    public String toXML()
    {
        return "<entity><name>"+this.name+"</name><artist>"+this.artist+"</artist><album>"+this.album+"</album><id>"+this.entityID+"</id></entity> ";
    }
}
