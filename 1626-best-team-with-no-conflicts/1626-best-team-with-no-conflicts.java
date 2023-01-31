class Solution {
    public int bestTeamScore(int[] scores, int[] ages) {
        ArrayList al=new ArrayList();  
        for(int i=0;i<scores.length;i++)
            al.add(new Player(scores[i],ages[i]));
        Collections.sort(al,new PlayerComparator());
        for(int i=0;i<scores.length;i++){
            Player a=(Player)al.get(i);
            ages[i]=a.age;
            scores[i]=a.score;
        }
        int n=scores.length;
         int[] dp = new int[n];
        dp[0] = scores[0];

       
        for (int i=1; i<n; ++i){
            int max = scores[i];
            for(int j=0; j<i; j++){
                if(scores[i]>=scores[j]){
                    max = Math.max(max, scores[i]+dp[j]);
                }
            }
            dp[i]=max;
        }
        int res=0;
        for(int localMax : dp){
            res=localMax>res?localMax:res;
        }
        return res;
    }

}

class PlayerComparator implements Comparator{
    public int compare(Object o1,Object o2){  
        Player s1=(Player)o1;  
        Player s2=(Player)o2;  
  
        if(s1.age==s2.age){
            if(s1.score>s2.score)
                return 1;
            else
                return -1;
        } 
        else if(s1.age>s2.age)  
            return 1;  
        else  
            return -1;  
    }  
}

class Player{  
    int score;   
    int age;  
    Player(int score,int age){   
        this.score=score;  
        this.age=age;  
    }  
}  