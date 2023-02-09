class Solution {
    public long distinctNames(String[] ideas) {         
        Map<Character,Set<String>> map = new HashMap<>();
        
        for(String s:ideas){
            String str = s.substring(1);
            char ch = s.charAt(0);

            if(!map.containsKey(ch))
                map.put(ch,new HashSet<>());

            Set<String>st = map.get(ch);
            st.add(str);
            map.put(ch,st);   
        }
    

    long ans = 0;
        
        for(int i=97 ; i<=122 ; i++){
            char ch1 = (char)(i);    
            
            if(!map.containsKey(ch1)) continue;
       
            Set<String>set1 = map.get(ch1);
            
            for(int j=97 ; j<=122 ; j++){
                char ch2 = (char)(j); 
     
                if(!map.containsKey(ch2)) continue;
                
           
                Set<String>set2 = map.get(ch2);
                
                
                if(set1 == set2) continue;
 
              
                int similar = 0; 
                for(String str:set2){
                    if(set1.contains(str))
                    similar++;
                }

                ans += (set1.size()-similar)*(set2.size()-similar); 
            }               
        } 
       
        return ans;
    } 
}