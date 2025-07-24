package part_2;

public class Test {
    public static void main(String[] args) {
        MyLinkedList<String> linkedList = new MyLinkedList<>();
        linkedList.add("One");
        linkedList.add("Two");
        linkedList.add("Three");
        linkedList.add("Four");
        linkedList.add("Five");
        linkedList.add("Six");
        System.out.println(linkedList.get(0));
        System.out.println(linkedList.get(1));
        System.out.println(linkedList.get(5));
        try {
            System.out.println(linkedList.get(6));
        }catch (IndexOutOfBoundsException e){
            System.out.println("Вы попытались получить значение по индексу, выходящему за размер списка");
        }

        System.out.println("=============================================================");

        linkedList.forEach(System.out::println);
    }
}
