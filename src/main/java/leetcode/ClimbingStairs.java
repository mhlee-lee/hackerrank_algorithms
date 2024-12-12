package leetcode;

public class ClimbingStairs {
    public int climbStairs(int n) {
        if (n < 3) return n;
        int step2Down = 1;
        int step1Down = 2;

        for (int i = 3; i <= n ; i++) {
            int currentStep = step1Down + step2Down;
            step2Down = step1Down;
            step1Down = currentStep;
        }
        return step1Down;
    }

    public static void main(String[] args) {
        ClimbingStairs problem = new ClimbingStairs();
        System.out.println(problem.climbStairs(2));
        System.out.println(problem.climbStairs(3));
    }
}
