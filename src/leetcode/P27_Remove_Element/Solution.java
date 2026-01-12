package leetcode.P27_Remove_Element;

import java.util.*;

class Solution {
    public int removeDuplicates(int[] nums,  int val) {
        int left = 0;
        int right = nums.length - 1;

        while(left <= right) {
            if(nums[left] == val) {
                nums[left] = nums[right--];
            } else left++;
        }

        return left;
    }

    public static void main(String[] args) {
        int [] a = {0,1,2,2,3,0,4,2};
        int k = new Solution().removeDuplicates(a, 2);
        System.out.println(k);
        for (int i : a){
            System.out.print(i + " ");
        }
    }
}
