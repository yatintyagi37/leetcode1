class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int ans = 0;
        int end = 0;
        int distance = 0;

        for (int i = 0; i < n - 1; i++) {
            distance = Math.max(distance, i + nums[i]);

            if (i == end) {
                ans++;
                end = distance;
            }
        }

        return ans;
    }
}