import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReviewLoader
{
    protected String filename;

    public ReviewLoader(String filename)
    {
        this.filename = filename;
    }

    /* you write this method. */
    public ArrayList<Review> loadReviews()
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
        ArrayList<Review> reviews = new ArrayList<Review>();
        while (reviewScanner.hasNextLine())
        {
            token=reviewScanner.nextLine();
            temp=token.charAt(0);
            reviewRating=Integer.parseInt(String.valueOf(temp));
            //https://www.geeksforgeeks.org/java-program-to-convert-char-to-int/#:~:text=In%20Java%2C%20we%20can%20convert,getNumericValue(char)%20method.
            //this link was used to help me write the code to isolate the rating at the beginning and save it as an int

            token=token.substring(2);
            //this will save the entire review without the rating as a string to put in reviews.

            reviews.add(new Review(token,reviewRating));
        }
        return reviews;
    }
}
