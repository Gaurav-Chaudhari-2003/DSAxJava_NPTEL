package leetcode.P24_SwapNodesInPairs;

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        while (prev.next != null && prev.next.next != null) {
            ListNode first = prev.next;
            ListNode second = prev.next.next;

            // Swap
            first.next = second.next;
            second.next = first;
            prev.next = second;

            // Move to next pair
            prev = first;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: [1,2,3,4] -> [2,1,4,3]
        System.out.println("Test Case 1: [1,2,3,4]");
        ListNode head1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        printList(solution.swapPairs(head1));

        // Test Case 2: [] -> []
        System.out.println("Test Case 2: []");
        ListNode head2 = null;
        printList(solution.swapPairs(head2));

        // Test Case 3: [1] -> [1]
        System.out.println("Test Case 3: [1]");
        ListNode head3 = new ListNode(1);
        printList(solution.swapPairs(head3));

        // Test Case 4: [1,2,3] -> [2,1,3]
        System.out.println("Test Case 4: [1,2,3]");
        ListNode head4 = new ListNode(1, new ListNode(2, new ListNode(3)));
        printList(solution.swapPairs(head4));
    }

    private static void printList(ListNode head) {
        ListNode current = head;
        System.out.print("[");
        while (current != null) {
            System.out.print(current.val);
            if (current.next != null) {
                System.out.print(",");
            }
            current = current.next;
        }
        System.out.println("]");
    }
}