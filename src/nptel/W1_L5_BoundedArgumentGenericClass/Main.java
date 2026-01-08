package nptel.W1_L5_BoundedArgumentGenericClass;

// Base Class
class Animal {
    String name;
    Animal(String name) { this.name = name; }
    void sound() { System.out.println(name + " makes a sound."); }
}

// Subclasses
class Dog extends Animal {
    Dog(String name) { super(name); }
    @Override void sound() { System.out.println(name + " barks!"); }
}

class Cat extends Animal {
    Cat(String name) { super(name); }
    @Override void sound() { System.out.println(name + " meows!"); }
}

// Generic Class with Upper Bound
class Zoo<T extends Animal> {
    private T animal;
    Zoo(T animal) { this.animal = animal; }
    public void showAnimal() {
        animal.sound(); // Safe: T must be an Animal
    }

}

// Utility Class demonstrating wildcards
class ZooUtils {

    // Upper bounded wildcard: Accepts any Zoo of Animal or subclass
    public static void printZoo(Zoo<? extends Animal> zoo) {
        zoo.showAnimal(); // Safe to read
    }

    // Lower bounded wildcard: Accepts Zoo of Dog or its superclass
    public static void addDog(Zoo<? super Dog> zoo) {
        System.out.println("Dog can safely be placed to " + zoo + " here!");
    }

    // Unbounded wildcard: Works with any Zoo type
    public static void printAnyZoo(Zoo<?> zoo) {
        System.out.println("This is " + zoo + " zoo with animals!");
    }
}

// Main Driver
public class Main {
    public static void main(String[] args) {
        Zoo<Dog> dogZoo = new Zoo<>(new Dog("Tommy"));
        Zoo<Cat> catZoo = new Zoo<>(new Cat("Kitty"));

        // ✅ Using Upper Bound
        ZooUtils.printZoo(dogZoo);
        ZooUtils.printZoo(catZoo);

        // ✅ Using Lower Bound
        ZooUtils.addDog(dogZoo);  // Works because Dog is allowed

        // ✅ Using Unbounded Wildcard
        ZooUtils.printAnyZoo(catZoo);
    }
}
