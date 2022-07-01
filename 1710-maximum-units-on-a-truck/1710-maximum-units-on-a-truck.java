class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) 
    {
        if(boxTypes==null||boxTypes.length==0||truckSize==0)
return 0;

    int res=0;
            
    Arrays.sort(boxTypes,new Comparator<int[]>()
                {
        public int compare(int a[],int b[]){
            return b[1]-a[1];  
        }
    });
    
    for(int i=0;i<boxTypes.length;i++)
    {
        int box=boxTypes[i][0];
        int unit=boxTypes[i][1];
        if(box<=truckSize)
        {
            res+=box*unit;
            truckSize=truckSize-box;
        }
        else{
           res+=truckSize*unit;
            break;
        }
    }
    return res;
    }
}