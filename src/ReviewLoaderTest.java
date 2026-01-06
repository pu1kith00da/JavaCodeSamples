import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

/* you build this part */

class ReviewLoaderTest
{
    @Test
    void loadReviews()
    {

        String token="";
        char temp;
        int reviewRating=0;
        Scanner reviewScanner = null;
        try
        {
            reviewScanner = new Scanner(new File("movieReviews.txt"));
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File not found");
            System.exit(-1);
        }
        ArrayList<Review> printReviews=new ArrayList<Review>();
        while (reviewScanner.hasNextLine())
        {
            token=reviewScanner.nextLine();
            temp=token.charAt(0);
            reviewRating=Integer.parseInt(String.valueOf(temp));
            //https://www.geeksforgeeks.org/java-program-to-convert-char-to-int/#:~:text=In%20Java%2C%20we%20can%20convert,getNumericValue(char)%20method.
            //this link was used to help me write the code to isolate the rating at the begining and save it as an int
            System.out.println(reviewRating);

            token=token.substring(2);
            System.out.println(token);

            //the scores and the reviews are being printed as expected, so it works

            printReviews.add(new Review(token,reviewRating));
        }
        System.out.println(printReviews.get(0));
        //prints the reference to the review - also works
    }
}