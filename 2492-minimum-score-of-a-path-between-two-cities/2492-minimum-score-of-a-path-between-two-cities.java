class Solution {
    
    class node{
        int data;
        int weight;
        public node(int data,int w){
            this.data=data;
            this.weight=w;
        }
    }

    public int minScore(int n, int[][] roads) {
    
        Map<Integer,List<node>> adj=new HashMap<>();

        for(int i=1;i<=n;i++) adj.putIfAbsent(i,new ArrayList<node>());

        for(int[] edge:roads) {
            int src=edge[0];int dest=edge[1];int w=edge[2];
            adj.get(src).add(new node(dest,w));
            adj.get(dest).add(new node(src,w));
        }


        Queue<Integer> q=new LinkedList<>();

        //Add the starting vertex
        q.add(1);

        //to check already visited nodes
        Set<Integer> vis=new HashSet<>();

        //store wheather dest is reached or not
        boolean destFound=false;

        int result=Integer.MAX_VALUE;
        while(!q.isEmpty() && vis.size()<n){
            int cur=q.poll();
            if(cur==n ) destFound=true;
            if(destFound && vis.size()==n) return result;
            if(!vis.contains(cur)){
                vis.add(cur);
                for(node Node:adj.get(cur)){
                    q.add(Node.data);
                    result=Math.min(result,Node.weight);
                }
            }
        }
        return result;
    }
}