package leetcode;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> existMap = new HashMap<>();
        int startIdx = 0;
        int maxLength = 0;
        for (int i = 0 ; i < s.length() ; i++) {
            char c = s.charAt(i);
            Integer dupIndex = existMap.get(c);

            if (dupIndex != null && dupIndex >= startIdx) {
                startIdx = dupIndex + 1;
            }
            existMap.put(c, i);
            maxLength = Math.max(maxLength, i - startIdx + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters problem = new LongestSubstringWithoutRepeatingCharacters();
        System.out.println(problem.lengthOfLongestSubstring("dvdf"));
        System.out.println(problem.lengthOfLongestSubstring("abba"));
        System.out.println(problem.lengthOfLongestSubstring("bbbbb"));
        System.out.println(problem.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(problem.lengthOfLongestSubstring("pwwkew"));
    }
}
