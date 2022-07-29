class Solution {
    public boolean containsDuplicate(int[] nums) {
         HashSet<Integer> list = new HashSet<>();
    
    list.add(nums[0]);
    for(int i = 1;i<nums.length; i++)
        if(list.contains(nums[i]))
            return true;
        else
            list.add(nums[i]);
    
    return false;
    }
}