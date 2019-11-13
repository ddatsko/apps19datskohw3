package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyFunction;

import java.util.Arrays;

// Map every element to another object using MyFunction
public class MapDecorator extends SmartArrayDecorator {
    private Object[] array;

    public MapDecorator(SmartArray smartArray, MyFunction func) {
        super(smartArray);
        array = Arrays.stream(smartArray.toArray()).map(func::apply).toArray();
    }

    @Override
    public Object[] toArray() {
        return array.clone();
    }

    @Override
    public String operationDescription() {
        return "Map decorator. Apply a specified function to each element";
    }

    @Override
    public int size() {
        return array.length;
    }
}
