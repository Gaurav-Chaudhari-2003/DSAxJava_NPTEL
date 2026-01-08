package leetcode.P1343_Number_of_SubArrays;

class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int subArrCount = 0;

        for(int i = 0; i < arr.length - (k - 1); i++) {
            int currentSum = arr[i];
            for(int j = 1; j < k; j++) {
                currentSum += arr[i+j];
            }
            if ((currentSum / k) >= threshold) subArrCount++;
        }

        return subArrCount;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.numOfSubarrays(new int[]{1,2,3,4,5,6,7,8,9,10}, 3, 6));
    }
}