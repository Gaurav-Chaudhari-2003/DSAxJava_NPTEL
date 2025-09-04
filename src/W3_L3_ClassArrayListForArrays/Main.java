package W3_L3_ClassArrayListForArrays;
import java.util.ArrayList;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
//        ArrayList<Integer> arrList = new ArrayList<>();
        ArrayList<Integer> arrayList2 = new ArrayList<>(20);
        arrayList2.add(10);
//        arrayList2.add(15, 20);       // Will cause Array Index Out of Bounds Exception because Capacity != Size
        for(int i : arrayList2) System.out.println(i);
        ArrayList<Integer> newList = new ArrayList<>(arrayList2);
        System.out.println(newList);


        // Custom sorting
        ArrayList<String> fruits = new ArrayList<>();
        fruits.add("Mango");
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.sort(String::compareTo); // Ascending
        fruits.sort(Comparator.reverseOrder()); // De-scending
        System.out.println(fruits); // [Apple, Banana, Mango]

        ArrayList<Person> people = new ArrayList<>();
        people.add(new Person("John", 25));
        people.add(new Person("Alice", 30));

        people.sort((p1, p2) -> p2.age - p1.age);
        people.forEach(System.out::println);

        String[] fruitsArray = fruits.toArray(new String[0]);
        for (String s : fruitsArray) System.out.println(s);
    }
}

class Person {
    String name; int age;
    Person(String n, int a){ name=n; age=a; }
    public String toString(){ return name+"-"+age; }
}
