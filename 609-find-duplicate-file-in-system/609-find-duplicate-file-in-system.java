class Solution {
    public List<List<String>> findDuplicate(String[] strs) {
         Map<String,List<String>> maper = new HashMap<>();
        for(String path:strs) {
           
            String[] slices = path.split(" ");
            String filepath = slices[0];
            
            for(int i=1;i<slices.length;i++) {
              
                String[] parts = slices[i].split("\\(");
                String key = parts[1].substring(0,parts[1].length()-1);
    
                if(maper.containsKey(key)) {
                    maper.get(key).add(filepath+"/"+parts[0]);
                } else {
                    List<String> temp = new ArrayList<>();
                    temp.add(filepath+"/"+parts[0]);
                    maper.put(key,temp);
                }
                
            }
        }
        
        List<List<String>> result = new ArrayList<>();
        for(Map.Entry<String,List<String>> entry:maper.entrySet()) {
            List<String> temp = entry.getValue();
            if(temp.size()>1)
            result.add(temp);
        }
        return result;
    }
}