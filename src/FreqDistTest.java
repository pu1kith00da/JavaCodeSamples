import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FreqDistTest
{
    @Test
    void getAverageScore()
    {
        FreqDist testWordTable=new FreqDist();
        testWordTable.addWordEntry("snake",3);
        testWordTable.addWordEntry("snake",3);
        testWordTable.addWordEntry("snake",1);
        testWordTable.addWordEntry("snake",3);
        testWordTable.addWordEntry("snake",0);
        testWordTable.addWordEntry("snake",1);
        testWordTable.addWordEntry("snake",2);
        double testAverage=0.0;
        double testTotalScore=13;
        double testTotalAppearances=7;
        testAverage=testTotalScore/testTotalAppearances;
        assertTrue(testWordTable.getAverageScore("snake")==testAverage);
    }
}