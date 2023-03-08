class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low=1;
        int high=Integer.MIN_VALUE;
        for(int i=0;i<piles.length;i++){
            high=Math.max(high,piles[i]);
        }
        while(low<high){
            int mid=low+(high-low)/2;
            if(blackbox(mid,piles,h)){
                high=mid;
            }
            else
                low=mid+1;
        }
        return low;
    }
    public boolean blackbox(int k,int[] piles,int h){
        int hours=0;
        for(int i:piles){
            int time=i/k;
            hours+=time;
            if(i%k!=0) hours++;
        }
        if(hours<=h)
            return true;
        return false;
    }
}