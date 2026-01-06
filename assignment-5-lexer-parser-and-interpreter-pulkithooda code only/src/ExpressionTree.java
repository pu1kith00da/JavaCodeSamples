/*
    grammar:
    EXPR -> NUMBER
    EXPR -> IDENTIFIER
    EXPR -> EXPR OP EXPR
    ASSIGNMENT -> IDENTIFIER ASSIGNOP EXPR
    EXPRASSIGNMENT -> IDENTIFIER EXPRASSIGN EXPR
    OP -> + | - | * | /
    NUMBER -> INTEGER
    NUMBER -> FLOAT
    INTEGER -> [0-9]+
    FLOAT -> [0-9]+.[0-9]+
    IDENTIFIER -> [A-Za-z]+[A-Za-z0-9]*
    ASSIGNOP -> =
    EXPRASSIGN -> #


 */

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;


public class ExpressionTree
{
    Node root;
    static HashMap<String, Integer> precedence;
    static
    {
        precedence = new HashMap<>();
        precedence.put("+", 1);
        precedence.put("-", 1);
        precedence.put("*", 2);
        precedence.put("/", 2);
    }

    public ExpressionTree() {
        root = null;
    }

    public ExpressionTree(Token t, ExpressionTree leftTree, ExpressionTree rightTree)
    {
        this.root = new Node(t);
        this.root.left = leftTree.root;
        this.root.right = rightTree.root;
    }

    public ExpressionTree(Token t)
    {
        this.root = new Node(t);
        this.root.left = null;
        this.root.right = null;
    }

    public static class Node
    {
        String type;
        String val;
        Node left;
        Node right;

        Node()
        {
            type = "";
            val = "";
            left = null;
            right = null;
        }

        Node(Token t)
        {
            this.type = t.type;
            this.val = t.value;
        }

        public String toString() {
            return this.type + ":" + this.val;
        }


        /* evaluate an Expression tree via postorder traversal. */
        public double eval(SymbolTable table)
        {
            if (this.type==Lexer.INT||this.type==Lexer.FLOAT)
            {
                return Double.valueOf(this.val);
            }
            else if (this.type==Lexer.IDENTIFER)
            {
                if (table.hasValue(this.val))
                {
                    return table.getValue(this.val);
                }
                else if (table.hasFunction(this.val))
                {
                    return table.getFunction(this.val).evaluate(table);
                }
                else
                {
                    throw new IllegalArgumentException(this.val + " is not in the symbol table");
                }
            }
            else if (this.type==Lexer.OPERATOR)
            {
                /*
            https://www.geeksforgeeks.org/evaluation-of-expression-tree/
            used this link to help with the actual evaluation
             */
                double evalLeft = left.eval(table);
                double evalRight = right.eval(table);

                if (this.val.equals("+"))
                {
                    return evalRight+evalLeft;
                }
                if (this.val.equals("-"))
                {
                    return evalLeft-evalRight;
                }
                if (this.val.equals("*"))
                {
                    return evalRight*evalLeft;
                }
                else
                {
                    return evalLeft/evalRight;
                }
            }
            else
            {
                throw new IllegalArgumentException("Error");
            }
        }
    }

/*parse variable identifiers */
    public static Node parseIdentifier(Token t)
    {
        if (t == null)
        {
            return new Node();
        }
        else if (t.type.equals(Lexer.IDENTIFER))
        {
            return new Node(t);
        }
        else
        {
            throw new IllegalArgumentException("Parse error: " + t);
        }
    }

    /* parse = */
    public static Node parseAssignmentOp(Token t)
    {
        if (t == null)
        {
            return new Node();
        }
        else if (t.type.equals(Lexer.ASSIGNMENT))
        {
            return new Node(t);
        }
        else
        {
            throw new IllegalArgumentException("Parse error: " + t);
        }
    }

    /* parse +,-,*,/ */
    public static Node parseOperator(Token t)
    {
        if (t == null)
        {
            return new Node();
        }
        else if (t.type.equals(Lexer.OPERATOR))
        {
            return new Node(t);
        }
        else
        {
            throw new IllegalArgumentException("Parse error: " + t);
        }
    }

    /* parse the expr (#) operator */
    public static Node parseExprOperator(Token t)
    {
        if (t == null)
        {
            return new Node();
        }
        else if (t.type.equals(Lexer.EXPRASSIGNMENT))
        {
            return new Node(t);
        }
        else
        {
            throw new IllegalArgumentException("Parse error: " + t);
        }
    }

    /* parse a number  and return the appropriate node */

    public static Node parseNumber(Token t)
    {
        if (t == null)
        {
            return new Node();
        }
        else if (t.type.equals(Lexer.INT))
        {
            return new Node(t);
        }
        else if (t.type.equals(Lexer.FLOAT))
        {
            return new Node(t);
        }
        else
        {
            throw new IllegalArgumentException("Parse error: " + t);
        }
    }

