package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// https://leetcode.com/problems/subsets/description/
public class SubSets {

    public List<List<Integer>> resolve(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(Collections.emptyList());

        for (int i = 0 ; i < nums.length ; i++) {
            List<List<Integer>> newList = new ArrayList<>();

            for(List<Integer> subs : result) {
                List<Integer> subNews = new ArrayList<>(subs);
                subNews.add(nums[i]);
                newList.add(subNews);
            }

            result.addAll(newList);
        }

        return result;
    }

    public static void main(String[] args) {
        SubSets problem = new SubSets();
        System.out.println(problem.resolve(new int[]{1, 2, 3}));
        System.out.println(problem.resolve(new int[]{0}));
    }
}
