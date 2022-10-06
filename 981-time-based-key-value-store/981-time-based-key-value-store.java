class TimeMap {
    
    
    class Pair{
        
        int time ;
        
        String value ;
        
        public Pair(int time , String value){
            
            this.time = time;
            this.value = value;
        }
    }
    
    
    
    HashMap<String,ArrayList<Pair>> map;
    
    public TimeMap() 
    {
        
        map = new HashMap<>();
        
    }
    
    public void set(String key, String value, int timestamp) {
        
        map.putIfAbsent(key,new ArrayList<>());
        
        map.get(key).add(new Pair(timestamp,value));
    }
    
    public String get(String key, int timestamp) {
        
        ArrayList<Pair> list = map.get(key);
        
        if(list == null) return "";
        
        int low = 0 , high = list.size()-1;
        
        String ans = "";
        
        while(low<=high){
            
            int mid = ( low + high )/2;
                    
            if(list.get(mid).time<=timestamp)
            {
                
                ans = list.get(mid).value;
                
                low = mid + 1;
            }
            else
                high = mid - 1;
            
        }
        
        return ans;
        
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */