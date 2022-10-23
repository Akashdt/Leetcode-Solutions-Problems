class Solution {
    public int[] findErrorNums(int[] nums) {
         Set<Integer> set = new HashSet<>();
        int sum=0;
        int[]res = new int[2];
        for(int i : nums){
            if(set.add(i)) sum+=i;
            else res[0]=i;
        }
        int n= nums.length;
        res[1] = n*(n+1)/2 -sum;
        
        return res;
    }
}