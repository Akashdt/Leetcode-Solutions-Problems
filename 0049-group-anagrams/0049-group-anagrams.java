class Solution {
    public List<List<String>> groupAnagrams(String[] strs)
    {
         List<List<String>> result =new ArrayList<>();
            
        HashMap<String,List<String>> map=new HashMap<>();
		
        for(int i=0;i<strs.length;i++)
        {
            String s=sortStr(strs[i]);
                
            if(!map.containsKey(s))
            {
                map.put(s,new ArrayList<String>()); 
                    
            }
            map.get(s).add(strs[i]);
        }
        for(List<String> list : map.values())
        {
            result.add(list);
        }
        return result;
    }
    public String sortStr(String s)
    {
        char c[]=s.toCharArray();
            
            
        Arrays.sort(c);
            
        String s1=new String(c);
            
        return s1;
    }
}