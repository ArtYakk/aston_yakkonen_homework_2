package part_1.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> arrayList = new ArrayList<>();

        arrayList.add("Vasya");
        arrayList.add("Petya");
        arrayList.add("Kolya");
        arrayList.add("Elena");
        arrayList.add("Volodya");
        System.out.println(arrayList);

        for(String element : arrayList){/* Enhanced for */
//            if(element.equals("Vasya")){
//                arrayList.remove(element);
//            }
            System.out.println(element);
        }
        System.out.println("Что после удаления из for???");
        System.out.println(arrayList);

        System.out.println("=====================================");

        for(int i=0; i<arrayList.size(); i++){
            System.out.println(arrayList.get(i));
        }

        System.out.println("=====================================");


        System.out.println("Обращение по индексу: " + arrayList.get(1));

        Iterator<String> iterator = arrayList.iterator();
        while(iterator.hasNext()){
            String value = iterator.next();
            if(value.equals("Vasya")){
                iterator.remove();
            }
            System.out.println(value);
        }

        System.out.println("=====================================");


        arrayList.add("One");
        arrayList.add("Two");
        arrayList.add("Three");
        System.out.println(arrayList);
        arrayList.removeLast();

        System.out.println("=====================================");

        System.out.println(arrayList);

        System.out.println("=====================================");

        arrayList.remove(arrayList.size() - 2);
        System.out.println(arrayList);


    }
}
