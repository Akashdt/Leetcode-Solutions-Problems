class Solution {
    public double average(int[] salary) {
        Arrays.sort(salary);
        double n=salary.length;
        double sum=0;
        for(int i=1;i<n-1;i++)
        {
      sum+=salary[i];
        }
        double nums=n-2;
        double res=sum/nums;
        return res;
    }
}