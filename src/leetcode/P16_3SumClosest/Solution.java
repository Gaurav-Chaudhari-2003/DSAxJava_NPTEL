package leetcode.P16_3SumClosest;


import java.util.Arrays;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        // Sort the array to use the two-pointer technique
        Arrays.sort(nums);
        
        // Initialize the closestSum with the sum of the first three elements
        int closetSum = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicate elements for the first number to avoid redundant calculations
            if (i > 0 && nums[i] == nums[i-1]) continue;

            int current = nums[i];
            int left = i + 1;
            int right = nums.length - 1;


            // -------- PRUNING START --------
            int minSum = current + nums[left] + nums[left + 1];
            // Skips when a minimum sum exceeds target; updates closest sum
            if (minSum > target) {
                if (Math.abs(minSum - target) < Math.abs(closetSum - target))
                    closetSum = minSum;
                continue;
            }

            int maxSum = current + nums[right - 1] + nums[right];
            // Continues when a maximum possible sum is less than target
            if (maxSum < target) {
                if (Math.abs(maxSum - target) < Math.abs(closetSum - target))
                    closetSum = maxSum;
                continue;
            }
            // -------- PRUNING END --------


            while (left < right) {
                int sum = current + nums[left] + nums[right];
                
                // If the sum is exactly the target, return it immediately (closest possible)
                if(sum == target) return target;
                
                // Update closestSum if the current sum is closer to the target
                if(Math.abs(sum - target) < Math.abs(closetSum - target)) closetSum = sum;
                
                // Adjust pointers based on comparison with the target
                if(sum > target) right--; // Sum is too large, decrease it by moving the right pointer left
                else left++;              // Sum is too small, increase it by moving the left pointer right
            }
        }
        return closetSum;
    }



    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: Standard case
        int[] nums1 = {-1, 2, 1, -4};
        int target1 = 1;
        System.out.println("Test Case 1: " + solution.threeSumClosest(nums1, target1));
        // Expected: 2 (-1 + 2 + 1 = 2)

        // Test Case 2: All zeros
        int[] nums2 = {0, 0, 0};
        int target2 = 1;
        System.out.println("Test Case 2: " + solution.threeSumClosest(nums2, target2));
        // Expected: 0 (0 + 0 + 0 = 0)

        // Test Case 3: Exact match found
        int[] nums3 = {1, 1, 1, 0};
        int target3 = 3;
        System.out.println("Test Case 3: " + solution.threeSumClosest(nums3, target3));
        // Expected: 3 (1 + 1 + 1 = 3)

        // Test Case 4: Negative numbers and target
        int[] nums4 = {-10, -20, -30, -40};
        int target4 = -65;
        System.out.println("Test Case 4: " + solution.threeSumClosest(nums4, target4));
        // Expected: -60 (-10 + -20 + -30 = -60) or -70 (-10 + -20 + -40 = -70) -> -60 is closer to -65 than -70? No, |-65 - (-60)| = 5, |-65 - (-70)| = 5.
        // Wait, -10 + -20 + -30 = -60. Distance is 5.
        // -20 + -30 + -40 = -90. Distance is 25.
        // -10 + -30 + -40 = -80. Distance is 15.
        // Closest is -60.

        // Test Case 5: Array with exactly 3 elements
        int[] nums5 = {5, 10, 15};
        int target5 = 20;
        System.out.println("Test Case 5: " + solution.threeSumClosest(nums5, target5));
        // Expected: 30 (5 + 10 + 15 = 30)

        // Test Case 6: Large difference
        int[] nums6 = {1, 2, 3};
        int target6 = 100;
        System.out.println("Test Case 6: " + solution.threeSumClosest(nums6, target6));
        // Expected: 6 (1 + 2 + 3 = 6)

        // Test Case 7:
        int[] nums7 = {-10, -20, -30, -40, -50, -60, -70};
        int target7 = -65;
        System.out.println("Test Case 7: " + solution.threeSumClosest(nums7, target7));
        // Expected: -60 (-10 + -20 + -30 = -60) or -70 (-10 + -20 + -40 = -70) -> -60 is closer to -65 than -70?

    }
}
