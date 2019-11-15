package ua.edu.ucu.smartarr;

abstract class SmartArrayDecorator implements SmartArray {
    protected Object[] array;

    protected SmartArray smartArray;

    public SmartArrayDecorator(SmartArray smartArray) {
        this.smartArray = smartArray;
    }

    @Override
    public Object[] toArray() {
        return array.clone();
    }

    @Override
    public int size() {
        return array.length;
    }
}
