import org.junit.jupiter.api.BeforeEach;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class LexerTest {

    Lexer l;
    String buffer;
    @BeforeEach
    void setUp()
    {
        l=new Lexer();
    }

    @org.junit.jupiter.api.Test
    void getNextToken() {
    }

    @org.junit.jupiter.api.Test
    void getAssignmentOperator() {
    }

    @org.junit.jupiter.api.Test
    void getOperator() {
    }

    @org.junit.jupiter.api.Test
    void getIdentifier() {
    }

    @org.junit.jupiter.api.Test
    void getNumber() {
    }


    //if getAllTokens works the rest of the functions also work
    @org.junit.jupiter.api.Test
    void getAllTokens()
    {
        l.buffer="a123#      1*   12";
        List<Token> tokenList=l.getAllTokens();
        for(Token token:tokenList)
        {
            System.out.println(token);
        }
    }
}