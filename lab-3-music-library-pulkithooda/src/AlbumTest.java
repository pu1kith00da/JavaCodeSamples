//Pulkit Hooda
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class AlbumTest {

    Album album1,album2;
    Artist a1;

    @BeforeAll
    static void startSetup()
    {

    }

    @BeforeEach
    void setUp()
    {
        album1=new Album("The White ALbum");
        album2=new Album("Revolver");
        a1=new Artist("The Beatles");
        album1.setArtist(a1);
        album2.setArtist(a1);


    }

    @AfterEach

    @AfterAll


    @Test
    void testEquals()
    {

        assertTrue(!album1.equals(album2));
        assertFalse(album2.equals(album1));
    }

    @Test
    void testToString()
    {

    }
}