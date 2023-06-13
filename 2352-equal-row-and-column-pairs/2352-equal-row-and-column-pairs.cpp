class Solution {
public:
    int equalPairs(vector<vector<int>>& grid) {
         vector<vector<int>>b;
            for(int j=0;j<grid[0].size();j++)
            {
                    vector<int> s;
                    for(int i=0;i<grid.size();i++)
                    {
                            s.push_back(grid[i][j]);
                    }
                    b.push_back(s);
            }
            int p=0;
             for(int i=0;i<grid.size();i++)
                    {
                      for(int j=0;j<b.size();j++)
            {
                              if(grid[i]==b[j]){
                                      p++;
                              }
                      }
             }
            return p;
    }
};