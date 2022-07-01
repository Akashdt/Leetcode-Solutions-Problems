class Solution {
    public void rotate(int[][] matrix) 
    {
            for(int i = 0; i<matrix.length; i++)
            {
            for(int j = i; j<matrix[0].length; j++)
            {
                int temp = 0;
                temp = matrix[i][j];
                    
                matrix[i][j] = matrix[j][i];//reverse row and columns
                    
                matrix[j][i] = temp;
                    //here we get the transpose of the matrix using a temp variable
            }
        }
        for(int i =0 ; i<matrix.length; i++)
        {
            for(int j = 0; j<matrix.length/2; j++)//here using two pointers we have to just reverse the row
            {
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length-1-j];//reversing each row
                matrix[i][matrix.length-1-j] = temp;
            }
        }
    }
}