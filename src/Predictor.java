//Pulkit Hooda
import java.util.ArrayList;

public class Predictor
{
    /* you do this one. */
    public double computeLogLikelihood(FreqDist fd, ArrayList<String> wordsToScore)
    {
        double logLikelihood=0.0;
        for(int i=0;i<wordsToScore.size();i++)
        {
            logLikelihood=logLikelihood+Math.log(fd.get(wordsToScore.get(i)));
        }
        return logLikelihood;
    }



}
