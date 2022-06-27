class Solution {
    public int minPartitions(String n) 
    {
            //suppose u take string n="2463"
            //So in first step u  minus 1111
            //second step u minus 1111 again from result 1352
            //in 3rd step u minus 111 again from 241
            //4th step u minus 11 from result 13
            //in 5th step u minus 1 from 2
            //in 6th step u have 1 remaining so minus 1
            //so it stands that u need to find the max digit to find the number of steps
        int max=0;
            
        for(int i=0;i<n.length();i++)
        {
            int c= n.charAt(i)-'0';
                
            max=  Math.max(max,c);
        }
        return max;
    }
}