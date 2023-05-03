class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {

        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> ans1 = new ArrayList<Integer>();
        List<Integer> ans2 = new ArrayList<Integer>();
        Set<Integer> s1 = new HashSet<Integer>();
        Set<Integer> s2 = new HashSet<Integer>();
        for(int n : nums1) s1.add(n);
        for(int n : nums2) s2.add(n);

        for(int n :s1){
            if(s2.contains(n)==false){
                ans1.add(n);
            }
        }
        for(int n:s2){
            if(s1.contains(n)==false){
                ans2.add(n);
            }
        }
        ans.add(ans1);
        ans.add(ans2);
        return ans;
    }
}