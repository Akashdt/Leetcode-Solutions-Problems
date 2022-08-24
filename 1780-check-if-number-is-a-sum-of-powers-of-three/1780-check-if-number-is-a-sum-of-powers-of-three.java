class Solution {
    public boolean checkPowersOfThree(int n) {
        int rem = 0;
        while(n > 0)
        {
            rem = n % 3;
            if(rem == 2)
                return false;
            n /= 3;
        }
        return true;
    }
}