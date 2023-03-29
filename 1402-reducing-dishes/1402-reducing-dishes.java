class Solution {
    public int maxSatisfaction(int[] s) {
    Arrays.sort(s);
    int i=s.length-1;
    int max=0, test=0, total=0;
    while(i>-1){
        total+=s[i];
        test+=total;
        if(test<max) return max;
        max=test; i--;
    }
    return max;
}
}