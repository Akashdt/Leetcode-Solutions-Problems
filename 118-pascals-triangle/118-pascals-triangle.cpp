class Solution {
public:
    vector<vector<int>> generate(int numRows) {
         
        vector<vector<int>> ans;
        
        ans.push_back({1});
        
        for(int i = 0; i < numRows-1; i++){
            
            vector<int> temp;
            temp = ans[i];
            temp.insert(temp.begin(), 0);
            temp.push_back(0);
            
            for(int j = 0; j < temp.size()-1; j++){
                temp[j] += temp[j+1];
            }
            temp.pop_back();
            ans.push_back(temp);
        }
     
        return ans;
    }
};