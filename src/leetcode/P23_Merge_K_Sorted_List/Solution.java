package leetcode.P23_Merge_K_Sorted_List;


import java.util.Comparator;
import java.util.PriorityQueue;

// Definition for singly-linked list.
 class ListNode {
     int val;
     ListNode next;
     ListNode() {}
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
    public ListNode mergeKLists(ListNode[] lists) {
        // Base case: if the input array is empty, return null
        if(lists.length == 0) return null;
        // Base case: if there is only one list, return it as is
        else if(lists.length == 1) return lists[0];

        // Create a PriorityQueue (Min-Heap) to store the head nodes of all lists
        // The queue is ordered by the value of the nodes
        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));

        // Add the head of each non-null list to the priority queue
        for(ListNode list : lists){
            if(list != null) pq.offer(list);
        }

        // Create a dummy head for the result sorted list
        ListNode sortedHead = new ListNode();
        ListNode tail = sortedHead;

        // Process the priority queue until it's empty
        while(!pq.isEmpty()) {
            // Extract the node with the smallest value from the queue
            ListNode current = pq.poll();
            
            // Append the smallest node to the result list
            tail.next = current;
            tail = tail.next;

            // If the extracted node has a next node, add it to the priority queue
            if(current.next != null) pq.offer(current.next);
        }

        // Return the next node of dummy head which is the actual head of the sorted list
        return sortedHead.next;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: Standard case
        // Input: lists = [[1,4,5],[1,3,4],[2,6]]
        ListNode l1 = new ListNode(1, new ListNode(4, new ListNode(5)));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode l3 = new ListNode(2, new ListNode(6));
        ListNode[] lists1 = {l1, l2, l3};

        System.out.println("Test Case 1 Input: " + java.util.Arrays.toString(lists1));
        System.out.println("Test Case 1 Output: " + solution.mergeKLists(lists1));
        // Expected: [1,1,2,3,4,4,5,6]

        // Test Case 2: Empty list of lists
        // Input: lists = []
        ListNode[] lists2 = {};
        System.out.println("Test Case 2 Input: []");
        System.out.println("Test Case 2 Output: " + solution.mergeKLists(lists2));
        // Expected: null or []

        // Test Case 3: List containing empty lists
        // Input: lists = [[]]
        ListNode[] lists3 = {null};
        System.out.println("Test Case 3 Input: [[]]");
        System.out.println("Test Case 3 Output: " + solution.mergeKLists(lists3));
        // Expected: null or []
        
        // Test Case 4: Single list
        // Input: lists = [[1, 2, 3]]
        ListNode l4 = new ListNode(1, new ListNode(2, new ListNode(3)));
        ListNode[] lists4 = {l4};
        System.out.println("Test Case 4 Input: " + java.util.Arrays.toString(lists4));
        System.out.println("Test Case 4 Output: " + solution.mergeKLists(lists4));
        // Expected: [1,2,3]
    }
}