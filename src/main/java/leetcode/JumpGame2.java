package leetcode;

public class JumpGame2 {
    public int jump(int[] nums) {
        int maxReach = 0;
        int currentReach = 0;
        int jumps = 0;
        for (int i = 0; i < nums.length ; i++) {
            maxReach = Math.max(maxReach, i + nums[i]);

            if (i == currentReach) {
                jumps++;
                currentReach = maxReach;
                if (currentReach >= nums.length -1) break;
            }
        }
        return jumps;
    }

    public static void main(String[] args) {
        JumpGame2 jumpGame = new JumpGame2();
        System.out.println(jumpGame.jump(new int[]{2,3,1,1,4}));
        System.out.println(jumpGame.jump(new int[]{2,3,0,1,4}));
    }
}
