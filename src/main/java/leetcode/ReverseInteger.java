package leetcode;

import java.util.ArrayList;
import java.util.List;

public class ReverseInteger {
    public int solve(int x) {
        long result = 0;
        while (x != 0) {
            result  = result * 10 + x % 10;
            x /= 10;

            if (result < Integer.MIN_VALUE || result > Integer.MAX_VALUE) return 0;
        }

        return (int)result;
    }

    public static void main(String[] args) {
        ReverseInteger problem = new ReverseInteger();
        System.out.println(problem.solve(-123));
        System.out.println(problem.solve(1534236469));
        System.out.println(problem.solve(123));
        System.out.println(problem.solve(120));
    }
}
