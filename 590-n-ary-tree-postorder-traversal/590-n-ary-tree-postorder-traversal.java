
class Solution 
{
      public List<Integer> postorder(Node root)
      {
		List<Integer> result = new ArrayList<>();
              
		postOr(root, result);
		return result;
	}
    
    void postOr(Node root, List<Integer> result) 
    {
		if (root == null)
			return;
		if (root.children != null)
                {
			for (Node child : root.children)
				postOr(child, result);
		}
		result.add(root.val);     
        
    }
}