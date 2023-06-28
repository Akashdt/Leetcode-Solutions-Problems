class Solution {
    public double maxProbability(int n, int[][] edges, double[] p, int start, int end) {
        
        List<List<Node>> al = new ArrayList<>();
       
        for(int i=0;i<=n;i++) al.add(new ArrayList<>());
        
        for(int i=0;i<edges.length;i++)
        {
            int u = edges[i][0],v = edges[i][1];
            al.get(u).add(new Node(v,p[i]));
            al.get(v).add(new Node(u,p[i]));
        }

        double ans = 0;
        double vis[] = new double[n];

        
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(start,1.0));
        vis[start] = 1.0;

        while(!q.isEmpty())
        {
           
            Node temp = q.poll();
            int i = temp.f;
            double val = temp.s;

            for(Node j : al.get(i))
            {
             
                if(vis[j.f]>=vis[i]*j.s) continue;
                
            
                vis[j.f] = vis[i]*j.s;
                q.add(new Node(j.f,j.s*val));
            }
        }


        return vis[end];
    }
}

class Node
{
    int f;
    double s;
    Node(int f,double s)
    {
        this.f = f;
        this.s = s;
    }
}