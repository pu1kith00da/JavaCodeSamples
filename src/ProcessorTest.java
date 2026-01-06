import java.util.ArrayList;

//Pulkit Hooda
public class ProcessorTest
{
    public static void main(String[] args)
    {
        test();
    }
    public static void test()
    {
        Processor p=new Processor("hamtrain");

        //test isStopWord
        if((p.isStopWord("wouldn't"))&&(!p.isStopWord("cat")))
        {
            System.out.println("working");
        }
        else
        {
            System.out.println("not working");
        }

        //test isJunk
        if((p.isJunk("carrots"))&&(!p.isJunk("rth$@ju&ld34")))
        {
            System.out.println("working");
        }
        else
        {
            System.out.println("not working");
        }

        //test stripPunctuation
        String check1=p.stripPunctuation("test!");
        System.out.println(check1);
        String check2=p.stripPunctuation("doesn't!");
        System.out.println(check2);



        Predictor testpr=new Predictor();
        double testLogLikelihood;
        double checkValue;


        //Create test ArrayList and test Hashmap
        FreqDist testfd=new FreqDist();
        ArrayList<String> testWords = new ArrayList<String>();
        testWords.add("car");
        testWords.add("boat");
        testWords.add("plane");
        testWords.add("bicycle");
        testWords.add("car");
        testWords.add("helicopter");
        testWords.add("plane");
        testWords.add("car");
        testWords.add("spaceship");
        testWords.add("horse");

        //this will check if testLogLikelihood is working for the test ArrayList and hash map
        for(int i=0;i<testWords.size();i++)
        {
            testfd.add(testWords.get(i));
        }
        testLogLikelihood=testpr.computeLogLikelihood(testfd,testWords);

        // check to see if the frequency distribution is working,this should print 3
        System.out.println(testfd.get("car"));

        //checkValue should equal testLogLikelihood
        checkValue=(3*Math.log(3))+(2*Math.log(2))+(5*Math.log(1));
        System.out.println(testLogLikelihood);
        System.out.println(checkValue);
        if(testLogLikelihood==checkValue)
        {
            System.out.println("computeLogLikelihood works");
        }
    }
}
