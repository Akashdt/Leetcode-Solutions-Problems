class Solution {
    public boolean buddyStrings(String s, String goal) {
        if(s.length()!=goal.length()){
            return false;
        }
        if(s.equals(goal)){
            HashMap<Character,Integer>map=new HashMap<>();
            for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
                if(map.get(s.charAt(i))>1){
                    return true;
                }
            }
            return false;
        }
        int si=-1;
        int sj=-1;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!= goal.charAt(i) && si==-1){
                si=i;
            }
            else if(s.charAt(i)!= goal.charAt(i) && sj==-1){
                sj=i;
            }
            else if(s.charAt(i)!= goal.charAt(i) && si!=-1 && sj!=-1){
                return false;
            }
        }
        if(si==-1 || sj==-1){
            return false;
        }
        if(s.charAt(si)==goal.charAt(sj) && s.charAt(sj)==goal.charAt(si)){
            return true;
        }
        return false;

    }
}