class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] Re, int[][] Be) {
        int[] R=new int[n], B=new int[n]; int nnn=n*n*n;
        Arrays.fill(R,nnn);  Arrays.fill(B,nnn); B[0]=0; R[0]=0;
        boolean cn=true;

        while(cn) {
            cn=false;
            for (int[] r:Re) {
                if (B[r[0]]+1<R[r[1]]) {R[r[1]]=B[r[0]]+1; cn=true;}
            }
            for (int[] b:Be) {
                if (R[b[0]]+1<B[b[1]]) {B[b[1]]=R[b[0]]+1; cn=true;}
            }
        }

        int res[]=new int[n];
        for (int i=0; i<n; ++i) {
            if (R[i]==nnn && B[i]==nnn) res[i]=-1;
            else res[i]=Math.min(R[i],B[i]);
        }

        return res;
    }
}