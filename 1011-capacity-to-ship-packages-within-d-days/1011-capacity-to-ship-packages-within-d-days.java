class Solution {
    public static boolean isPossible(int arr[],int days,int cap){
      int sum=0;
        int td=0;
        for(int i=0;i<=arr.length;i++)
        {
            if(i==arr.length)
            {
                td++;
                if(td>days)
                {
                    return false;
                }
            }
            else{

                if(arr[i]>cap){
                    return false;
                }
                sum+=(long)arr[i];
                if(sum>cap){
                    td++;
                    sum=arr[i];
                }
                if(td>days){
                    return false;
                }
            }
        }
        return true;
    }
    public int shipWithinDays(int[] weights, int days) {
        int min=1;
        int max=0;
        for(int i=0;i<weights.length;i++){
            max+=weights[i];
        }
        int ans=0;
        while(min<=max){
            int mid=min+((max-min)/2);
            if(isPossible(weights,days,mid)){
                max=mid-1;
                ans=mid;
            }
            else{
                min=mid+1;
            }
        }
        return ans;
    }
}