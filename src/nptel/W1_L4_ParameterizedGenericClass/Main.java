package nptel.W1_L4_ParameterizedGenericClass;

import java.util.Arrays;

// Student class represents a student with multiple names (String array) and an age
class Student {
    private String[] name; // Array of names
    private int age;       // Age of the student

    // Constructor to initialize student details
    public Student(String[] name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getter method to return names
    public String[] getName() {
        return name;
    }

    // Getter method to return age
    public int getAge() {
        return age;
    }

}

// Generic class with two type parameters <T, V>
class GenericClass<T, V> {
    private T x; // First generic type
    private V y; // Second generic type

    // Constructor to initialize a generic class
    public GenericClass(T x, V y) {
        this.x = x;
        this.y = y;
    }

    // Getter for x
    public T getX() {
        return x;
    }

    // Getter for y
    public V getY() {
        return y;
    }

    // Prints values of x and y
    public void getData() {
        System.out.println(getX());
        System.out.println(getY());
    }
}

public class Main {
    public static void main(String[] args) {
        // Creating a GenericClass object with Integer[] (array of Integers) and String
        GenericClass<Integer[], String> gc1 = new GenericClass<>(new Integer[] {10, 29, 40}, "Gaurav");

        // Creating a GenericClass object with Double and Float
        GenericClass<Double, Float> gc2 = new GenericClass<>(10.3, 53.4f);

        // Creating a GenericClass object with Student object and Boolean
        GenericClass<Student, Boolean> gc3 = new GenericClass<>(
                new Student(new String[] {"Jayesh", "Gaurav"}, 100), false
        );

        // Display data of gc1
        gc1.getData();
        System.out.println();

        // Display data of gc2
        gc2.getData();
        System.out.println();

        // Display age and names of Student object stored in gc3
        System.out.println(gc3.getX().getAge() + " " + Arrays.toString(gc3.getX().getName()));

        System.out.println();

        // Individually accessing gc2 values
        System.out.println(gc2.getX());
        System.out.println(gc2.getY());
    }
}
