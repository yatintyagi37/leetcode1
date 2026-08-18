class Solution {
    public int findMin(int[] nums) {

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {

            // Find the middle element
            int mid = left + (right - left) / 2;

            // Minimum is in the right half
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            }

            // Minimum is in the left half, including mid
            else if (nums[mid] < nums[right]) {
                right = mid;
            }

            // nums[mid] == nums[right]
            // We cannot determine which side contains the minimum,
            // so safely reduce the search space by one.
            else {
                right--;
            }
        }

        // left == right, so this is the minimum element
        return nums[left];
    }
}