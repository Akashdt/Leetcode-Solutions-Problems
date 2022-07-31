class NumArray {

    int[] nums;
    int sum = 0;
    public NumArray(int[] nums) {
        this.nums = nums;
        
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
    }
    
    public void update(int index, int val) {
        sum += val - nums[index];
        nums[index] = val;
    }
    
    public int sumRange(int left, int right) {
        if (right - left > nums.length / 2) {
            int result = sum;
            for (int i = 0; i < left; i++) {
                result -= nums[i];
            }
            for (int i = right + 1; i < nums.length; i++) {
                result -= nums[i];
            }
            return result;
        } else {
            int result = 0;
            for (int i = left; i <= right; i++) {
                result += nums[i];
            }
            return result;
        }
        
    }
}