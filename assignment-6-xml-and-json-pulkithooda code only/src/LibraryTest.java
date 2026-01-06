import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTest
{
    Library test;

    @BeforeEach
    void setUp()
    {
         test=new Library();
    }


    @org.junit.jupiter.api.Test
    void readFromXML()
    {
        //make songs public for test methods to work
        test.readFromXML("src/music-library.xml");
        for(Song s: test.songs)
        {
            System.out.println(s.getName());
        }
    }

    @Test
    void readFromJSON()
    {
        //make songs public for test methods to work
        test.readFromJSON("src/music-library.json");
        for(Song s: test.songs)
        {
            System.out.println(s.getName());
        }
    }

    @Test
    void findDuplicates()
    {
        Song s1=new Song("Dior");
        Artist artist1=new Artist("Pop Smoke");
        Album album1=new Album("Meet The Woo");
        s1.setPerformer(artist1);
        s1.setAlbum(album1);

        Song s2=new Song("Dior");
        s2.setPerformer(artist1);
        s2.setAlbum(album1);

        //this correctly identifies the duplicate,will comment out code to test other cases
        /*test.addSong(s1);
        test.addSong(s2);*/

        Song s3=new Song("dior");
        s3.setPerformer(artist1);
        s3.setAlbum(album1);

        /*this correctly identifies a potential duplicate due to difference in upper/lowercase
        test.addSong(s1);
        test.addSong(s3);*/

        Song s4=new Song("Dior");
        s4.setPerformer(artist1);
        Album album2=new Album("Meet The Woo 2");
        s4.setAlbum(album2);

        /*this correctly identifies a possible duplicate
        test.addSong(s1);
        test.addSong(s4);*/

        Song s5=new Song("Reminder");
        Artist artist2=new Artist("The Weeknd");
        Album album3=new Album("Starboy");
        s5.setAlbum(album3);
        s5.setPerformer(artist2);

       /*this does not return the songs as duplicates
        test.addSong(s1);
        test.addSong(s5);*/

        test.findDuplicates();


    }
}