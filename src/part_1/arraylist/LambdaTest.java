package part_1.arraylist;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class LambdaTest {


    public static void main(String[] args) {
//        MyClass myClass = new MyClass();

//        Function<String, Integer> function = new Function<String, Integer>() {
//            @Override
//            public Integer apply(String o) {
//                return o.length();
//            }
//        };

        Function<String, Integer> function = x -> x.length();
        Supplier<String> supplier = () -> "Hello";
        Consumer<String> consumer = a -> System.out.println(a);
        Predicate<String> predicate = a -> a.length() == 5;

        System.out.println(function.apply("Vasydsfsda"));
        System.out.println(supplier.get());
        consumer.accept("Some string");
        System.out.println(predicate.test("Vasa"));

    }
}

//class MyClass implements Function<String, Integer>{
//    @Override
//    public Integer apply(String s) {
//        return s.length();
//    }
//}
