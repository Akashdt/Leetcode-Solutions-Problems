class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {

           char []arr=answerKey.toCharArray();

           int n=arr.length;            
            int count1=0,count2=0;
                 int j=-1,m=-1;
                 int ans=0;
           for(int i=0;i<n;i++){

               char ch=arr[i];

               if(ch=='T'){
                   count1++;
               }

               else{
                   count2++;
               }

               while(count1>k){
                   j++;
                   if(arr[j]=='T'){
                       count1--;
                   }
               }

                while(count2>k){
                   m++;
                   if(arr[m]=='F'){
                       count2--;
                   }
               }

           ans=Math.max(ans,i-j);
           ans=Math.max(ans,i-m);


           }

return ans;

        
    }
}