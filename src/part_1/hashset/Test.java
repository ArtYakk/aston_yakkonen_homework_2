package part_1.hashset;

public class Test {


    public static void main(String[] args) {
        MyHashSet<String> hashSet = new MyHashSet<>();
        System.out.println("Попытка добавить One: " + hashSet.add("One"));
        System.out.println("Попытка добавить One: " + hashSet.add("One"));
        System.out.println("Попытка добавить Two: " + hashSet.add("Two"));
        System.out.println("Попытка добавить Two: " + hashSet.add("Two"));
        System.out.println("Попытка добавить Three: " + hashSet.add("Three"));
        System.out.println("Попытка добавить Four: " + hashSet.add("Four"));
        System.out.println("Попытка добавить Five: " + hashSet.add("Five"));

        System.out.println("===========================================");

        hashSet.forEach(System.out::println);

        System.out.println("===========================================");

        System.out.println("Попытка удалить One: " +  hashSet.remove("One"));
        System.out.println("Попытка удалить One: " +  hashSet.remove("One"));
        System.out.println("Попытка удалить One: " +  hashSet.remove("One"));
        System.out.println("Попытка удалить Two: " + hashSet.remove("Two"));
        System.out.println("Попытка удалить Two: " + hashSet.remove("Two"));
        System.out.println("Попытка удалить Three: " + hashSet.remove("Three"));

        System.out.println("===========================================");

        hashSet.forEach(System.out::println);

        System.out.println("===========================================");

        System.out.println("Does this set contain a Four?: " + hashSet.contains("Four"));
        System.out.println("Does this set contain a Five?: " + hashSet.contains("Five"));
        System.out.println("Does this set contain a SomeOtherString?: " + hashSet.contains("SomeOtherString"));

    }
}
