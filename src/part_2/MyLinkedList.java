package part_2;

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
            size++;
        }else {
            tail.setNext(new Node<>(value));
            tail = tail.next;
            size++;
        }
    }

    public T get(int index) throws IndexOutOfBoundsException{
        if(index > size - 1){
            throw new IndexOutOfBoundsException("You entered too large index");
        }
        Node<T> start = head;
        for(int i=0; i<index; i++){
            start = start.next;
        }
        return start.value;
    }

    private Node<T> getNode(int index) throws IndexOutOfBoundsException{
        if(index > size - 1){
            throw new IndexOutOfBoundsException("You entered too large index");
        }
        Node<T> start = head;
        for(int i=0; i<=index; i++){
            start = start.next;
        }
        return start;
    }

    public T remove(int index){
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        Node<T> nodeBeforeRemovingElement = getNode(index-1);
        nodeBeforeRemovingElement.setNext(nodeBeforeRemovingElement.next.next);
        return get(index);
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
