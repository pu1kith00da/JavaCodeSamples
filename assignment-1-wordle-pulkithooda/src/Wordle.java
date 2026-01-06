//Pulkit Hooda

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Wordle {
    public static Scanner getFileHandle(String filename)
    {
        Scanner sc=null;
        try
        {
            sc=new Scanner(new File(filename));
        }catch (FileNotFoundException e)
        {
            System.out.println("File not found");
            System.exit(-1);
        }
        return sc;
        // you fill this in.
    }

    /* return a string representing the user's guess. If a letter is in the secret word, and it's in the right place,
        put a ! at that position. If a letter is in the secret word, but it's in the wrong place, put a 0. And if
        if's not present, put a X.
     */
    public static String compareWords(String secretWord, String guess)
    {
        String result = new String();
        final String ANSI_RESET="\u001B[40m";
        final String ANSI_RED_BACKGROUND="\u001B[41m";
        final String ANSI_GREEN_BACKGROUND="\u001B[42m";
        final String ANSI_YELLOW_BACKGROUND="\u001B[43m";
        for(int i=0;i<5;i++)
        {
            if (guess.charAt(i)==secretWord.charAt(i))
            {
                result=result+ANSI_GREEN_BACKGROUND+guess.charAt(i)+ANSI_RESET;
            }
            else if ((guess.charAt(i)!=secretWord.charAt(i)))
            {
                boolean xOr0 = true;
                for(int j=0;j<5;j++)
                {
                    if (guess.charAt(i) == secretWord.charAt(j))
                    {
                        xOr0=true;
                        break;
                    }
                    else if (guess.charAt(i) != secretWord.charAt(j))
                    {
                        xOr0=false;
                    }
                }
                if(xOr0==true)
                {
                    result=result+ANSI_YELLOW_BACKGROUND+guess.charAt(i)+ANSI_RESET;
                }
                else if (xOr0==false)
                {
                    result=result+ANSI_RED_BACKGROUND+guess.charAt(i)+ANSI_RESET;
                }
            }
        }
      // you do this part
        return result;
    }

    /* this method should call compareWords with multiple different inputs (same word,
    same letters but different position, completely different) to make aure it works.
    Return true if compareTwoWords does everything right, and false otherwise.
     */
    public static boolean testCompareWords()
    {
        String test1;
        String test2;
        String test3;
        test1=compareWords("rides","mount");
        System.out.println(test1);
        test2=compareWords("rides","rides");
        System.out.println(test2);
        test3=compareWords("rides","diver");
        System.out.println(test3);
        return true;
    }

    /*
    Select a random word from the file of legal words.
    Use the ArrayList to store the words, and then Random to
    select one.
     */
    public static String selectRandomWord(String wordfile)
    {
        String randomWord;
        int randomInt;
        Scanner scr=getFileHandle(wordfile);
        ArrayList<String> words = new ArrayList<String>();
        // used this link: https://stackoverflow.com/questions/5343689/java-reading-a-file-into-an-arraylist to help copy the file onto array list
        while(scr.hasNext())
        {
            words.add(scr.next());
        }
        Random chooseWord=new Random();
        randomInt = chooseWord.nextInt(words.size());
        randomWord= words.get(randomInt);
        scr.close();
        return randomWord;
      // you do this part.
    }

    /* testSelectRandomWord. This should call selectRandomWord and display the word
    that was selected.
     */

    public static String testSelectRandomWord() {
        String testWord;
        testWord=selectRandomWord("src/wordleWords");
        //testWord=selectRandomWord("src/notAFile");
            //this line of code is commented out since if it is left in the program will exit since file is not found
        return testWord;
    }

/*
Our primary method.
 */
    public static void playGame()
    {
        Scanner input=new Scanner(System.in);
        String gameGuess;
        String resultUpdate;
        String guessedLetters =new String();//change as needed
        String theWord=selectRandomWord("src/wordleWords");
        // Read a word from the file.
        int guessCounter=0;
        // set a counter for the number of guesses so far.
        // loop:
        while(guessCounter<=5)
        {
            // prompt the user for a word.
            System.out.println("Guess the word");
            gameGuess=input.nextLine();
            if(gameGuess.equalsIgnoreCase(theWord))
            {
                System.out.println("Correct! You win!");
                break;
            }
            else
            {
                // Display the result.
                resultUpdate=compareWords(theWord,gameGuess);
                System.out.println(resultUpdate);
            }
            for (int i=0;i<5;i++)
            {
                // Show the letters guessed so far
                guessedLetters = guessedLetters + " " + gameGuess.charAt(i);
            }
            System.out.println(guessedLetters);
            guessCounter++;
        }
        if(guessCounter==6)
        {
            System.out.println("Sorry you lost");
        }
    }

    public static void main(String args[])
    {
        String testSRW;
        System.out.println("Let's test if the method SelectRandomWord is working properly.");
        System.out.println("Note: This is most likely not the word you will have to guess for the game.");
        testSRW=testSelectRandomWord();
        System.out.println(testSRW);
        System.out.println("Let's test if the method CompareWords is working properly.");
        testCompareWords();
        System.out.println("Now let's play Wordle!");
        System.out.println("Green means the letter is in the right place.");
        System.out.println("Yellow means the letter is in the word but in the wrong place.");
        System.out.println("Red means that the letter is not in the word.");
        playGame();
    }
}



