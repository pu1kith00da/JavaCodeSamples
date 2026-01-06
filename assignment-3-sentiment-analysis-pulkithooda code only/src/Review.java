import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Review
{
    protected String text;
    protected int score;

    /* you add constructors, getters and setters */
    public Review(String text, int score)
    {
        this.text = text;
        this.score = score;
    }
    public void setScore(int score)
    {
        this.score = score;
    }

    public int getScore()
    {
        return score;
    }

    public String getText()
    {
        return text;
    }

    public void setText(String text)
    {
        this.text = text;
    }
}













