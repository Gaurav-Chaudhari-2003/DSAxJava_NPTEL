package W1_L3_BasicsOfGenericClasses;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Map;

/**
 * A generic class that can hold a value of any type T.
 */
class GenericClass<T> {
    private T value; // The stored value of generic type T

    // Constructor to initialize the generic value
    public GenericClass(T value) {
        this.value = value;
    }

    // Method to return the stored value
    public T getValue() {
        return this.value;
    }
}

/**
 * A generic Student class that can store name and age
 * with different possible data types.
 * N -> Type for name
 * A -> Type for age
 */
class Student<N, A> {
    N name; // Generic type for name
    A age;  // Generic type for age

    // Constructor to initialize student details
    public Student(N name, A age) {
        this.name = name;
        this.age = age;
    }

    // Method to return data as a key-value pair (Map.Entry)
    public Map.Entry<N, A> getData() {
        return new AbstractMap.SimpleEntry<>(name, age);
    }
}

/**
 * Main class to demonstrate the use of generic classes.
 */
public class Main {
    public static void main(String[] args) {

        // Example 1: GenericClass holding a String
        GenericClass<String> dog = new GenericClass<>("Dog");
        System.out.println(dog.getValue());

        // Example 2: GenericClass holding an Integer
        GenericClass<Integer> century = new GenericClass<>(100);
        System.out.println(century.getValue());

        // Example 3: GenericClass holding a Float
        GenericClass<Float> pi = new GenericClass<>(3.14f);
        System.out.println(pi.getValue());

        // Example 4: GenericClass holding an Integer array
        GenericClass<Integer[]> dog2 = new GenericClass<>(new Integer[]{1, 2, 3});
        System.out.println(Arrays.toString(dog2.getValue()));

        // Example 5: GenericClass holding a Student object (name: String, age: Integer)
        GenericClass<Student<String, Integer>> student1 =
                new GenericClass<>(new Student<>("John", 123));
        System.out.println(student1.getValue().getData());
    }
}

