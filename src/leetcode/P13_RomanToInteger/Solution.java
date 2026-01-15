package leetcode.P13_RomanToInteger;


class Solution {
    private static int getValue(char ch){
        return switch (ch) {
            case 'I' -> 1;
            case 'V' -> 5;
            case 'X' -> 10;
            case 'L' -> 50;
            case 'C' -> 100;
            case 'D' -> 500;
            case 'M' -> 1000;
            default -> 0;
        };
    }

    public int romanToInt(String s) {
        int number = 0;
        int prevVal = 0;

        for (int i = s.length() - 1; i >= 0; i--){
            int currentVal = getValue(s.charAt(i));

            if(prevVal <= currentVal) number += currentVal;
            else number -= currentVal;

            prevVal = currentVal;
        }
        return number;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().romanToInt("LVIII"));
    }
}
