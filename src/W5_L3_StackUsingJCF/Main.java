package W5_L3_StackUsingJCF;

import java.util.Arrays;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.search(1));

        String[] arr = {"10", "20", "30", "40"};
        Iterator<String> iterator = Arrays.stream(arr).iterator();
        while (iterator.hasNext()) {
            stack.push(Integer.valueOf(iterator.next()));
        }
        System.out.println(stack);

        ListIterator<Integer> listIterator = stack.listIterator(stack.size());
        while (listIterator.hasPrevious()) {
            System.out.println(listIterator.previous());
        }
    }
}
