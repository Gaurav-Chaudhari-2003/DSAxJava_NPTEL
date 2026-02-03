package leetcode.P28_FindIndexOfFirstOccurrenceInString;

class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack.length() < needle.length()) return -1;

        int index = -1;

        int slow = index;
        int fast = 0;

        for (int i=0; i<haystack.length(); i++){
            if(fast == needle.length()-1) {
                index = slow;
                break;
            }

            if(haystack.charAt(i) == needle.charAt(fast)) {
                if(slow <= 0 && fast == 0) slow = i;
                fast++;
            } else {
                index = -1;
                slow = 0;
                fast = 0;
            }
        }

        return index;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: Standard case
        String haystack1 = "sadbutsad";
        String needle1 = "sad";
        System.out.println("Test Case 1: " + solution.strStr(haystack1, needle1));
        // Expected: 0

        // Test Case 2: Not found
        String haystack2 = "leetcode";
        String needle2 = "leeto";
        System.out.println("Test Case 2: " + solution.strStr(haystack2, needle2));
        // Expected: -1

        // Test Case 3: Needle at the end
        String haystack3 = "hello";
        String needle3 = "ll";
        System.out.println("Test Case 3: " + solution.strStr(haystack3, needle3));
        // Expected: 2

        // Test Case 4: Needle same as haystack
        String haystack4 = "a";
        String needle4 = "a";
        System.out.println("Test Case 4: " + solution.strStr(haystack4, needle4));
        // Expected: 0

        // Test Case 5: Needle longer than haystack
        String haystack5 = "aaa";
        String needle5 = "aaaa";
        System.out.println("Test Case 5: " + solution.strStr(haystack5, needle5));
        // Expected: -1
        
        // Test Case 6: Empty needle (though constraints say length >= 1, good to check behavior)
        // Java's indexOf returns 0 for empty string
        String haystack6 = "abc";
        String needle6 = "a";
        System.out.println("Test Case 6: " + solution.strStr(haystack6, needle6));
        // Expected: 0
    }
}
