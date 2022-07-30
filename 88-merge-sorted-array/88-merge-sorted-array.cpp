class Solution {
public:
    void merge(vector<int>& nums1, int m, vector<int>& nums2, int n) {
        int i,j,k;

    for(i=m;i<m+n;i++)
    {
      if(nums1[i]==0)
          break;
    }
    for(j=0;j<n;j++,i++)
        {
    nums1[i]=nums2[j];
         }
    sort(nums1.begin(), nums1.end());
    }
};