class Solution {
    public String predictPartyVictory(String senate) {
        char arr[]=senate.toCharArray();
        int i=0;
        while(true){
           int j=(i+1)%arr.length;
           if(arr[i]!='X'){
            while(j!=i){
              if(arr[i]!=arr[j] && arr[j]!='X'){
                  arr[j]='X'; break;
              }
              j=(j+1)%arr.length;
            }
            if(i==j){ break;}
           }
            i=(i+1)%arr.length;

        }
        if(arr[i]=='R'){ return "Radiant";}

        return "Dire";
    }
}
