import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class Analyzer
{
    public static final String[] stopwords = {"i", "me", "my", "myself", "we", "our", "ours", "ourselves", "you", "you're",
            "you've", "you'll", "you'd", "your", "yours", "yourself", "yourselves", "he", "him", "his", "himself", "she",
            "she's", "her", "hers", "herself", "it", "it's", "its", "itself", "they", "them", "their", "theirs",
            "themselves", "what", "which", "who", "whom", "this", "that", "that'll", "these", "those", "am", "is", "are",
            "was", "were", "be", "been", "being", "have", "has", "had", "having", "do", "does", "did", "doing",
            "a", "an", "the", "and", "but", "if", "or", "because", "as", "until", "while", "of", "at", "by", "for",
            "with", "about", "against", "between", "into", "through", "during", "before", "after", "above", "below", "to",
            "from", "up", "down", "in", "out", "on", "off", "over", "under", "again", "further", "then", "once", "here",
            "there", "when", "where", "why", "how", "all", "any", "both", "each", "few", "more", "most", "other", "some",
            "such", "no", "nor", "not", "only", "own", "same", "so", "than", "too", "very", "can", "will", "just", "don't",
            "should", "should've", "now", "aren't", "couldn't", "didn't", "doesn't",  "hasn't", "haven't", "isn't", "shouldn't",
            "wasn't", "weren't", "won't", "wouldn't",".",",","?","!","-",":",};

    protected FreqDist fd;
    protected Review r;

    public Analyzer()
    {
        this.fd = new FreqDist();
    }
    public static void main(String[] args)
    {
        learn();
    }

    public boolean isStopWord(String word)
    {
        boolean isItAstopWord=false;
        for(int i=0;i< stopwords.length;i++)
        {
            if(word.equals(stopwords[i]))
            {
                isItAstopWord=true;
            }
        }
        return isItAstopWord;
    }
    public String stripPunctuation (String w)
    {
        //this line should remove the trailing punctuation
        //code to help assist in this problem found on: https://stackoverflow.com/questions/33308203/remove-all-punctuation-from-the-end-of-a-string
        w=w.replaceAll("\\s*\\p{Punct}+\\s*$", "");
        return w;
    }
    public boolean isJunk(String word)
    {
        boolean itIsNotJunk=word.matches("[a-zA-Z]+");
        return itIsNotJunk;
    }
    public void train(ArrayList<Review> testReviews)
    {
        String sentence;
        int score;

        for(int i=0;i<testReviews.size();i++)
        {
            r=testReviews.get(i);//get the review from the array list
            sentence=r.getText();//get the text of the review
            score=r.getScore();//get the score for the review which will be assigned to each word
            String[] reviewArray=sentence.split("\\s+");
            // used this link to split the sentence: https://www.geeksforgeeks.org/count-words-in-a-given-string/
            //this will take each word in the sentence and store it in an array
            boolean checkForStopWords;
            boolean checkIfJunk;

            for(int j=0;j<reviewArray.length;j++)
            {
                checkForStopWords=isStopWord(reviewArray[j]);
                if(checkForStopWords==false)
                {
                    checkIfJunk=isJunk(reviewArray[j]);
                    if (checkIfJunk==true)
                    {
                        fd.addWordEntry(reviewArray[j],score);
                    }
                }
            }
        }
    }

    public void test(ArrayList<Review> testReviews)
    {
        String sentence;
        int score;
        double totalAverageDecimalDifference=0.0;
        double singleAverageDecimalDifference;
        int totalAverageIntegerDifference=0;
        int singleAverageIntegerDifference;

        for(int i=0;i<testReviews.size();i++)
        {
            r = testReviews.get(i);//get the review from the array list
            sentence = r.getText();//get the text of the review
            score = r.getScore();//get the score for the review which will be assigned to each word
            String[] reviewArray = sentence.split("\\s+");
            // used this link to split the sentence: https://www.geeksforgeeks.org/count-words-in-a-given-string/
            //this will take each word in the sentence and store it in an array
            double totalReviewScore=0.0;

            for(int j=0;j<reviewArray.length;j++)
            {
                totalReviewScore=totalReviewScore+fd.getAverageScore(reviewArray[j]);
            }

            double uneditedPredictedReviewScore=totalReviewScore/reviewArray.length;
            singleAverageDecimalDifference=Math.abs((uneditedPredictedReviewScore-score));
            totalAverageDecimalDifference=totalAverageIntegerDifference+singleAverageDecimalDifference;

            int predictedReviewScore= (int) Math.round(uneditedPredictedReviewScore);
            singleAverageIntegerDifference=Math.abs((predictedReviewScore-score));
            totalAverageIntegerDifference=totalAverageIntegerDifference+singleAverageIntegerDifference;

            //System.out.println("The unrounded review score is "+uneditedPredictedReviewScore);
            //System.out.println("The predicted review score for this review is "+predictedReviewScore);
            //these commented out lines of code would show each reviews unrounded and rounded predicted scores
            //these 2 lines of code are removed for better readability of the output

        }
        totalAverageDecimalDifference=totalAverageDecimalDifference/testReviews.size();
        totalAverageIntegerDifference=totalAverageIntegerDifference/testReviews.size();

        System.out.println("The average distance between the predicted value and the actual value is: "+totalAverageDecimalDifference);
        System.out.println("The average distance between the predicted classification and the actual classification is: "+totalAverageIntegerDifference);

        fd.clear();
    }

    public static void learn()
    {
        ArrayList<Review> learnList=new ArrayList<Review>();
        ReviewLoader rl=new ReviewLoader("movieReviews.txt");
        Analyzer a=new Analyzer();
        learnList=rl.loadReviews();

        ArrayList<Review> t0=new ArrayList<Review>(learnList.subList(0,1705));
        ArrayList<Review> t1=new ArrayList<Review>( learnList.subList(1706,3411));
        ArrayList<Review> t2=new ArrayList<Review>(learnList.subList(3412,5117));
        ArrayList<Review> t3=new ArrayList<Review>(learnList.subList(5118,6822));
        ArrayList<Review> t4=new ArrayList<Review>(learnList.subList(6823,8528));

        ArrayList<Review> trainingSet=new ArrayList<Review>();
        ArrayList<Review> testingSet=new ArrayList<Review>();

        ArrayList<ArrayList<Review>> arrayListOfAllSublist=new ArrayList<ArrayList<Review>>();
        //https://www.geeksforgeeks.org/arraylist-of-arraylist-in-java/
        //this site was used to see if an array list of array lists is even possible and how to go about it

        arrayListOfAllSublist.add(t0);
        arrayListOfAllSublist.add(t1);
        arrayListOfAllSublist.add(t2);
        arrayListOfAllSublist.add(t3);
        arrayListOfAllSublist.add(t4);


        for(int i=0;i<arrayListOfAllSublist.size();i++)
        {
            testingSet.addAll(arrayListOfAllSublist.get(i));

            for(int j=0;j<arrayListOfAllSublist.size();j++)
            {
                if(j!=i)
                {
                    trainingSet.addAll(arrayListOfAllSublist.get(j));
                }
            }

            a.train(trainingSet);
            a.test(testingSet);
            trainingSet.clear();
            testingSet.clear();
        }
    }
}
