package leetcode.P14_LongestCommonPrefix;


class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) return "";

        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++){
            while(!strs[i].startsWith(prefix)){
                prefix = prefix.substring(0, prefix.length() - 1);
                if(prefix.isEmpty()) return "";
            }
        }

        return prefix;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().longestCommonPrefix(
                new String[]{"flower", "flow", "flight"})); // Expected: fl
        System.out.println(new Solution().longestCommonPrefix(
                new String[]{"dog", "racecar", "car"}));    // Expected: ""
        System.out.println(new Solution().longestCommonPrefix(
                new String[]{"apple"}));                    // Expected: apple
        System.out.println(new Solution().longestCommonPrefix(
                new String[]{"", "b"}));                    // Expected: ""
        System.out.println(new Solution().longestCommonPrefix(
                new String[]{"ab", "a"}));                  // Expected: a
        System.out.println(new Solution().longestCommonPrefix(
                new String[]{}));                           // Expected: ""
        System.out.println(new Solution().longestCommonPrefix(
                new String[]{"", "", ""}));                 // Expected: ""
        System.out.println(new Solution().longestCommonPrefix(
                new String[]{"a", "a", "a"}));              // Expected: a
        System.out.println(new Solution().longestCommonPrefix(
                new String[]{"flower", "flow", "f"}));      // Expected: f
        System.out.println(new Solution().longestCommonPrefix(
                new String[]{"interspecies", "interstellar", "interstate"})); // Expected: inters
        System.out.println(new Solution().longestCommonPrefix(
                new String[]{"throne", "dungeon"}));        // Expected: ""
        System.out.println(new Solution().longestCommonPrefix(
                new String[]{"HI", "Hi", ""}));             // Expected: ""
        System.out.println(new Solution().longestCommonPrefix(
                new String[]{"HI", "HI", "", "HI"}));             // Expected: ""
    }
}
