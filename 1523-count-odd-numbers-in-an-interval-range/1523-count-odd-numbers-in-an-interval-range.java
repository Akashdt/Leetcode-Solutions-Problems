class Solution {
    public int countOdds(int low, int high) {
         int extra;
        if(low%2!=0 || high%2!=0)   
            extra= 1;
        else                      
            extra= 0;

        return (high - low)/2 + extra;
    }
}