    /* a helper method to tell which of two operators has precendence. */
    public static boolean hasPrecedence(String op1, String op2)
    {
        if (precedence.get(op1) > precedence.get(op2))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /* parseExpression. Use the shunting algorithm to parse the list of tokens into an expression tree. */

    public static Node parseExpression(List<Token> tokenList)
    {
        Stack operators=new Stack<>();
        Stack operands=new Stack<>();
        for(Token t: tokenList)
        {
            if(t.type.equals(Lexer.INT)||t.type.equals(Lexer.FLOAT)||t.type.equals(Lexer.IDENTIFER))
            {
                operands.push(new Node(t));
            }
            else if (t.type.equals(Lexer.OPERATOR))
            {
                //Token temp;
                //temp= (Token) operators.peek();
                if(operators.isEmpty()||hasPrecedence(t.type, ((Token)operators.peek()).type))
                {
                    operators.push(new Node(t));
                }
                else
                {
                    //should have error if there aren't a minimum of 2 operands in an expression
                    if(operands.size()<2)
                    {
                        throw new IllegalArgumentException("Not enough operands");
                    }

                    Node innerTree= (Node) operators.pop();
                    innerTree.right= (Node) operands.pop();
                    innerTree.left= (Node) operands.pop();
                    operands.push(innerTree);
                    operators.push(new Node(t));
                }
            }
            else
            {
                throw new IllegalArgumentException("unknown token");
            }
        }
        while (!operators.isEmpty())
        {
            if(operands.size()<2)
            {
                throw new IllegalArgumentException("Not enough operands");
            }
            Node n= (Node) operators.pop();
            n.right= (Node) operands.pop();
            n.left= (Node) operands.pop();
            operands.push(n);
        }
        return (Node) operands.pop();
    }


    /* parse an assignment statement - grab the variable and assignment operator, parse the expression on the right-hand side,
        evaluate it, and store the result in the symbol table.
     */
    public static Node parseAssignment(List<Token> tokenList, SymbolTable table)
    {
        if(tokenList.isEmpty()||tokenList.size()==1||tokenList.size()==2)
        {
            return null;
        }
        else
        {
            //get variable name
            Node var=parseIdentifier(tokenList.get(0));

            //get equals sign
            Node eq=parseAssignmentOp(tokenList.get(1));

            if (var==null||eq==null)
            {
                throw new IllegalArgumentException("parseAssignment error");
            }
            else
            {
                //get value to assign to variable(will be the expression after the equals sign)
                Node val=parseExpression(tokenList.subList(2, tokenList.size()));

                double answer= val.eval(table);
                table.storeValue(var.val,answer);
                return val;
            }
        }
    }

    /* Similar to parseAssignment, except that we're not going to evaluate the expression. Instead, store the expression tree
        in the symbol table.
     */

    public static Node parseExprAssignment(List<Token> tokenList, SymbolTable table)
    {
        if(tokenList.isEmpty()||tokenList.size()==1||tokenList.size()==2)
        {
            return null;
        }
        else
        {
            //get variable name
            Node var=parseIdentifier(tokenList.get(0));
            //get # sign
            Node exeq=parseExprOperator(tokenList.get(1));

            if (var==null||exeq==null)
            {
                throw new IllegalArgumentException("parseExprAssignment error");
            }
            else
            {
                //get value to assign to variable(will be the expression after the # sign)
                Node exp=parseExpression(tokenList.subList(2, tokenList.size()));

                ExpressionTree etree=new ExpressionTree();
                etree.root=exp;
                table.storeFunction(var.val,etree);
                return exp;
            }
        }
    }

    /* take a list of tokens, look ahead to see what we are parsing, and call the appropriate method */

    public static Node parseTokens(List<Token> tokenList, SymbolTable table)
    {
        Node n;
        //check parseNumber and parseIdentifier first
        if(tokenList.size()==1)
        {
            if(tokenList.get(0).type.equals(Lexer.INT)||tokenList.get(0).type.equals(Lexer.FLOAT))
            {
                n=parseNumber(tokenList.get(0));
            }
            else if (tokenList.get(0).type.equals(Lexer.IDENTIFER))
            {
                n=parseIdentifier(tokenList.get(0));
            }
            else
            {
                throw new IllegalArgumentException("wrong token");
            }
        }
        else if (tokenList.get(0).type.equals(Lexer.IDENTIFER)&&tokenList.get(1).type.equals(Lexer.ASSIGNMENT))
        {
            n=parseAssignment(tokenList,table);
        }
        else if (tokenList.get(0).type.equals(Lexer.IDENTIFER)&&tokenList.get(1).type.equals(Lexer.EXPRASSIGNMENT))
        {
            n=parseExprAssignment(tokenList,table);
        }
        else
        {
            n=parseExpression(tokenList);
        }
        if (n==null)
        {
            throw new IllegalArgumentException("parse error");
        }
        return n;
    }

    /* wrapper method for parseTokens */
    public void parse(List<Token> tokenList, SymbolTable table)
    {
        root = parseTokens(tokenList,table);
    }

    /* wrapper method for eval */
    public double evaluate(SymbolTable table)
    {
        return root.eval(table);
    }
}
