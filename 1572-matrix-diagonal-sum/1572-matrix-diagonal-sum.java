class Solution {
    public int diagonalSum(int[][] mat) {
        int n = mat.length;
        int a=0, b=0, c=0, d=n-1;
        int s=0;
        for(int i=0;i<n;i++){
            s = s + mat[a][b] + mat[c][d];
            a++;
            b++;
            c++;
            d--; 
        }
        if(n%2==1){
            s -= mat[n/2][n/2];
        }
        return s;
    }
}