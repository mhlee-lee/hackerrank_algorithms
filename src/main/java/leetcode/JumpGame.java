package leetcode;

public class JumpGame {
    public boolean canJump(int[] nums) {
        int maxReacherableIndex = 0;
        for (int i = 0 ; i < nums.length ; i++) {
            if (maxReacherableIndex < i) return false;
            maxReacherableIndex = Math.max(maxReacherableIndex, i + nums[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        JumpGame jumpGame = new JumpGame();
        System.out.println(jumpGame.canJump(new int[]{2,3,1,1,4}));
        System.out.println(jumpGame.canJump(new int[]{3,2,1,0,4}));

    }
}
