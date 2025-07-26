package part_1.arraylist;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        MyArrayList<String> myArrayList = new MyArrayList<>();
        myArrayList.add("Vasya");
        myArrayList.add("Petya");
        myArrayList.add("Kolya");

        for (int i = 0; i < myArrayList.getSize(); i++) {
            System.out.println((String)myArrayList.get(i));
        }

        System.out.println("=============================");

        System.out.println(myArrayList.get(1));

        System.out.println("=============================");

        try {
            System.out.println(myArrayList.get(3));
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println(e);
        }

        System.out.println("=============================");

        try {
            System.out.println(myArrayList.get(-1));
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println(e);
        }

        System.out.println("=============================");

        List<String> someList = new ArrayList<>(List.of("Elena", "Marge", "Vitor"));
        myArrayList.addAll(someList);

        for (int i = 0; i < myArrayList.getSize(); i++) {
            System.out.println((String)myArrayList.get(i));
        }

        System.out.println("=============================");

        myArrayList.remove(1);

        for (int i = 0; i < myArrayList.getSize(); i++) {
            System.out.println((String)myArrayList.get(i));
        }

        System.out.println("=============================");

        myArrayList.remove(3);

        for (int i = 0; i < myArrayList.getSize(); i++) {
            System.out.println((String)myArrayList.get(i));
        }

    }
}
