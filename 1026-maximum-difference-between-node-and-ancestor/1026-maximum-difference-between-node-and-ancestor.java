class Solution {
    int max = 0 ;
    int currentNodeNum = 1;
    HashMap<Integer, Integer[]> dp = new HashMap<Integer,Integer[]>();
    private Integer[] calcMaxMin(TreeNode root, int nodeNum){
        Integer[] mxmn = new Integer[]{root.val,root.val};
        if(root.left != null){
            Integer[] mxmnl = calcMaxMin(root.left,++currentNodeNum);
            mxmn[0] = Math.min(mxmnl[0],root.val);
            mxmn[1] = Math.max(mxmnl[1],root.val);
        }
        if(root.right != null){
            Integer[] mxmnr = calcMaxMin(root.right,++currentNodeNum);
            mxmn[0] = Math.min(mxmnr[0],mxmn[0]);
            mxmn[1] = Math.max(mxmnr[1],mxmn[1]);
        }
        dp.put(nodeNum,mxmn);
        return mxmn;
    }
    public int maxAncestorDiff(TreeNode root) {
        calcMaxMin(root,currentNodeNum);
        currentNodeNum = 1;
        return maxAncestorDiff(root,currentNodeNum);
    }
    public int maxAncestorDiff(TreeNode root, int nodeNum) {
       if(root != null){
            
            Integer[] mxmn = dp.get(nodeNum);
            max = Math.max(max, Math.max(Math.abs(root.val - mxmn[0]),Math.abs(root.val - mxmn[1])));
            if(root.left != null){
                maxAncestorDiff(root.left,  ++currentNodeNum);
            }
            if(root.right != null){
                maxAncestorDiff(root.right, ++currentNodeNum);
            }
        }
       return max;
    }
}