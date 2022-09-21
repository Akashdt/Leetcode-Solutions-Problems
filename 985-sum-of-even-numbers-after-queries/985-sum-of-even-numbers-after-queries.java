class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
          ArrayList<Integer> al=new ArrayList<>();
        int even=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]%2==0)even=even+nums[i];
        }
        for(int i=0;i<queries.length;i++){
            int sum=nums[queries[i][1]]+queries[i][0];
            if(sum%2==0){
                if(nums[queries[i][1]]%2==0)
                    even=even-nums[queries[i][1]]+sum;
                else
                    even=even+sum;
            }
            else
            {
                if(nums[queries[i][1]]%2==0)
                    even=even-nums[queries[i][1]];
                
            }
            nums[queries[i][1]]=sum;
            al.add(even);
            
        }
        int[] result=new int[al.size()];
        for(int i=0;i<al.size();i++){
            result[i]=al.get(i);
        }
        return result;
    }
    }

