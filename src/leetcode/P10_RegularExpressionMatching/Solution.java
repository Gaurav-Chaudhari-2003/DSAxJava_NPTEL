package leetcode.P10_RegularExpressionMatching;


class Solution {
    public boolean isMatch(String s, String p) {
        return s.matches(p);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isMatch("aa", "a"));
        System.out.println(s.isMatch("a", "a*"));
        System.out.println(s.isMatch("aa", ".*"));
        System.out.println(s.isMatch("ab", ".a"));
    }
}
