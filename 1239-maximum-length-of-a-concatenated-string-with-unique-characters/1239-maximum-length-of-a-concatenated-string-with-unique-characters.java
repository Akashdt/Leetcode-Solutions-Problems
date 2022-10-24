class Solution {
    public int maxLength(List<String> arr) {
        
        return solve(arr, "", 0);

        
    }

    int solve(List<String> arr, String ans, int i){
      
        if(i >= arr.size()){
            if(unique(ans)){
                return ans.length();
            } else{
                return 0;
            }
        }

        int take = solve(arr, ans+arr.get(i), i+1);
        int notTake = solve(arr, ans, i+1);
        

        return Math.max(take, notTake);
    }

    boolean unique(String str){
        HashSet<Character> set = new HashSet();
        for(char ch: str.toCharArray()){
            if(set.contains(ch)) return false;

            set.add(ch);
        }
        return true;
    }
}