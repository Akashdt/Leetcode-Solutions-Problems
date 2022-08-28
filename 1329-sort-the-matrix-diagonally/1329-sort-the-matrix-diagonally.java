class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int[][] res = new int[mat.length][mat[0].length];
        int i = 0;
        int j = 0;
        while (i <= mat.length-1) {
            sort(i,j,mat,res);
            i++;        
        }
        i = 0;
        j = i+1;
        while (j <= mat[0].length-1) {
            sort(i,j,mat,res);
            j++;            
        }
        return res;
    }
    
    public void sort(int m , int n , int[][] mat, int[][] res) {
        
        List<Integer> list = new ArrayList<>();
        int i = m;
        int j = n;
        while (i < mat.length && j < mat[0].length) {
            list.add(mat[i][j]);
            i++;
            j++;
        }
        Collections.sort(list);
        int c = 0;
        while (m < mat.length && n < mat[0].length) {
            res[m][n] = list.get(c++);
            m++;
            n++;
        }
    }
}