package part_1;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MyHashSet<T> implements Iterable<T>{

    private final Map<T, Object> values = new HashMap<>();
    private final Object OBJECT = new Object();

    public boolean add(T value){
        Object addingResult = values.put(value, OBJECT);
        return addingResult == null;

    }

    public boolean remove(T value){
       Object removingResult = values.remove(value);
       return removingResult != null;
    }

    public boolean contains(T value){
        return values.containsKey(value);
    }

    @Override
    public Iterator<T> iterator() {
        return values.keySet().iterator();
    }
}
