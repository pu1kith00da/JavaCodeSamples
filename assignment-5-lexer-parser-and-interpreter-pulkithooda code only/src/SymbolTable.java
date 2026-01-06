import java.util.HashMap;
import java.util.Map;

public class SymbolTable {

    Map<String, Double> symTable;
    Map<String, ExpressionTree> functionTable;


    /* you add constructors and setters/getters. */
    public SymbolTable()
    {
        this.symTable = new HashMap<String,Double>();
        this.functionTable = new HashMap<String,ExpressionTree>();
    }

    public SymbolTable(Map<String, Double> symTable, Map<String, ExpressionTree> functionTable)
    {
        this.symTable = new HashMap<String,Double>();
        this.functionTable = new HashMap<String,ExpressionTree>();
    }

    public Map<String, Double> getSymTable()
    {
        return symTable;
    }

    public void setSymTable(Map<String, Double> symTable)
    {
        this.symTable = symTable;
    }

    public Map<String, ExpressionTree> getFunctionTable()
    {
        return functionTable;
    }

    public void setFunctionTable(Map<String, ExpressionTree> functionTable)
    {
        this.functionTable = functionTable;
    }

    public boolean hasValue(String key) {return symTable.containsKey(key);}

    public Double getValue(String key){return symTable.get(key);}

    public void storeValue(String key,Double value){symTable.put(key,value);}

    public ExpressionTree getFunction(String key){return functionTable.get(key);}

    public boolean hasFunction(String key){return functionTable.containsKey(key);}

    public void storeFunction(String key,ExpressionTree value){functionTable.put(key,value);}





}
