package leetcode.P21_Merge_TwoSortest_List;


 // Definition for singly-linked list.
 class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        // Dummy node simplifies handling head
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;  // move forward
        }

        // Attach remaining part
        if (list1 != null) current.next = list1;
        else current.next = list2;

        return dummy.next;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();

        ListNode list1 = new ListNode(1);
        ListNode list1Head = list1;
        list1.next = new ListNode(3);
        list1.next.next = new ListNode(5);


        ListNode list2 = new ListNode(2);
        ListNode list2Head = list2;
        list2.next = new ListNode(4);
        list2.next.next = new ListNode(6);

        ListNode result = solution.mergeTwoLists(list1Head, list2Head);
        while (result != null) {
            System.out.print(" " + result.val);
            result = result.next;
        }

    }
}