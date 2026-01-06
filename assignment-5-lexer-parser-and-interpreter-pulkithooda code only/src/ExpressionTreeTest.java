import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class ExpressionTreeTest
{
    ExpressionTree et;
    Lexer l;

    List<Token> tokenList;

    String buffer;

    SymbolTable table;

    @BeforeEach
    void setUp()
    {
        et = new ExpressionTree();
        l = new Lexer();
        table=new SymbolTable();
        l.buffer = "1+1";
        tokenList=l.getAllTokens();
    }

    @Test
    void eval()
    {
        et.parse(tokenList,table);
        System.out.println(et.evaluate(table));
        //prints 2  - good

    }
    @Test
    void parseIdentifier()
    {
        Token t=new Token("ID","a123");
        System.out.println(et.parseIdentifier(t));
        //prints properly-good
    }

    @Test
    void parseAssignmentOp()
    {
        Token t=new Token("ASSIGN","=") ;
        System.out.println(et.parseAssignmentOp(t));
        //prints properly-good
    }

    @Test
    void parseOperator()
    {
        Token t=new Token("OP","+");
        System.out.println(et.parseOperator(t));
        //prints properly-good
    }

    @Test
    void parseExprOperator()
    {
        Token t=new Token("EXPR","#");
        System.out.println(et.parseExprOperator(t));
        //prints properly-good
    }

    @Test
    void parseNumber()
    {
        Token t=new Token("INT","69");
        System.out.println(et.parseNumber(t));
        //prints properly-good
    }

    @Test
    void hasPrecedence()
    {
        //given
    }

    @Test
    void parseExpression()
    {
        List<Token> tokenList1=new ArrayList<>();
        Token t1=new Token("INT","1");
        Token t2=new Token("OP","+");
        Token t3=new Token("INT","2");
        tokenList1.add(t1);
        tokenList1.add(t2);
        tokenList1.add(t3);
        ExpressionTree.Node et1=ExpressionTree.parseExpression(tokenList1);
        System.out.print(et1.left);
        System.out.print(et1);
        System.out.print(et1.right);
        //prints in correct order- works



    }

    @Test
    void parseAssignment()
    {

    }

    @Test
    void parseExprAssignment() {
    }

    @Test
    void parseTokens() {
    }

    @Test
    void parse() {
    }

    @Test
    void evaluate() {
    }
}