package W4_L4_LinkedListUsingJCF;
import java.util.ArrayList;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("Jay");
        list.add("Gaurav");
        list.addFirst("Hello");
        list.addLast("World");
        System.out.println(list);
        list.removeFirst();
        list.removeLast();
        System.out.println(list.peek());

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("1");
        arrayList.add("2");
        arrayList.add("3");

        LinkedList<String> linkedList = new LinkedList<>(arrayList);
        linkedList.remove("2");
        System.out.println(linkedList);


        for (String s : list) {
            System.out.print(s + " -> ");
        }

        System.out.println();

        for (String s : linkedList.reversed()) {
            System.out.print(s + " -> ");
        }
    }
}
