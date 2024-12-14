package leetcode;

import java.util.TreeMap;

public class ContinuousSubarrays {
    public long continuousSubarrays(int[] nums) {
        int left = 0;
        long count = 0;
        TreeMap<Integer, Integer> window = new TreeMap<>();

        for (int right = 0 ; right < nums.length ; right++) {
            window.compute(nums[right], (k, v) -> v == null ? 1 : v+1);

            while(window.lastKey() - window.firstKey() > 2) {
                int leftValue = nums[left];
                left++;

                int remainCount = window.computeIfPresent(leftValue, (k, v) -> v-1);
                if (remainCount == 0) {
                    window.remove(leftValue);
                }
            }
            count += (right - left + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        ContinuousSubarrays problem = new ContinuousSubarrays();
        System.out.println(problem.continuousSubarrays(new int[] {5,4,2,4}));
        System.out.println(problem.continuousSubarrays(new int[] {65,66,67,66,66,65,64,65,65,64}));
        System.out.println(problem.continuousSubarrays(new int[] {31,30,31,32}));
        System.out.println(problem.continuousSubarrays(new int[] {1,2,3}));
    }
}
