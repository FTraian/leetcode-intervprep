package fb.integer_to_english;

public class Solution {

    private static final char SPACE = ' ';
    private static String[] suffixes = {"Hundred", "Thousand", "Million", "Billion"};
    private static String[] digits = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
            "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private static String[] tens = {"Zero", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    public String numberToWords(int num) {
        if (num == 0) return digits[0];
        StringBuilder sb = new StringBuilder();
        for (int i = 3; i >= 0; i--) {
            if (num >= Math.pow(10, 3.0 * i)) {
                if (sb.length() > 0) {
                    sb.append(SPACE);
                }
                int hundreds = extractHundreds(num, i);
                sb.append(convertHundreds(hundreds));
                if (i > 0) {
                    sb.append(SPACE);
                    sb.append(suffixes[i]);
                }

                num -= hundreds * Math.pow(10, 3.0 * i);
            }
        }
        return sb.toString();
    }

    private int extractHundreds(int n, int pos) {
        return (int) (n / Math.pow(10, 3 * pos) % 1000);
    }

    private String convertHundreds(int num) {
        StringBuilder sb = new StringBuilder();
        int hundreds = digit(num, 2);
        if (num > 99) {
            sb.append(digits[hundreds]);
            sb.append(SPACE);
            sb.append(suffixes[0]);
        }

        num = num - hundreds * 100;
        if (num > 19) {
            if (sb.length() > 0) {
                sb.append(SPACE);
            }
            sb.append(tens[digit(num, 1)]);
            int unit = digit(num, 0);
            if (unit != 0) {
                sb.append(SPACE);
                sb.append(digits[unit]);
            }
        } else if (num > 0){
            if (sb.length() > 0) {
                sb.append(SPACE);
            }
            sb.append(digits[num]);
        }
        return sb.toString();
    }

    private int digit(int n, int pos) {
        return (int) (n / Math.pow(10, pos) % 10);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numberToWords(123));
        System.out.println(new Solution().numberToWords(111));
        System.out.println(new Solution().numberToWords(1234567));
        System.out.println(new Solution().numberToWords(1234567891));
        System.out.println(new Solution().numberToWords(0));
        System.out.println(new Solution().numberToWords(20));
        System.out.println(new Solution().numberToWords(100));
        System.out.println(new Solution().numberToWords(1000));
    }
}
