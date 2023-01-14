class Solution {

    class DisjointSet{
        int union[];

        DisjointSet(){
            union=new int[26];
            for(int i=0;i<26;i++){
                union[i]=i;
            }
        }

        public int find(int x){
            if(union[x]==x) return x;
            return find(union[x]);
        }

        private void unionfunc(int a,int b){
            int x=find(a);
            int y=find(b);
            if(x==y) return;
            if(x>y) union[x]=y;
            else union[y]=x;
        }


    }

    public String smallestEquivalentString(String s1, String s2, String baseStr) {

        DisjointSet ds=new DisjointSet();

        for(int i=0;i<s1.length();i++){
            ds.unionfunc(s1.charAt(i)-'a',s2.charAt(i)-'a');
        }

        String ans="";

        for(int i=0;i<baseStr.length();i++){
            String temp=""+(char)(ds.find(baseStr.charAt(i)-'a')+'a');
            ans+=temp;
        }
        
        return ans;


        
        

        
    }
}