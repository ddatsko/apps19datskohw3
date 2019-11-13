package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyPredicate;

import java.util.Arrays;

// Tests every element and removes it if it doesn't satisfy MyPredicate
public class FilterDecorator extends SmartArrayDecorator {
    private Object[] array;

    public FilterDecorator(SmartArray smartArray, MyPredicate pr) {
        super(smartArray);
        array = Arrays.stream(smartArray.toArray()).filter(pr::test).toArray();
    }

    @Override
    public Object[] toArray() {
        return array.clone();
    }

    @Override
    public String operationDescription() {
        return "Filter Decorator. Filters objects depending on the predicate";
    }

    @Override
    public int size() {
        return array.length;
    }
}
