/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    map<int, vector<vector<int>> >m;
    
    void inorder(TreeNode *root,int i,int j)
    {
        if(root==NULL)return;
            
        vector<int>a={i,root->val};
            m[j].push_back(a);
           inorder(root->left,i+1,j-1);
            
           inorder(root->right,i+1,j+1);
        
    }
    vector<vector<int>> verticalTraversal(TreeNode* root) {
     vector<vector<int>> ans;   
        
        
        inorder(root,0,0);
        for(auto it=m.begin();it!=m.end();it++)
        {
            vector<int>a;
            sort(it->second.begin(),it->second.end());
            for(auto x :it->second)
            {
               a.push_back(x[1]);
            }
             ans.push_back(a);
        }
        
        
        return ans;
    }
};