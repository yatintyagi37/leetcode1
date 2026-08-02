class Solution {
    public boolean predictTheWinner(int[] nums) {
        return fn(0,nums.length-1,nums) >=0;
    }
    public int fn(int i, int j, int[] nums){
        if (i == j) return nums[i];

        int left = nums[i] - fn(i+1,j,nums);
        int right = nums[j] - fn(i,j-1,nums);
        return Math.max(left,right);
    }
}