import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class AnalyzerTest
{

    Analyzer a;
    FreqDist fd;
    ArrayList<Review> sampleReviews;



    @BeforeEach
    void setUp()
    {
        a = new Analyzer();
        fd = new FreqDist();
        sampleReviews = new ArrayList<Review>();

    }

    @Test
    void train() {

        ArrayList<Review> sampleReviews = new ArrayList<Review>();

        Review r0 = new Review("This movie is absolute garbage and a complete waste of time , I would rather have burnt that money .", 0);
        Review r1 = new Review("I did not like this movie it would be more entertaining to watch paint dry .", 1);
        Review r2 = new Review("A very simple and unremarkable movie that does the bare minimum to keep the audience engaged , not much to hate but not much to like either .", 2);
        Review r3 = new Review("An entertaining movie from start to finish , a fun experience overall , well worth the money .", 3);
        Review r4 = new Review("This is an exceptional movie and masterpiece all around . Superb acting , an engaging and interesting plot , and just beautiful .", 4);

        sampleReviews.add(r0);
        sampleReviews.add(r1);
        sampleReviews.add(r2);
        sampleReviews.add(r3);
        sampleReviews.add(r4);

        Review r;
        FreqDist fd = new FreqDist();
        String sentence;
        int score;

        for (int i = 0; i < sampleReviews.size(); i++) {
            r = sampleReviews.get(i);//get the review from the array list
            sentence = r.getText();//get the text of the review
            score = r.getScore();//get the score for the review which will be assigned to each word
            String[] reviewArray = sentence.split("\\s+");
            // used this link to split the sentence: https://www.geeksforgeeks.org/count-words-in-a-given-string/
            //this will take each word in the sentence and store it in an array
            for (int j = 0; j < reviewArray.length; j++) {
                fd.addWordEntry(reviewArray[j], score);
            }
        }

        a.train(sampleReviews);

        //by checking the average score we can determine if the words are being counted and scored properl
        assertTrue(fd.getAverageScore("movie") == 2.0);//expect 2.0
        assertTrue(fd.getAverageScore("money") == 1.5);//expect 1.5
        assertTrue(fd.getAverageScore("garbage") == 0.0);//expect 0.0
        assertTrue(fd.getAverageScore("and") == 2.8);//expect 2.8
        assertTrue(fd.getAverageScore("like") == 1.5);//expect 1.5
    }

    @Test
    void test1()
    {
        ArrayList<Review> sampleReviews = new ArrayList<Review>();

        Review r0=new Review("This movie is absolute garbage and a complete waste of time , I would rather have burnt that money .",0);
        Review r1=new Review("I did not like this movie it would be more entertaining to watch paint dry .",1);
        Review r2=new Review("A very simple and unremarkable movie that does the bare minimum to keep the audience engaged , not much to hate but not much to like either .",2);
        Review r3=new Review("An entertaining movie from start to finish , a fun experience overall , well worth the money .",3);
        Review r4=new Review("This is an exceptional movie and masterpiece all around . Superb acting , an engaging and interesting plot , and just beautiful .",4);

        //Review r0 = new Review("complete garbage", 0);
        //Review r1 = new Review("hated it", 1);
        //Review r2 = new Review("average at best", 2);
        //Review r3 = new Review("fun and enjoyable", 3);
        //Review r4 = new Review("an exceptional masterpiece", 4);

        /*I created 2 sets of reviews: one in which some reviews share common words to check the rounding
        and the second set has no words shared to make sure that the words are being scored properly
        Both sets of reviews work as intended so the code is functional
         */

        sampleReviews.add(r0);
        sampleReviews.add(r1);
        sampleReviews.add(r2);
        sampleReviews.add(r3);
        sampleReviews.add(r4);

        Review r;
        FreqDist fd = new FreqDist();
        String sentence;
        int score;

        a.train(sampleReviews);
        a.test(sampleReviews);

        //check if output is what is expected

    }

    @Test
    void learn()
    {

    }



    /* put your tests here */
}
