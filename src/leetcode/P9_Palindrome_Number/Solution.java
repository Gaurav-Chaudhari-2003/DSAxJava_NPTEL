package leetcode.P9_Palindrome_Number;

class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;

        int halfRev = 0;
        while(x > halfRev) {
            halfRev = halfRev * 10 + x % 10;
            x /= 10;
        }
        return x == halfRev || x == halfRev/10;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isPalindrome(1));
        System.out.println(s.isPalindrome(121));
        System.out.println(s.isPalindrome(1241));
        System.out.println(s.isPalindrome(-123));
    }
}
