class Solution {
    public int search(int[] nums, int target) {
          int left = 0;
    int right = nums.length - 1;
    while (left <= right) {
        int mid = left + (right - left) / 2;
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] > target) {
            
            if (nums[left] <= nums[mid] && nums[left] > target) { 
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        } else {
            
            if (nums[right] >= nums[mid] && nums[right] < target) { 
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
    }
    return -1;
    }
}