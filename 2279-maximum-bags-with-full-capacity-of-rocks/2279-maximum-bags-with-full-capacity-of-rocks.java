class Solution 
{
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) 
    {
        ArrayList<Integer> list = new ArrayList<>();

        for(int i = 0; i < capacity.length; i++)
        {
            list.add(Math.abs(capacity[i] - rocks[i]));
        }

        Collections.sort(list);

        int count = 0;

        for(int num : list)
        {
            System.out.println(count);

            if(additionalRocks == 0)
            {
                return count;
            }

            if(num == 0)
            {
                count++;
            }

            else
            {
                if(num > additionalRocks)
                {
                    additionalRocks = 0;
                }

                else
                {
                    additionalRocks -= num;
                    count++;
                }

            }
        }

        return count;
    }
}