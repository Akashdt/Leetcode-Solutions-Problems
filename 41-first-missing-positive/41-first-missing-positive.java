class Solution
{
    public int firstMissingPositive(int[] v) 
    {
        Arrays.sort(v);
        int flag = 1;
        for (int i:v) 
        {
            if (flag == i) 
            {
                flag++;
            } 
        }
        return flag;
    }
}