//Pulkit Hooda
import java.io.File;
import java.util.ArrayList;

/* Extend this to evaluate the fraction of spam and ham emails your classifier identifies correctly. */

public class TestManager {

    public static void main(String args[])
    {
        FreqDist spam = new FreqDist();
        FreqDist ham = new FreqDist();
        String filename;
        ArrayList<String> words;
        Processor p;
        Predictor pr = new Predictor();
        double spamval, hamval;

        /* read in 100 spam and store in a FreqDist. */
        File spamFolder = new File("spamtrain");
        String[] spamFiles = spamFolder.list();
        for (int i = 0; i < spamFiles.length; i++)
        {
            filename = spamFiles[i];
            p = new Processor("spamtrain/" + filename);
            words = p.parseFile();
            for (int j = 0; j < words.size(); j++)
            {
                spam.add(words.get(j));
            }
        }

        /* read in 100 ham and store in a FreqDist */

        File hamFolder = new File("hamtrain");
        String[] hamFiles = hamFolder.list();
        for (int i = 0; i < hamFiles.length; i++)
        {
            filename = hamFiles[i];
            p = new Processor("hamtrain/" + filename);
            words = p.parseFile();
            for (int j = 0; j < words.size(); j++)
            {
                ham.add(words.get(j));
            }
        }

        /* take 50 spam test emails, compute loglikelihood */

        File spamTestFolder = new File("spamtest");
        String[] spamTestFiles = spamTestFolder.list();
        int spamCorrect=0;
        for (int i = 0; i < spamTestFiles.length; i++)
        {
            filename = spamTestFiles[i];

            p = new Processor("spamtest/" + filename);
            words = p.parseFile();
            spamval = pr.computeLogLikelihood(spam, words);
            hamval = pr.computeLogLikelihood(ham, words);
            System.out.println(spamval + " " + hamval);
            if (spamval > hamval)
            {
                System.out.println("Correct");
                spamCorrect++;
            }
            else
            {
                System.out.println("Incorrect");
            }
        }

        /* take 50 ham test emails, compute loglikelihood */

        File hamTestFolder = new File("hamtest");
        String[] hamTestFiles = hamTestFolder.list();
        int hamCorrect=0;
        for (int i = 0; i < hamTestFiles.length; i++)
        {
            filename = hamTestFiles[i];
            p = new Processor("hamtest/" + filename);
            words = p.parseFile();
            spamval = pr.computeLogLikelihood(spam, words);
            hamval = pr.computeLogLikelihood(ham, words);
            System.out.println(spamval + " " + hamval);
            if (spamval < hamval)
            {
                System.out.println("Correct");
                hamCorrect++;
            }
            else
            {
                System.out.println("Incorrect");
            }

        }
        System.out.println("The total number of spam emails identified correctly are: "+spamCorrect+"/50 which is "+(spamCorrect*2)+"% correct");
        System.out.println("The total number of ham emails identified correctly are: "+hamCorrect+"/50 which is "+(hamCorrect*2)+"% correct");
        System.out.println("The total percentage of emails identified correctly is "+(spamCorrect+hamCorrect)+"%");

        /* you extend this to keep track of the number of correctly classified spam and ham, and display the totals
        * at the end. */

    }
}








