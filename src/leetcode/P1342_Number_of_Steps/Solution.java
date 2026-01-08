package leetcode.P1342_Number_of_Steps;

class Solution {
    public int numberOfSteps(int num) {
        int steps = 0;
        if (num == 0) return steps;

        while(true){
            num = (num % 2 == 0) ? num / 2 : num - 1;
            steps += 1;
            if(num <= 0) return steps;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.numberOfSteps(1));
    }
}