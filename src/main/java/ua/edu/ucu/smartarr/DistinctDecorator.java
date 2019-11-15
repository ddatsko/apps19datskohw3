package ua.edu.ucu.smartarr;

import java.util.Arrays;
import java.util.LinkedHashSet;

// Remove duplicates from SmartArray. Use method equals() to compare objects
public class DistinctDecorator extends SmartArrayDecorator {
    public DistinctDecorator(SmartArray smartArray) {
        super(smartArray);
        LinkedHashSet<Object> linkedHashSet = new LinkedHashSet<>(Arrays.asList(smartArray.toArray()));
        array = linkedHashSet.toArray();
    }

    @Override
    public String operationDescription() {
        return "Distinct Decorator. Remove all the same elements from the array";
    }

}
