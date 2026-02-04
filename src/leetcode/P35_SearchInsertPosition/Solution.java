package leetcode.P35_SearchInsertPosition;

class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while(left<=right) {
            int middle = left + (right - left) / 2;
            if(nums[middle] == target) return middle;
            else if(nums[middle] < target) left = middle+1;
            else right = middle-1;
        }
        return left;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: Target found in the middle
        int[] nums1 = {1, 3, 5, 6};
        int target1 = 5;
        System.out.println("Test Case 1: " + solution.searchInsert(nums1, target1));
        // Expected: 2

        // Test Case 2: Target not found, should be inserted in between
        int[] nums2 = {1, 3, 5, 6};
        int target2 = 2;
        System.out.println("Test Case 2: " + solution.searchInsert(nums2, target2));
        // Expected: 1

        // Test Case 3: Target not found, should be inserted at the end
        int[] nums3 = {1, 3, 5, 6};
        int target3 = 7;
        System.out.println("Test Case 3: " + solution.searchInsert(nums3, target3));
        // Expected: 4

        // Test Case 4: Target not found, should be inserted at the beginning
        int[] nums4 = {1, 3, 5, 6};
        int target4 = 0;
        System.out.println("Test Case 4: " + solution.searchInsert(nums4, target4));
        // Expected: 0

        // Test Case 5: Single element array, target found
        int[] nums5 = {1};
        int target5 = 1;
        System.out.println("Test Case 5: " + solution.searchInsert(nums5, target5));
        // Expected: 0

        // Test Case 6: Single element array, target smaller
        int[] nums6 = {1};
        int target6 = 0;
        System.out.println("Test Case 6: " + solution.searchInsert(nums6, target6));
        // Expected: 0

        // Test Case 7: Single element array, target larger
        int[] nums7 = {1};
        int target7 = 2;
        System.out.println("Test Case 7: " + solution.searchInsert(nums7, target7));
        // Expected: 1
    }
}
