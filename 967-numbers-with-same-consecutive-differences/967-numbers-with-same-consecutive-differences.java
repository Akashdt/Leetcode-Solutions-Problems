class Solution
{

    public int[] numsSameConsecDiff(int n, int k) 
    {
        HashSet<Integer> set = new HashSet<>(); 
            
        for (int i = 1; i <= 9; i++)
                
               dfs(n, k, "" + i, set);
            
        ArrayList<Integer> arr= new ArrayList<>(set);
            
        int[] result = new int[arr.size()];
            
        for (int i = 0; i < arr.size(); i++) 
                
                result[i] = arr.get(i);
        
            return result;
    }

    private void dfs(int n, int k, String number, HashSet<Integer> set) 
    {
        if (number.length() == n)
        {
            set.add(Integer.parseInt(number));
            return;
        }

        int previousDigit = number.charAt(number.length() - 1) - '0';
            
        if ((previousDigit + k) <= 9) 
                dfs(n, k, number + "" + (previousDigit + k), set);
        if ((previousDigit - k) >= 0) 
                dfs(n, k, number + "" + (previousDigit - k), set);
    }
}