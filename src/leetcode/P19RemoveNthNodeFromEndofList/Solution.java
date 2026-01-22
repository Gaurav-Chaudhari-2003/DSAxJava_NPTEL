package leetcode.P19RemoveNthNodeFromEndofList;


 // Definition for singly-linked list.
 class ListNode {
      int val;
      ListNode next;
//      ListNode() {}
      ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }

     @Override
     public String toString() {
         StringBuilder sb = new StringBuilder();
         sb.append("[");
         ListNode current = this;
         while (current != null) {
             sb.append(current.val);
             if (current.next != null) {
                 sb.append(",");
             }
             current = current.next;
         }
         sb.append("]");
         return sb.toString();
     }
  }


class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return null;
        else if(head.next == null && n == 1) return null;

        ListNode backPointer = head;
        ListNode forwardPointer = head.next;
        int i = 0;
        while(i < n-1){
            if(forwardPointer.next != null) forwardPointer = forwardPointer.next;
            else {
                head = head.next;
                return head;
            }
            i++;
        }

        while(forwardPointer.next != null){
            backPointer = backPointer.next;
            forwardPointer = forwardPointer.next;
        }

        backPointer.next = backPointer.next.next;

        return head;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: Standard case
        // Input: head = [1,2,3,4,5], n = 2
        ListNode head1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        System.out.println("Test Case 1 Input: " + head1 + ", n = 2");
        System.out.println("Test Case 1 Output: " + solution.removeNthFromEnd(head1, 2));
        // Expected: [1,2,3,5]

        // Test Case 2: Single node, remove it
        // Input: head = [1], n = 1
        ListNode head2 = new ListNode(1);
        System.out.println("Test Case 2 Input: " + head2 + ", n = 1");
        System.out.println("Test Case 2 Output: " + solution.removeNthFromEnd(head2, 1));
        // Expected: []

        // Test Case 3: Two nodes, remove last
        // Input: head = [1,2], n = 1
        ListNode head3 = new ListNode(1, new ListNode(2));
        System.out.println("Test Case 3 Input: " + head3 + ", n = 1");
        System.out.println("Test Case 3 Output: " + solution.removeNthFromEnd(head3, 1));
        // Expected: [1]
        
        // Test Case 4: Two nodes, remove first
        // Input: head = [1,2], n = 2
        ListNode head4 = new ListNode(1, new ListNode(2));
        System.out.println("Test Case 4 Input: " + head4 + ", n = 2");
        System.out.println("Test Case 4 Output: " + solution.removeNthFromEnd(head4, 2));
        // Expected: [2]

        // Test Case 5: Three nodes, remove first
        // Input: head = [1,2,3], n = 3
        ListNode head5 = new ListNode(1, new ListNode(2, new ListNode(3)));
        System.out.println("Test Case 5 Input: " + head5 + ", n = 3");
        System.out.println("Test Case 5 Output: " + solution.removeNthFromEnd(head5, 3));
        // Expected: [2,3]

    }
}
