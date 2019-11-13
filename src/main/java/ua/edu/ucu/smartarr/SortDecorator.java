package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyComparator;

import java.util.Arrays;

// Sorts elements using MyComparator to compare them
public class SortDecorator extends SmartArrayDecorator {
    private Object[] array;

    public SortDecorator(SmartArray smartArray, MyComparator cmp) {
        super(smartArray);
        array = Arrays.stream(this.smartArray.toArray()).sorted(cmp).toArray();
    }

    @Override
    public Object[] toArray() {
        return array.clone();
    }

    @Override
    public String operationDescription() {
        return "Sort Decorator. Sorts all the elements in the array";
    }

    @Override
    public int size() {
        return array.length;
    }
}
