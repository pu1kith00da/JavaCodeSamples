import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class BarChartRacer {
    protected BarChart chart;
    protected String fname;
    protected int nbars;

    /**
     * get the chart headings
     * for each chunk,
     */

    public BarChartRacer()
    {
        StdDraw.setCanvasSize(1000, 700);
        StdDraw.enableDoubleBuffering();
    }
    public BarChartRacer(String fname,int nbars)
    {
        this.fname = fname;
        this.nbars=nbars;
        StdDraw.setCanvasSize(1000, 700);
        StdDraw.enableDoubleBuffering();
    }



    public void drawChart(int ms)
    {
        Scanner fileScanner;
        Bar[] raceBars;

        try
        {
            fileScanner=new Scanner(new File(fname));
        }
        catch (FileNotFoundException e)
        {
            throw new RuntimeException(e);
        }

        processHeader(fileScanner);

        while (fileScanner.hasNext())
        {
            String caption;
            this.chart.reset();

            fileScanner.nextLine();

            raceBars=getNextBars(fileScanner);
            Arrays.sort(raceBars);

            /*
            adding a number in bars[#] is necessary but the number does not matter as long as it stays less than
            the number of lines per "read" so a lower number is better
             */
            caption=raceBars[0].getLabel();
            chart.setCaption(caption);

            /*
            Since Arrays.sort() orders from smallest to largest we want to read from the back
             */
            for(int i=raceBars.length-1;i>=(raceBars.length-nbars)&&i>=0;i--)
            {
                this.chart.add(raceBars[i].getName(),raceBars[i].getValue(),raceBars[i].getCategory());
            }

            StdDraw.clear();
            this.chart.draw();
            StdDraw.show();
            StdDraw.pause(ms);
        }
    }

    public void processHeader(Scanner input)
    {
        String title=input.nextLine();
        String xAxis=input.nextLine();
        String source=input.nextLine();
        this.chart = new BarChart(title,xAxis,source);
    }


    public Bar[] getNextBars(Scanner input)
    {

        int lines=input.nextInt();
        input.nextLine();

        //race cars but with statistics
        Bar[] raceBars=new Bar[lines];

        String[]info;

        for(int i=0;i<lines;i++)
        {
            /*
            https://stackoverflow.com/questions/3481828/how-do-i-split-a-string-in-java
            used this link to help write the code on how to split a string and how to read each indiviual part
            of the original string that was split
             */

            info=input.nextLine().split(",");
            raceBars[i]=new Bar(info[1],Math.max(Integer.parseInt(info[3]),1),info[4],info[0]);
        }
        return raceBars;
    }

    public static void main(String[] args)
    {

        Scanner userScanner = new Scanner(System.in);
        String filename;
        int ms;
        int nbars;

        System.out.println("What file would you like to see a barchart from?");
        filename=userScanner.nextLine();

        System.out.println("How many bars would you like to see");
        nbars=userScanner.nextInt();

        System.out.println("How many milliseconds would you like to pause(lower numbers means it goes faster");
        ms= userScanner.nextInt();

        BarChartRacer br = new BarChartRacer(filename,nbars);
        br.drawChart(ms);
    }


}
