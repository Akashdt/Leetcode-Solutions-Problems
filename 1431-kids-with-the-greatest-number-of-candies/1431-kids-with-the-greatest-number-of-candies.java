class Solution {
    public ArrayList<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        ArrayList<Boolean> list = new ArrayList<>();
        int ans = candies[0];
        for(int i=1;i<candies.length;i++){
            if(candies[i]>ans){
                ans = candies[i];
            }
        } 
        
        for(int i=0;i<candies.length;i++){
            if(candies[i]+extraCandies>=ans){
                list.add(true);
            }else{
                list.add(false);
            }
        }
        return list;
    }
}