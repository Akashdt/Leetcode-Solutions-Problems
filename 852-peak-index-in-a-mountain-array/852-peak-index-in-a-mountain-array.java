class Solution {
    public int peakIndexInMountainArray(int[] arr) 
    {
        int low = 0;
    int end = arr.length - 1;
    
    while(low < end)
    {
        int mid = low + (end - low) / 2;
        if(arr[mid] > arr[mid + 1]) 
            end = mid;
        else 
            low = mid + 1;
    }
    return low;
    }
}