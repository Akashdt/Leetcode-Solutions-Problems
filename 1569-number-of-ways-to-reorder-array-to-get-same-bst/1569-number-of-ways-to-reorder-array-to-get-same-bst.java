class Solution {
    public int numOfWays(int[] nums) {
        List<Integer> arr=new ArrayList<>();
        for(int i=0; i<nums.length; i++) {
            arr.add(nums[i]);
        }

        int n=nums.length;
        pascal=new long[n+1][n+1];
        pascal[0][0]=1;
        //nCr = n-1Cr-1 + n-1Cr
        for(int i=1; i<=n; i++) {
            pascal[i][0]=1;
            for(int j=1; j<i; j++) {
                pascal[i][j] = (pascal[i-1][j-1]+pascal[i-1][j])%MOD;
            }
            pascal[i][i]=1;
        }
        /*
        //print pascal's triangle for debugging
        // for(int i=0;i<pascal.length;i++) 
            // System.out.println(Arrays.toString(pascal[i]));
        */

        return (int)(util(arr)-1);
    }

    private final long MOD=(long)1e9+7;

    //calculating nCR using pascal's triangle because factorial will cause long overflow
    private long pascal[][];
    private long nCr(int n, int r) { 
        return pascal[n][r];
    }
    
    private long util(List<Integer> arr) {
        if(arr.size()<=2) return 1;

        List<Integer> left=new ArrayList<>();
        List<Integer> right=new ArrayList<>();
        int root=arr.get(0);
        for(int child: arr) {
            if(child==root) continue;
            if(child<root) {
                left.add(child);
            }else {
                right.add(child);
            }
        }

        int x=left.size();
        int y=right.size();
        long combi=nCr(x+y, x)%MOD;
        long get=(util(left)*util(right))%MOD;
        long ret=(combi*get)%MOD;
        return ret;
    }
}