class Solution {
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) return false;
        Queue<NodeNum> queue = new LinkedList<>();
        queue.offer(new NodeNum(root, 1));
        int expected = 1;
        while(!queue.isEmpty()) {
            int len = queue.size();


            for (int i = 0; i < len; i++) {
                NodeNum nodenum = queue.poll();
                TreeNode node = nodenum.node;
                if (nodenum.num != expected) {
                    return false;
                }
                expected++;
                if (node.left != null)  queue.offer(new NodeNum(node.left, nodenum.num * 2));
                if (node.right != null) queue.offer(new NodeNum(node.right, nodenum.num * 2 + 1));
            }
            
        }  

        return true;

    }
}

class NodeNum {
    TreeNode node;
    int num;
    public NodeNum(TreeNode node, int num) {
        this.node = node;
        this.num = num;
    }
}