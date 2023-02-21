class Solution {
    public int singleNonDuplicate(int[] nums) {
        int s=0;
        int e=nums.length-1;
        while (s<e) {
            int m=s+(e-s)/2;
            if (nums[m]==nums[m+1]) {
                if (m%2!=0) {
                    e=m;
                } else {
                    s=m+1;
                }
            } else {
                if (m%2==0) {
                    e=m;
                } else {
                    s=m+1;
                }
            }
        }
        return nums[s];
    }
}