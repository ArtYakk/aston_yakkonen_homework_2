package part_1.arraylist;

import java.util.Collection;

public class MyArrayList<T> {
    private Object[] values; // !!!!!!!!!!!!

    private final int INITIAL_CAPACITY = 10;

    private int size = 0;
    private int capacity;

    public MyArrayList() {
        capacity = INITIAL_CAPACITY;
        this.values = new Object[capacity];
    }

    public void add(T element){
        ensureCapacity(size + 1);
        values[size++] = element;
    }

    public T get(int index){
        checkIndex(index);
        return (T)values[index];
    }

    public void addAll(Collection<? extends T> collection){
        collection.forEach(a -> add(a));
    }

    public void remove(int index){
        checkIndex(index);

        values[index] = null;
        size--;

        Object[] newMas = new Object[capacity];
        int j = 0;
        for (int i = 0; i < values.length; i++) {
            if(i != index){
                newMas[j++] = values[i];
            }
        }
        values = newMas;
    }

    public int getSize() {
        return size;
    }

    private void checkIndex(int index) throws ArrayIndexOutOfBoundsException{
        if(index < 0 || index > (size - 1)){
            throw new ArrayIndexOutOfBoundsException("Ты либо ввел индекс меньше нуля, либо больше последнего элемента");
        }
    }

    private void ensureCapacity(int index){
        if(index > capacity - 1){
            grow();
        }
    }

    private void grow(){
        capacity *= 2;
        Object[] newMas = new Object[capacity];
        for (int i = 0; i < values.length; i++) {
            newMas[i] = values[i];
        }
        values = newMas;
    }


}
