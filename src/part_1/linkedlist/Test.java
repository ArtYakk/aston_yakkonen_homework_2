package part_1.linkedlist;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        MyLinkedList<String> linkedList = new MyLinkedList<>();
        linkedList.add("One");
        linkedList.add("Two");
        linkedList.add("Three");
        linkedList.add("Four");
        linkedList.add("Five");
        linkedList.add("Six");

        System.out.println("Первый элемент: get(0): " + linkedList.get(0));
        System.out.println("Второй элемент: get(1): " + linkedList.get(1));
        System.out.println("Последний элемент: get(5): " + linkedList.get(5));

        try {
            System.out.println(linkedList.get(6));
        }catch (IndexOutOfBoundsException e){
            System.out.println("Вы попытались получить значение по индексу, выходящему за размер списка");
        }

        try {
            System.out.println(linkedList.get(-1));
        }catch (IndexOutOfBoundsException e){
            System.out.println("Вы попытались получить значение по индексу, значение которого меньше нуля");
        }

        System.out.println("=============================================================");

        System.out.println("Реализовал Iterable, результат вывода forEach()");
        linkedList.forEach(System.out::println);

        System.out.println("=============================================================");

        System.out.println("Удаляем первый элемент: " + linkedList.remove(0));
        linkedList.forEach(System.out::println);

        System.out.println("=============================================================");

        System.out.println("Удаляем последний элемент: " + linkedList.remove(4));
        linkedList.forEach(System.out::println);

        System.out.println("=============================================================");

        System.out.println("Удаляем второй элемент: " + linkedList.remove(1));
        linkedList.forEach(System.out::println);

        System.out.println("=============================================================");

        System.out.println("Создадим, например, ArrayList, добавим его полностью в мой linkedList");
        List<String> arrayList = new ArrayList<>();
        arrayList.add("Vasya");
        arrayList.add("Petya");
        arrayList.add("Kolya");
        arrayList.add("Viktor");
        arrayList.add("Elena");
        linkedList.addAll(arrayList);
        linkedList.forEach(System.out::println);
    }
}
