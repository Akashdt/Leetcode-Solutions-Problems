class Solution {
    public int[] shuffle(int[] nums, int n) {
        int ans[]=new int[2*n];
        int a=0;
        int b=n;
        int i=0;
        while(b<2*n){
            ans[i]=nums[a];
            ans[i+1]=nums[b];
            a++;
            b++;
            i=i+2;
        }
        return ans;
    }
}