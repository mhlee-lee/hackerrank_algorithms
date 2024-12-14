package leetcode;

public class StringToInteger {
    public int myAtoi(String s) {
        int idx = 0;
        int sign = 1;
        for( ; idx < s.length() && s.charAt(idx) == ' ' ; idx++);

        if (idx < s.length() && (s.charAt(idx) == '-' || s.charAt(idx) == '+')) {
            if (s.charAt(idx) == '-') sign = -1;
            idx++;
        }

        long result = 0;
        for ( ; idx < s.length() && Character.isDigit(s.charAt(idx)); idx++) {
            result = result * 10 + s.charAt(idx) - '0';

            if (result * sign > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if (result * sign < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        }

        return (int)(result * sign);
    }

    public static void main(String[] args) {
        StringToInteger problem = new StringToInteger();
        System.out.println(problem.myAtoi(""));
        System.out.println(problem.myAtoi("34287387285729"));
        System.out.println(problem.myAtoi(".1"));
        System.out.println(problem.myAtoi("42"));
        System.out.println(problem.myAtoi(" -042"));
        System.out.println(problem.myAtoi("1337c0d3"));
        System.out.println(problem.myAtoi("0-1"));
        System.out.println(problem.myAtoi("words and 987"));
    }
}
