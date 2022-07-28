class Solution {
    public boolean wordPattern(String pattern, String s) 
    {
        String[] strArray = s.split(" ");
            
        if(strArray.length!= pattern.length())
           
                return false;
            
        if(pattern == null || pattern.length() <= 1) 
                
                return true;
            
        HashMap<Character, String> map = new HashMap<Character, String>();
            
        for(int i = 0 ; i< pattern.length(); i++)
        {
            char a = pattern.charAt(i);
            String b = strArray[i];
            if(map.containsKey(a))
            {
                 if(map.get(a).equals(b))
               
                         continue;
                else
               
                        return false;
            }
                else
                {
                if(!map.containsValue(b))
                        
                map.put(a,b);
               
                        else 
                                
                        return false;
                
            }
        }
        return true; 
    }
}