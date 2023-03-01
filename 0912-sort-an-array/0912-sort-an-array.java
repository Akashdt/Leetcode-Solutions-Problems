class Solution {
    public int[] sortArray(int[] nums) {
        //merge sort
        sort(nums, 0, nums.length - 1);
        return nums;
    }
    public void sort(int[] nums, int start, int end){
        if(start == end){
            return;
        }
        int mid = start + (end - start)/2;
        sort(nums, start, mid);
        sort(nums, mid + 1, end);
        merge(nums, start, mid, end);
    }
    public void merge(int[] arr, int start, int mid, int end){
        //array arr is sorted from start -> mid and mid + 1 -> end
        int i = start;
        int j = mid + 1;
        int[] res = new int[end - start + 1];
        int k =0;
        while(i <= mid && j <= end){
            if(arr[i] > arr[j]){
                res[k] = arr[j];
                j++;
                k++;
            }else{
                res[k] = arr[i];
                i++;
                k++;
            }
        }
        while(i <= mid){
            res[k] = arr[i];
            i++;
            k++;
        }
        while(j <= end){
            res[k] = arr[j];
            j++;
            k++;
        }
        for(int l = 0;l < res.length;l++){
            arr[l + start] = res[l];
        }
    }
}