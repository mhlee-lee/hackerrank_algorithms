package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LetterCombinationsOfAPhoneNumber {
    public Map<Character, List<String>> numListMap = new HashMap<Character, List<String>>() {{
        put('2', Arrays.asList("a", "b", "c"));
        put('3', Arrays.asList("d", "e", "f"));
        put('4', Arrays.asList("g", "h", "i"));
        put('5', Arrays.asList("j", "k", "l"));
        put('6', Arrays.asList("m", "n", "o"));
        put('7', Arrays.asList("p", "q", "r", "s"));
        put('8', Arrays.asList("t", "u", "v"));
        put('9', Arrays.asList("w", "x", "y", "z"));
    }};


    public List<String> letterCombinations(String digits) {
        List<List<String>> possibleList = new ArrayList<>();

        for (char c : digits.toCharArray()) possibleList.add(numListMap.get(c));

        List<String> result = new ArrayList<>();
        int listCount = possibleList.size();
        if (listCount > 0) {
            int depth = 0;
            result = recv(possibleList, depth + 1, possibleList.get(depth));
        }

        return result;
    }
    public List<String> recv(List<List<String>> possibleList, int depth, List<String> prevStrings) {
        if (depth >= possibleList.size()) return prevStrings;

        List<String> next = prevStrings.stream().flatMap(c ->
            possibleList.get(depth).stream().map(c1 -> c+c1)
        ).collect(Collectors.toList());

        return recv(possibleList, depth+1, next);
    }

    public static void main(String[] args) {
        LetterCombinationsOfAPhoneNumber problem = new LetterCombinationsOfAPhoneNumber();
        System.out.println(problem.letterCombinations("23"));
        System.out.println(problem.letterCombinations(""));
        System.out.println(problem.letterCombinations("2"));

    }

}
