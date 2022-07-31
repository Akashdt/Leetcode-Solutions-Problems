class Solution {
    public int missingNumber(int[] nums) {
        HashSet <Integer> set = new HashSet<>();
            for(int i:nums)
            {
                    set.add(i);
                    
            }
            for(int i=0;i<=nums.length;i++)
            {
                    if (!set.contains(i))
                            return i;
            }
            return -1;
    }
}