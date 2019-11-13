package ua.edu.ucu;

import org.junit.Before;
import org.junit.Test;
import ua.edu.ucu.functions.MyComparator;
import ua.edu.ucu.functions.MyFunction;
import ua.edu.ucu.functions.MyPredicate;
import ua.edu.ucu.smartarr.*;

import static org.junit.Assert.*;

public class SmartArrayDecoratorsTest {
    private SmartArray smartArray;

    @Before
    public void setUp() {
        smartArray = new BaseArray(new Object[]{1, -1, 2, -2, 3, -3, 1, 2, 3});
    }

    @Test
    public void testBaseArray() {
        assertArrayEquals(smartArray.toArray(), new Object[]{1, -1, 2, -2, 3, -3, 1, 2, 3});
        assertEquals(smartArray.size(), 9);
        assertEquals(smartArray.operationDescription(), "No decorators are applied");
    }


    @Test
    public void testDistinctDecorator() {
        SmartArray newArray = new DistinctDecorator(smartArray);
        assertArrayEquals(newArray.toArray(), new Object[]{1, -1, 2, -2, 3, -3});
        assertEquals(newArray.size(), 6);
        String rightDescription = "Distinct Decorator. Remove all the same elements from the array";
        assertEquals(newArray.operationDescription(), rightDescription);
    }

    @Test
    public void testSortDecorator() {
        MyComparator myCmp = new MyComparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return (int) o1 - (int) o2;
            }
        };

        SmartArray newArray = new SortDecorator(smartArray, myCmp);
        assertArrayEquals(newArray.toArray(), new Object[]{-3, -2, -1, 1, 1, 2, 2, 3, 3});
        assertEquals(newArray.size(), 9);
        String rightDescription = "Sort Decorator. Sorts all the elements in the array";
        assertEquals(newArray.operationDescription(), rightDescription);
    }

    @Test
    public void testFilterDecorator() {
        MyPredicate even = new MyPredicate() {
            @Override
            public boolean test(Object t) {
                return (int) t % 2 == 0;
            }
        };
        SmartArray newArray = new FilterDecorator(smartArray, even);
        assertArrayEquals(newArray.toArray(), new Object[]{2, -2, 2});
        assertEquals(newArray.size(), 3);
        String rightDescription = "Filter Decorator. Filters objects depending on the predicate";
        assertEquals(newArray.operationDescription(), rightDescription);
    }

    @Test
    public void testMapDecorator() {
        MyFunction abs = new MyFunction() {
            @Override
            public Object apply(Object t) {
                return Math.abs((int) t);
            }
        };
        SmartArray newArray = new MapDecorator(smartArray, abs);
        assertArrayEquals(newArray.toArray(), new Object[]{1, 1, 2, 2, 3, 3, 1, 2, 3});
        assertEquals(newArray.size(), 9);
        String rightDescription = "Map decorator. Apply a specified function to each element";
        assertEquals(newArray.operationDescription(), rightDescription);
    }

}
