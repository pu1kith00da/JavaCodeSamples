//Pulkit Hooda
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArtistTest {

    @Test
    void addAlbum()
    {
        Album a1=new Album("Revolver");
        Artist art1=new Artist("The Beatles");
        art1.addAlbum(a1);
        assertTrue(a1.songs.contains(a1));
    }
}