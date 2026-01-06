import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlaylistTest
{
    Playlist p;
    Playlist p1;
    Playlist playlist;

    Playlist play;
    @BeforeEach
    void setUp()
    {
        p=new Playlist();
        p1=new Playlist();
        playlist=new Playlist();
        play=new Playlist();

    }

    @Test
    void addSong()
    {
        Song s1=new Song("Dior");
        play.addSong(s1);
        //make songlist in Playlist.java public to get output
        for(Song s:p.songlist)
        {
            System.out.println(s.getName());
        }

    }

    @Test
    void deleteSong()
    {
        Song s1=new Song("Dior");
        Song s2=new Song("Element");

        play.addSong(s1);
        play.addSong(s2);
        for(Song s:play.songlist)
        {
            System.out.println(s.getName());
        }

        play.deleteSong(s2);
        for(Song s:play.songlist)
        {
            System.out.println(s.getName());
        }

    }

    @Test
    Playlist mergePlaylists(Playlist p,Playlist p1)
    {
        //this was tested in the main method in Playlist.java as it was not executing in junit
        //this code method worked correctly in main

        Song s1=new Song("Dior");
        Song s2=new Song("Element");
        Song s3=new Song("Armed N Dangerous");
        Song s4=new Song("Get Back");
        Song s5=new Song("Mood Swings");
        Song s6=new Song("For the Night");

        p.addSong(s1);
        p.addSong(s2);
        p.addSong(s3);
        p.addSong(s4);

        p1.addSong(s4);
        p1.addSong(s5);
        p1.addSong(s6);


        System.out.println("Playlist 1:");
        for(Song s: p.songlist)
        {
            System.out.println(s.getName());
        }

        System.out.println("Playlist 2:");
        for(Song s: p1.songlist)
        {
            System.out.println(s.getName());
        }

        playlist=mergePlaylists(p,p1);
        System.out.println("Merged playlist");
        for(Song s:playlist.songlist)
        {
            System.out.println(s.getName());
        }

        return playlist;
    }

    @Test
    Playlist sortByMostLiked(Playlist p)
    {
        //this was tested in the main method in Playlist.java as it was not executing in junit
        //this code method worked correctly in main

        Song s1=new Song("Dior");
        Song s2=new Song("Element");
        Song s3=new Song("Armed N Dangerous");
        Song s4=new Song("Get Back");
        Song s5=new Song("Mood Swings");
        Song s6=new Song("For the Night");

        s1.setLikes(420);
        s2.setLikes(333);
        s3.setLikes(300);
        s4.setLikes(350);
        s5.setLikes(400);
        s6.setLikes(275);

        p.addSong(s1);
        p.addSong(s2);
        p.addSong(s3);
        p.addSong(s4);
        p.addSong(s5);
        p.addSong(s6);

        System.out.println("List order before sorting for likes");
        for(Song s:p.songlist)
        {
            System.out.println(s.getName());
        }

        System.out.println("List order after sorting likes");
        //playlist=sortByMostLiked(p);
        for(Song s:playlist.songlist)
        {
            System.out.println(s.getName());
        }
        return playlist;
    }

    @Test
    Playlist shufflePlaylist(Playlist play)
    {
        //this was tested in the main method in Playlist.java as it was not executing in junit
        //this code method worked correctly in main

        Song s1=new Song("Dior");
        Song s2=new Song("Element");
        Song s3=new Song("Armed N Dangerous");
        Song s4=new Song("Get Back");
        Song s5=new Song("Mood Swings");
        Song s6=new Song("For the Night");

        p.addSong(s1);
        p.addSong(s2);
        p.addSong(s3);
        p.addSong(s4);
        p.addSong(s5);
        p.addSong(s6);

        System.out.println("Song list before shuffle:");
        for(Song s:p.songlist)
        {
            System.out.println(s.getName());
        }

        //playlist=shufflePlaylist(p);
        System.out.println("Song list after shuffle:");
        for(Song s:playlist.songlist)
        {
            System.out.println(s.getName());
        }
        return playlist;
    }

    @Test
    void generateRandomPlaylist()
    {
        //this was tested in the main method in Playlist.java as it was not executing in junit
        //this code method worked correctly in main

        Playlist p=new Playlist();
        Playlist p1=new Playlist();
        Playlist playlist=new Playlist();
        Library library=new Library();

        Song s1=new Song("Dior");
        Song s2=new Song("Element");
        Song s3=new Song("Something Special");
        Song s4=new Song("Get Back");
        Song s5=new Song("Mood Swings");
        Song s6=new Song("For the Night");

        s1.setMood("Hype");
        s2.setMood("Hype");
        s3.setMood("Chill");
        s4.setMood("Hype");
        s5.setMood("Chill");
        s6.setMood("Chill");

        library.addSong(s1);
        library.addSong(s2);
        library.addSong(s3);
        library.addSong(s4);
        library.addSong(s5);
        library.addSong(s6);

        //playlist=generateRandomPlaylist("Hype",2,library);

        System.out.println("Randomly generated playlist:");
        for(Song s:playlist.songlist)
        {
            System.out.println(s.getName());
        }

    }
}