package leetcode.P15_3Sum;


import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> triplets = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {

            // Skip duplicate first elements
            if(i > 0 && nums[i] == nums[i-1]) continue;

            int current = nums[i];
            int left = i + 1;
            int right = nums.length - 1;

            while(left < right){
                int sum = current + nums[left] + nums[right];
                if(sum == 0){
                    triplets.add(Arrays.asList(current, nums[left], nums[right]));

                    // Skip duplicates
                    while(left < right && nums[left] == nums[left+1]) left++;
                    while(left < right && nums[right] == nums[right-1]) right--;

                    // Move pointers to the next distinct elements
                    left++;
                    right--;
                }
                else if(sum > 0) right--;
                else left++;
            }
        }

        return triplets;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: Standard case with multiple triplets
        int[] nums1 = {-1, 0, 1, 2, -1, -4};
        System.out.println("Test Case 1: " + solution.threeSum(nums1)); 
        // Expected: [[-1, -1, 2], [-1, 0, 1]]

        // Test Case 2: No solution possible
        int[] nums2 = {0, 1, 1};
        System.out.println("Test Case 2: " + solution.threeSum(nums2)); 
        // Expected: []

        // Test Case 3: All zeros
        int[] nums3 = {0, 0, 0};
        System.out.println("Test Case 3: " + solution.threeSum(nums3)); 
        // Expected: [[0, 0, 0]]

        // Test Case 4: Empty array (though constraints say length >= 3)
        int[] nums4 = {};
        System.out.println("Test Case 4: " + solution.threeSum(nums4)); 
        // Expected: []

        // Test Case 5: Array with fewer than 3 elements
        int[] nums5 = {1, 2};
        System.out.println("Test Case 5: " + solution.threeSum(nums5)); 
        // Expected: []

        // Test Case 6: Large negative and positive numbers
        int[] nums6 = {-100, 50, 50};
        System.out.println("Test Case 6: " + solution.threeSum(nums6)); 
        // Expected: [[-100, 50, 50]]

        // Test Case 7: Duplicates that shouldn't form duplicate triplets
        int[] nums7 = {-2, 0, 0, 2, 2};
        System.out.println("Test Case 7: " + solution.threeSum(nums7)); 
        // Expected: [[-2, 0, 2]]
    }
}
