/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution
{

    public List<List<Integer>> levelOrder(Node root)
    {
        List<List<Integer>> ans = new ArrayList<>();
         List<Integer> levelAns = new ArrayList<>();
            if (root == null)
                    
                    return ans;

        Queue<Node> q = new LinkedList<>();
        Node temp = null;
        int n = 0;
        q.add(root);

        while (!q.isEmpty()) 
        {
            n = q.size();
            levelAns = new ArrayList<>();
            for (int i = 0; i < n; i++)
            {
                temp = q.poll();
                levelAns.add(temp.val);
                    
                for (int j = 0; j < temp.children.size(); j++) 
                {
                    q.add(temp.children.get(j));
                }
            }
            ans.add(levelAns);
        }
        return ans;
    }
}
