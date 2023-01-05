class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a,b) -> Integer.compare(a[1],b[1]));       
        int count= 1;
        
        for(int i=1;i<points.length;i++){
            int temp= points[i][0];
            if(temp > points[i-1][1])
                count++;
            else{                                                        
                points[i][0]= temp;
                points[i][1]= points[i-1][1];
            }
        }
        return count;
    }
}