import expression.Expression;
import expression.operators.*;

import java.util.HashMap;

/**
 * This comparator implementation compares between different levels of precedence between operators.
 */

public class PrecComparator implements java.util.Comparator<String> {

    private HashMap<String, Integer> precMap; ;

    public PrecComparator(){
        precMap=new HashMap<>();
        precMap.put("+",1);
        precMap.put("-",1);
        precMap.put("/",2);
        precMap.put("*",2);
        precMap.put("^",3);
    }
    public int compare(String o1, String o2) {
        return precMap.get(o1)-precMap.get(o2);
    }
}
