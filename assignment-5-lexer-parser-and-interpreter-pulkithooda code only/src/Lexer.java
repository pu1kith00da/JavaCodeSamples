import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Lexer {

    public static final String INT="INT";
    public static final String FLOAT="FLOAT";
    public static final String IDENTIFER="ID";
    public static final String OPERATOR="OP";
    public static final String ASSIGNMENT="ASSIGN";
    public static final String EXPRASSIGNMENT="EXPR";
    public String buffer;


    public Lexer(String fileName) {

    }

    public Lexer() {
        buffer = "";
    }


    public void getInputFromFile(String fileName)  {

    }

    /**
     * Allows the user to provide a string as input.
     * You'll use this in the interpreter. It's also helpful for debugging.
     * @param s the String to be provided as input.
     */
    public void getInputFromString(String s) {
        buffer = s;
    }

    /**
     *  scan ahead in the string to the end of the current token.
        ref is the current pointer in the string.
     */
    public Token getNextToken(int ref)
    {
        if(Character.isLetter(buffer.charAt(ref)))
        {
             return getIdentifier(ref);
        }
        else if (buffer.charAt(ref)=='='||buffer.charAt(ref)=='#')
        {
            return getAssignmentOperator(ref);
        }
        else if (buffer.charAt(ref)=='+'||buffer.charAt(ref)=='-'||buffer.charAt(ref)=='*'||buffer.charAt(ref)=='/')
        {
            return getOperator(ref);
        }
        else if (Character.isDigit(buffer.charAt(ref)))
        {
            return getNumber(ref);
        }

        return null;

    }

    public Token getAssignmentOperator(int ref)
    {
        if(buffer.charAt(ref)=='=')
        {
            return new Token(ASSIGNMENT,buffer.substring(ref,ref+1));
        }
        else if (buffer.charAt(ref)=='#')
        {
            return new Token(EXPRASSIGNMENT,buffer.substring(ref,ref+1));
        }
        else
        {
            throw new IllegalArgumentException("Lexical error: " + buffer.charAt(ref));
        }
    }



    public Token getOperator(int ref)
    {
        if (buffer.charAt(ref)=='+'||buffer.charAt(ref)=='-'||buffer.charAt(ref)=='*'||buffer.charAt(ref)=='/')
        {
            return new Token(OPERATOR, buffer.substring(ref, ref+1));
        }
        else
        {
            throw new IllegalArgumentException("Lexical error: " + buffer.charAt(ref));
        }
    }

    public Token getIdentifier(int ref)
    {
        int ptr=ref;
        if(Character.isLetter(buffer.charAt(ptr)))
        {
            while (ptr<buffer.length()&&(Character.isLetter(buffer.charAt(ptr))||Character.isDigit(buffer.charAt(ptr))))
            {
                ptr++;
            }
            return new Token(IDENTIFER,buffer.substring(ref,ptr));
        }
        else
        {
            throw new IllegalArgumentException("Lexical error: " + buffer.charAt(ptr));
        }
    }

    public Token getNumber(int ref)
    {
        int ptr = ref;
        boolean isFloat = false;
        while (ptr < buffer.length() && (Character.isDigit(buffer.charAt(ptr)) || buffer.charAt(ptr) == '.'))
        {
            if (buffer.charAt(ptr) == '.')
            {
                isFloat = true;
            }
            ptr++;
        }
        if (isFloat)
        {
            return new Token(FLOAT, buffer.substring(ref, ptr));
        }
        else
        {
            return new Token(INT, buffer.substring(ref, ptr));
        }
    }


    /* iterate through the buffer and return a list of tokens. */
    public List<Token> getAllTokens()
    {
        //by placing the ref value inside getAllTokens it will be able to reset to 0 when a new buffer is input
        int ref = 0;
        List<Token> allTokens=new ArrayList<>();
        while(ref<buffer.length())
        {
            if(Character.isWhitespace(buffer.charAt(ref)))
            {
                ref++;
            }
            else
            {
                Token token=getNextToken(ref);
                //this will advance ref to the next token properly by taking the length of the token just input
                ref=ref+token.length();
                allTokens.add(token);
            }
        }
        return allTokens;
    }
}



