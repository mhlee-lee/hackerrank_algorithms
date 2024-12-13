package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class FindScoreOfAnArrayAfter {
    public long findScore(int[] nums) {
        Map<Integer, LinkedList<Integer>> numIndexMap = new HashMap<>();
        Set<Integer> markedIndexes = new HashSet<>();
        long ans = 0;
        for (int i = 0 ; i < nums.length ; i++) {
            numIndexMap.computeIfAbsent(nums[i], k -> new LinkedList<>()).add(i);
        }

        List<Integer> numList = numIndexMap.keySet().stream().sorted().collect(Collectors.toList());

        for (int num : numList) {
            LinkedList<Integer> indexes = numIndexMap.get(num);

            while(!indexes.isEmpty()) {
                int index = indexes.removeFirst();
                if (!markedIndexes.contains(index)) {
                    if (index > 0) markedIndexes.add(index-1);
                    markedIndexes.add(index);
                    markedIndexes.add(index + 1);
                    ans += num;
                }
            }
        }

        return ans;
    }
    public long findScore2(int[] nums) {
        long ans = 0;
        int[][] sorted = new int[nums.length][2];
        boolean[] marked = new boolean[nums.length];

        for (int i = 0 ; i < nums.length ; i++) {
            sorted[i][0] = nums[i];
            sorted[i][1] = i;
        }

        Arrays.sort(sorted, (a, b) -> a[0] - b[0]);
        for (int i = 0 ; i < nums.length ; i++) {
            int num = sorted[i][0];
            int index = sorted[i][1];

            if (!marked[index]) {
                marked[index] = true;
                if (index > 0) marked[index-1] = true;
                if (index + 1 < nums.length) marked[index+1] = true;
                ans += num;
            }
        }

        return ans;
    }


    public static void main(String[] args) {
        FindScoreOfAnArrayAfter problem = new FindScoreOfAnArrayAfter();
        System.out.println(problem.findScore(new int[] {10,44,10,8,48,30,17,38,41,27,16,33,45,45,34,30,22,3,42,42}));
        System.out.println(problem.findScore(new int[] {2,1,3,4}));
        System.out.println(problem.findScore(new int[] {2,1,3,4,5,2}));
        System.out.println(problem.findScore(new int[] {2,3,5,1,3,2}));
    }
}
