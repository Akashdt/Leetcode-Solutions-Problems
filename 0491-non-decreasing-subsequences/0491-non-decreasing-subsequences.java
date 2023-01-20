class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<Integer> l=new ArrayList<>();
        Set<List<Integer>> res=new HashSet<>();
        bt(0,nums,l,res);
        List<List<Integer>> rs=new ArrayList<>(res);
        return rs;
    }
    void bt(int i,int nums[],List<Integer> l,Set<List<Integer>> res){
        if(i==nums.length){
            if(l.size()>1){
                int p=l.get(0);
                boolean t=true;
                for(int j=1;j<l.size();j++){
                    if(l.get(j)<p){
                        t=false;
                        break;
                    }
                    else{
                        p=l.get(j);
                    }
                }
                if(t==true){
                    res.add(new ArrayList<>(l));
                }
            }
            return;
        }
        l.add(nums[i]);
        bt(i+1,nums,l,res);
        l.remove(l.size()-1);
        bt(i+1,nums,l,res);
    }
}
