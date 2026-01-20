package leetcode.P17_LetterCombinationsOfaPhoneNumber;


import java.util.*;

class Solution {
    // Index 0 and 1 are empty strings as they don't map to any letters
    private final List<String> keypad = List.of("", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz");

    public List<String> letterCombinations(String digits) {
        // Base case: if the input string is empty, return an empty list
        if (digits.isEmpty()) return new ArrayList<>();

        List<String> result = new ArrayList<>();
        
        // Base case for recursion: if only one digit is left
        if(digits.length() == 1) {
            // Iterate through the characters corresponding to the digit
            // "abc" --> ["a", "b", "c"]
            for(char c : keypad.get(digits.charAt(0) - '0').toCharArray()){
                result.add(String.valueOf(c));
            }
        } 
        // Recursive step: if more than 1 digit
        else {
            // Recursively call the function for the substring starting from the second digit
            List<String> localResult = letterCombinations(digits.substring(1));
            
            // Combine the letters of the current digit with the results from the recursive call
            for(char c : keypad.get(digits.charAt(0) - '0').toCharArray()){
                for(String s : localResult){
                    result.add(c + s);
                }
            }
        }
        return result;
    }



    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: Standard case with two digits
        String digits1 = "23";
        System.out.println("Test Case 1: " + solution.letterCombinations(digits1));
        // Expected: [ad, ae, af, bd, be, bf, cd, ce, cf]

        // Test Case 2: Single digit
        String digits2 = "2";
        System.out.println("Test Case 2: " + solution.letterCombinations(digits2));
        // Expected: [a, b, c]

        // Test Case 3: Empty string
        String digits3 = "";
        System.out.println("Test Case 3: " + solution.letterCombinations(digits3));
        // Expected: []

        // Test Case 4: Three digits
        String digits4 = "234";
        System.out.println("Test Case 4: " + solution.letterCombinations(digits4));
        // Expected: [adg, adh, adi, aeg, aeh, aei, afg, afh, afi, bdg, bdh, bdi, beg, beh, bei, bfg, bfh, bfi, cdg, cdh, cdi, ceg, ceh, cei, cfg, cfh, cfi]

        // Test Case 5: Digits with 4 letters (7 and 9)
        String digits5 = "79";
        System.out.println("Test Case 5: " + solution.letterCombinations(digits5));
        // Expected: [pw, px, py, pz, qw, qx, qy, qz, rw, rx, ry, rz, sw, sx, sy, sz]
    }
}
