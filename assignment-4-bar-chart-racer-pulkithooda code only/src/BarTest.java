import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BarTest
{

    Bar b1;
    Bar b2;

    @BeforeEach
    void setUp()
    {
        b1=new Bar("name",5,"cat","label");
        b2=new Bar("name",27,"cat","label");

    }

    @org.junit.jupiter.api.Test
    void compareTo()
    {
        assertTrue(b1.compareTo(b2)<0);
    }
}
