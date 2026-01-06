import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Interpreter
{
    Lexer l;
    SymbolTable variables;


    public Interpreter()
    {
        l = new Lexer();
        variables = new SymbolTable();
    }

    /* a method that can launch an interactive interpreter.
        Read in a line, execute it, and print out the result.
        Also add a verbose option that prints out the input and symbol table.
     */
    public void runShell()
    {
        Scanner scanner=new Scanner(System.in);
        List<Token> tokenList;
        while(true)
        {
            System.out.println(">>");
            l.getInputFromString(scanner.nextLine());
            tokenList=l.getAllTokens();
            ExpressionTree ExTree=new ExpressionTree();
            ExTree.parse(tokenList,variables);
            System.out.println(ExTree.evaluate(variables));
        }
    }

    /* a method that can read a series of lines in from a file, execute each one,
    and print out the result.
        Also add a verbose option that prints out the input and symbol table.
     */

    public void executeFile(String filename)
    {
        Scanner fileScanner;
        List<Token> tokenList;
        try
        {
            fileScanner = new Scanner(new File(filename));
            while (fileScanner.hasNextLine())
            {
                l.getInputFromString(fileScanner.nextLine());
                tokenList=l.getAllTokens();
                ExpressionTree ExTree=new ExpressionTree();
                ExTree.parse(tokenList,variables);
                System.out.println(ExTree.evaluate(variables));
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File not found");
            System.exit(-1);
        }
    }
    public void verboseMode() {
        Scanner scanner = new Scanner(System.in);
        List<Token> tokenList;
        while (true) {
            System.out.println(">>");
            l.getInputFromString(scanner.nextLine());
            tokenList = l.getAllTokens();
            ExpressionTree ExTree = new ExpressionTree();
            ExTree.parse(tokenList, variables);
            System.out.println(variables.getSymTable());
            System.out.println(variables.getFunctionTable());
            System.out.println(ExTree.evaluate(variables));
        }
    }
        public static void main (String[] args)
        {
            Interpreter shell = new Interpreter();
            //shell.runShell();
            shell.verboseMode();
        }
}
