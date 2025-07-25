package part_1.linkedlist;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class MyLinkedList<T> implements Iterable<T>{
    private Node<T> head;
    private Node<T> tail;
    private int size;

    static class Node<T>{
        private T value;
        private Node<T> next;

        private Node(T value){
            this.value = value;
        }

        private void setNext(Node<T> next){
            this.next = next;
        }
    }

    public void add(T value){
        if(head == null){
            head = new Node<>(value);
            tail = head;
        }else {
            tail.setNext(new Node<>(value));
            tail = tail.next;
        }
        size++;
    }

    public void addAll(Collection<? extends T> collection){
        collection.forEach(this::add);
    }

    public T get(int index) throws IndexOutOfBoundsException{
        checkInputIndex(index);

        Node<T> start = head;
        for(int i=0; i<index; i++){
            start = start.next;
        }
        return start.value;
    }

    private Node<T> getNode(int index) throws IndexOutOfBoundsException{
        checkInputIndex(index);

        Node<T> start = head;
        for(int i=0; i<index; i++){
            start = start.next;
        }
        return start;
    }

    public T remove(int index) throws IndexOutOfBoundsException{
        checkInputIndex(index);
        T removedValue;

        if (index == 0){
            removedValue = head.value;
            head = head.next;
        } else if(index == (size - 1)){
            removedValue = tail.value;
            Node<T> nodeBeforeRemovingElement = getNode(index-1);
            nodeBeforeRemovingElement.setNext(null);
            tail = nodeBeforeRemovingElement;
        } else {
            Node<T> nodeBeforeRemovingElement = getNode(index-1);
            removedValue = nodeBeforeRemovingElement.next.value;
            nodeBeforeRemovingElement.setNext(nodeBeforeRemovingElement.next.next);
        }
        size--;
        return removedValue;
    }



    private void checkInputIndex(int index) throws IndexOutOfBoundsException{
        if(index < 0 || index > (size - 1)){
            throw new IndexOutOfBoundsException("Your entered an index, that is less than 0 or greater than last index");
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new MyLinkedListIterator();
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        Iterable.super.forEach(action);
    }

    private class MyLinkedListIterator implements Iterator<T> {
        private Node<T> current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            if(!hasNext()){
                throw new NoSuchElementException();
            }
            T value = current.value;
            current = current.next;
            return value;
        }
    }
}
