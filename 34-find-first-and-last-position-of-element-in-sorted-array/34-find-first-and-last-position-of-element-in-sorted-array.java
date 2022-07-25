class Solution {
    public int[] searchRange(int[] nums, int target) 
    {
        int l=nums.length; 
         int res[]= {-1,-1};
  
  //finding first 
  int lo=0,hi=l-1;
  while(lo<=hi)
  {
    int mid=(lo+hi)/2;
    if(nums[mid]==target)
    {
      if(mid==0 || nums[mid]!=nums[mid-1])
      {
        res[0]=mid;
        break;
      }
      else hi=mid-1;
    }
    else if(nums[mid]<target)
    {
      lo=mid+1;
    }
    else hi=mid-1;
  }
  
 
  lo=0;
  hi=l-1;
  while(lo<=hi)
  {
    int mid=(lo+hi)/2;
    if(nums[mid]==target)
    {
      if(mid==l-1 || nums[mid]!=nums[mid+1])
      {
        res[1]=mid;
        break;
      }
      else lo=mid+1;
    }
    else if(nums[mid]<target)
    {
      lo=mid+1;
    }
    else hi=mid-1;
  }
  return res;
}
    }
