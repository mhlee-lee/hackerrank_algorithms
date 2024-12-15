package leetcode;

// https://leetcode.com/problems/container-with-most-water/description/
public class ContainerWithMostWater {
    public int solve(int[] height) {
        int maxWater = 0;
        int left = 0, right = height.length - 1;

        while (left < right) {
            int water = Math.min(height[left], height[right]) * (right - left);
            maxWater = Math.max(water, maxWater);

            if (height[left] < height[right]) left++;
            else right--;
        }
        return maxWater;
    }

    public static void main(String[] args) {
        ContainerWithMostWater problem = new ContainerWithMostWater();
        System.out.println(problem.solve(new int[] {1,8,6,2,5,4,8,3,7}));
        System.out.println(problem.solve(new int[] {1, 1}));
    }
}
