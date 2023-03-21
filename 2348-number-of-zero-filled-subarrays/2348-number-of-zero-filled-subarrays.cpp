class Solution {
public:
    long long zeroFilledSubarray(vector<int>& nums) {
        int d=0;
            long long res=0;
            while(d<nums.size())
            {
                    long long c=0;
                    if(nums[d]==0)
                    {
                            while(d<nums.size() && nums[d]==0){
                                    c++;
                                    d++;
                            }
                    }
                    else d++;
                    res+=solve(c);
            }
            return res;
    }
        long long solve(long long v)
        {
                return (v)*(v+1)/2ll;
        }
};