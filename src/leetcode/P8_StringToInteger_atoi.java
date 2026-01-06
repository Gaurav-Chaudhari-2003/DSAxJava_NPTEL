package leetcode;


class Solution {
    public int myAtoi(String s) {
        s = s.stripLeading();
        if (s.isEmpty()) return 0;

        int sign = 1;
        int number = 0;

        for(int i = 0; i < s.length(); i++) {
            if(i==0 && (s.charAt(0) == '+' || s.charAt(0) == '-')) {
                sign = (s.charAt(0) == '+') ? 1 : -1;
                continue;
            }

            char currentChar = s.charAt(i);
            if(Character.isDigit(currentChar)) {
                int currentNumber = currentChar - '0';
                if (number > (Integer.MAX_VALUE - currentNumber) / 10)
                    return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                else number = number * 10 + currentNumber;
            } else return number*sign;
        }
        return number*sign;
    }
}


public class P8_StringToInteger_atoi {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.myAtoi("-42"));
    }
}

