package nptel.W8_L5_SetCollection;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        // --- Demonstrate common methods for all Set implementations using a HashSet ---
        System.out.println("--- Common Set Methods (demonstrated with HashSet) ---");
        Set<String> fruitSet = new HashSet<>();

        // 1. add(element): Adds a single element. Returns false if already present.
        fruitSet.add("Apple");
        fruitSet.add("Banana");
        fruitSet.add("Orange");
        System.out.println("Initial fruit set: " + fruitSet); // Order is not guaranteed

        // 2. contains(element): Checks if the set contains an element.
        System.out.println("Does set contain 'Apple'? " + fruitSet.contains("Apple"));

        // 3. remove(element): Removes an element.
        fruitSet.remove("Banana");
        System.out.println("Set after removing 'Banana': " + fruitSet);

        // 4. size() and isEmpty(): Check set size and emptiness.
        System.out.println("Current size: " + fruitSet.size());
        System.out.println("Is the set empty? " + fruitSet.isEmpty());

        // 5. Mathematical set operations with addAll, retainAll, and removeAll
        Set<String> otherFruits = new HashSet<>(Arrays.asList("Apple", "Grape", "Mango"));
        System.out.println("Other fruit set: " + otherFruits);

        // Union (addAll)
        Set<String> unionSet = new HashSet<>(fruitSet);
        unionSet.addAll(otherFruits);
        System.out.println("Union of sets: " + unionSet);

        // Intersection (retainAll)
        Set<String> intersectionSet = new HashSet<>(fruitSet);
        intersectionSet.retainAll(otherFruits);
        System.out.println("Intersection of sets: " + intersectionSet);

        // Difference (removeAll)
        Set<String> differenceSet = new HashSet<>(fruitSet);
        differenceSet.removeAll(otherFruits);
        System.out.println("Difference of sets (fruitSet - otherFruits): " + differenceSet);

        // 6. clear(): Clears all elements.
        fruitSet.clear();
        System.out.println("Set after clearing: " + fruitSet);

        // --- Demonstrate unique methods of the SortedSet (TreeSet) interface ---
        System.out.println("\n--- Unique Methods for SortedSet (demonstrated with TreeSet) ---");
        SortedSet<Integer> numberSet = new TreeSet<>();
        numberSet.add(50);
        numberSet.add(20);
        numberSet.add(40);
        System.out.println("SortedSet (TreeSet): " + numberSet); // Elements are automatically sorted

        // 1. first(): Returns the lowest element.
        System.out.println("First element: " + numberSet.first());

        // 2. last(): Returns the highest element.
        System.out.println("Last element: " + numberSet.last());

        // 3. headSet(toElement): Returns a subset of elements less than `toElement`.
        System.out.println("Head set (elements < 40): " + numberSet.headSet(40));

        // 4. tailSet(fromElement): Returns a subset of elements >= `fromElement`.
        System.out.println("Tail set (elements >= 40): " + numberSet.tailSet(40));

        // 5. subSet(fromElement, toElement): Returns a subset between the given elements.
        System.out.println("Sub set (elements from 20 inclusive to 50 exclusive): " + numberSet.subSet(20, 50));

        // 6. comparator(): Returns the comparator used to order the elements.
        Comparator<?> comparator = numberSet.comparator();
        System.out.println("Comparator used: " + (comparator == null ? "Natural Ordering" : comparator.getClass().getName()));

        enum Color { RED, GREEN, BLUE, YELLOW, PINK, ORANGE, WHITE, BLACK};
        EnumSet<Color> set1, set2, set3, set4, set5, set6;
        set1 = EnumSet.of(Color.RED, Color.GREEN, Color.BLUE);
        set2 = EnumSet.complementOf(set1);
        set3 = EnumSet.range(Color.RED, Color.YELLOW);
        set4 = EnumSet.allOf(Color.class);
        set5 = EnumSet.noneOf(Color.class);
        set6 = EnumSet.copyOf(set1);

        for(Color c : set1) System.out.print(c + " ");
        set2.forEach(System.out::println);
    }
}
