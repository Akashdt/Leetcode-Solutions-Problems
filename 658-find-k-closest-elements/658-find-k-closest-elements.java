class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int low =  0;
        
        int high = arr.length-1;
        
        while(low<=high){
            
            int mid = (low+high)/2;
            
            if(arr[mid]<x){
                
                low = mid +1;
                
            }
            else if(arr[mid]== x){
                
                low = mid;
                
                break;
            }
            else {
                
                high = mid - 1;
            }
        }
       
        ArrayList<Integer> result = new ArrayList<>();
        
        int i = low;
        
        int j = low-1;
        
        while( j>=0 && i<=arr.length-1 && k-->0){
            
            int diff1 = Math.abs(arr[i]-x);
            
            int diff2 = Math.abs(arr[j]-x);
            
            if(diff1>=diff2){
                
                result.add(arr[j]);
                
                j--;
            }
            else{
                
                result.add(arr[i]);
                
                i++;
            }
        }
        while(j>=0  && k-->0){
            
            result.add(arr[j]);
            
            j--;
        }
        while( i<=arr.length-1 && k--> 0 ){
            
            result.add(arr[i]);
            
            i++;
        }
        
        Collections.sort(result);
        
        return result;
        
    }
}