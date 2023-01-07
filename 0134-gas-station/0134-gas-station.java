class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int gassum=0,costsum=0;
        for (int i=0;i<gas.length;i++) {
            gassum+=gas[i];
            costsum+=cost[i];
        }
        int total=0;
        int start=0;
        if (gassum < costsum ) {return -1;}
        for (int i=0;i<gas.length;i++) {
            total+=(gas[i]-cost[i]);
            if (total<0) {
                total=0;
                start=i+1;
            }
        }
        return start;
    }
}