package leetcode.P12_Integer_to_Roman;


class Solution {
    private static final String[] UNITS = new String[]{
            "", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
    private static final String[] TENS = new String[]{
            "", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
    private static final String[] HUNDREDS = new String[]{
            "", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"
    };
    private static final String THOUSAND = "M";


    public String intToRoman(int num) {
        return THOUSAND.repeat(num / 1000) +
                HUNDREDS[(num / 100) % 10] +
                TENS[(num / 10) % 10] +
                UNITS[num % 10];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().intToRoman(58));
    }
}
