package leetcode;

public class ZigzagConversion {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;

        int length = s.length();
        int builderCount = Math.min(numRows, length);
        StringBuilder[] rows = new StringBuilder[builderCount];
        for (int i = 0 ; i < builderCount ; i++) {
            rows[i] = new StringBuilder();
        }

        int currentRow = 0;
        boolean isGoingDown = false;

        for (char c : s.toCharArray()) {
            rows[currentRow].append(c);
            if (currentRow == 0 || currentRow == numRows - 1) {
                isGoingDown = !isGoingDown;
            }
            currentRow += isGoingDown ? 1 : -1;
        }

        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row.toString());
        }

        return result.toString();
    }

    public static void main(String[] args) {
        ZigzagConversion problem = new ZigzagConversion();
        System.out.println(problem.convert("PAYPALISHIRING", 3));
        System.out.println(problem.convert("PAYPALISHIRING", 4));
    }

}
