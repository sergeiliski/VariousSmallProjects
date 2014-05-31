package algorithms;

import com.vannevelj.algorithms.unionfind.QuickFind;
import com.vannevelj.algorithms.unionfind.QuickUnion;
import com.vannevelj.algorithms.unionfind.WeightedQuickUnion;
import com.vannevelj.algorithms.unionfind.WeightedQuickUnionWithPathCompression;
import static org.junit.Assert.*;
import org.junit.Test;

public class UnionFindTests {

    @Test
    public void QuickFind() {
        String[] cities = new String[]{"Ghent", "Antwerp", "Brussels", "Amsterdam", "London", "Berlin"};
        QuickFind alg = new QuickFind(cities);
        alg.connect("Ghent", "Antwerp");
        alg.connect("Antwerp", "Brussels");
        alg.connect("Brussels", "Berlin");

        assertTrue(alg.areConnected("Ghent", "Berlin"));
        assertFalse(alg.areConnected("Ghent", "London"));
    }

    @Test
    public void QuickUnion() {
        String[] cities = new String[]{"Ghent", "Antwerp", "Brussels", "Amsterdam", "London", "Berlin"};
        QuickUnion alg = new QuickUnion(cities);
        alg.connect("Ghent", "Antwerp");
        alg.connect("Antwerp", "Brussels");
        alg.connect("Brussels", "Berlin");

        assertTrue(alg.areConnected("Ghent", "Berlin"));
        assertFalse(alg.areConnected("Ghent", "London"));
    }

    @Test
    public void WeightedQuickUnion() {
        String[] cities = new String[]{"Ghent", "Antwerp", "Brussels", "Amsterdam", "London", "Berlin"};
        WeightedQuickUnion alg = new WeightedQuickUnion(cities);
        alg.connect("Ghent", "Antwerp");
        alg.connect("Antwerp", "Brussels");
        alg.connect("Brussels", "Berlin");

        assertTrue(alg.areConnected("Ghent", "Berlin"));
        assertFalse(alg.areConnected("Ghent", "London"));
    }

    @Test
    public void WeightedQuickUnionWithPathCompression() {
        String[] cities = new String[]{"Ghent", "Antwerp", "Brussels", "Amsterdam", "London", "Berlin"};
        WeightedQuickUnionWithPathCompression alg = new WeightedQuickUnionWithPathCompression(cities);
        alg.connect("Ghent", "Antwerp");
        alg.connect("Antwerp", "Brussels");
        alg.connect("Brussels", "Berlin");

        assertTrue(alg.areConnected("Ghent", "Berlin"));
        assertFalse(alg.areConnected("Ghent", "London"));
    }  
}

