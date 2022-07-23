class Solution {
    public List<Integer> countSmaller(int[] nums) {
       List<Integer> counts = new ArrayList<Integer>(nums.length);

        List<int[]> arr = new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            arr.add(new int[]{nums[i], i});
            counts.add(0);
        }
        
        mergeSort(arr, 0, nums.length-1, counts);
        
        return counts;
    }
    
    private void mergeSort(List<int[]> arr, int start, int end,
                           List<Integer> counts){
        if(start < end){
            int mid = (int)Math.floor((start+end)/2.0);
                mergeSort(arr, start, mid, counts);
                mergeSort(arr, mid+1, end, counts);
                mergeCount(arr, start, mid, end, counts);
        }
    }
    
    private void mergeCount(List<int[]> arr, int start, int mid, int end,
                             List<Integer> counts){
      
        List<int[]> temp = new ArrayList<>(end-start+1);
        for(int i=0; i<(end-start+1); i++){
            temp.add(new int[]{0,0});
        }
        int i=start;
        int j = mid+1;
        int k =0;
        
        while(i <= mid && j <= end){
            
            if(arr.get(i)[0] > arr.get(j)[0]){
               
                int count = counts.get(arr.get(i)[1]);
                counts.set(arr.get(i)[1], count+(end-j+1));
                temp.set(k, arr.get(i));
                k++;
                i++;
            }
                else
            {
                temp.set(k, arr.get(j));
                j++;
                k++;
            }
        }
       
        while(i <= mid)
        {
            temp.set(k, arr.get(i));
            i++;
            k++;
        }
        
        while(j <= end)
        {
            temp.set(k, arr.get(j));
            j++;
            k++;
        }
        i = start;
      
        for(int l=0; l<temp.size(); l++){
            arr.set(i, temp.get(l));
            i++;
        } 
    }
}

