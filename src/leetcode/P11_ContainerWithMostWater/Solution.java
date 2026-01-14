package leetcode.P11_ContainerWithMostWater;


class Solution {
    public int maxArea(int[] height) {
        int leftPointer = 0;
        int rightPointer = height.length - 1;

        int maxArea = 0;

        while(leftPointer < rightPointer){
            int leftLineLength = height[leftPointer];
            int rightLineLength = height[rightPointer];

            int shortLineLength = Math.min(leftLineLength, rightLineLength);
            int currentArea = shortLineLength*(rightPointer-leftPointer);

            maxArea = Math.max(maxArea, currentArea);

            if(height[leftPointer] < height[rightPointer]) leftPointer++;
            else rightPointer--;
        }

        return maxArea;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().
                maxArea(new int[]{1, 1})
        );
    }
}
