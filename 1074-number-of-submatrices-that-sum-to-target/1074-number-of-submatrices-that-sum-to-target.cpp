class Solution {
public:
    int numSubmatrixSumTarget(vector<vector<int>>& matrix, int target) 
    {
        int ro=matrix.size(),co=matrix[0].size();
        
        if(ro<1)
                
            return 0;
        
        for(int r=0;r<ro;r++)
            for(int c=1;c<co;c++)
                    
                matrix[r][c]+=matrix[r][c-1];
        
        int count=0;
        for(int c1=0;c1<co;c1++)
                
        for(int c2=c1;c2<co;c2++)
        {
           
                
            unordered_map<int,int>mp;
                
            int sum=0;
           
                mp[0]=1;
                
            for(int r=0;r<ro;r++)
            {
                sum+=matrix[r][c2]-(c1>0?matrix[r][c1-1]:0);
                    
                    
                    int find=sum-target;   
                    
                if(mp.find(find)!=mp.end())
                        
                    count+=mp[find];
                    
                mp[sum]++;
            }
        }
        return count++;
    }
};