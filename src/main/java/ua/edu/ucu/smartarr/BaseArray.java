package ua.edu.ucu.smartarr;

// Base array for decorators
public class BaseArray implements SmartArray {
    private Object[] array;

    @Override
    public Object[] toArray() {
        return array.clone();
    }

    @Override
    public String operationDescription() {
        return null;
    }

    @Override
    public int size() {
        return array.length;
    }

    public BaseArray(Object[] source) {
        this.array = source.clone();
    }
}
