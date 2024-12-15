package leetcode;

public class LongestPalindromicSubString {
    public String solve(String s) {
        int maxStartIndex = 0, maxEndIndex = 0;
        int maxLength = 0;
        for (int i = 0 ; i < s.length() ; i++) {
            int oddLength = maxLength(s, i, i);
            int evenLength = maxLength(s, i, i + 1);

            if (maxLength < Math.max(oddLength, evenLength)) {
                if (oddLength < evenLength) {
                    // 0 1 2 3 4 5 6 7, i = 3 length = 4
                    // a q b c c b l 1 , i =  length/2 + 1
                    maxStartIndex = i - evenLength/2 + 1;
                    maxEndIndex = i + evenLength/2;
                } else {
                    // 0 1 2 3 4 5 6 7, i = 3 length = 3
                    // a q b c b l 1 ,
                    maxStartIndex = i - oddLength/2;
                    maxEndIndex = i + oddLength/2;
                }

                maxLength = Math.max(oddLength, evenLength);
            }
        }

        return s.substring(maxStartIndex, maxEndIndex + 1);
    }

    public int maxLength(String s, int left, int right) {
        int equalLeft = 0, equalRight = 0;
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            equalLeft = left;
            equalRight = right;
            left--;
            right++;
        }

        return equalRight - equalLeft + 1;
    }

    public static void main(String[] args) {
        LongestPalindromicSubString problem = new LongestPalindromicSubString();
        System.out.println(problem.solve("babad"));
        System.out.println(problem.solve("ac"));
        System.out.println(problem.solve("cbbd"));
    }
}
