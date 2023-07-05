class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();

        for(int n:nums){
            map.put(n,map.getOrDefault(n,0)+1);
        }
        int res = Integer.MIN_VALUE;
        for(Map.Entry<Integer,Integer> m:map.entrySet()){
            if(m.getValue()==1){
                res = m.getKey();
            }
        }
        return res;
    }
}