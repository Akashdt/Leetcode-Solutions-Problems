class Solution
{
    public:
        bool reorderedPowerOf2(int n)
        {
            if (n == 1)
                return true;
            string num = to_string(n);
                
            sort(num.begin(), num.end());
            int pow = 1;
                
            for (int i = 1; i < 31; i++)
            {
                        pow = pow * 2;
                        string s = to_string(pow);
                        sort(s.begin(), s.end());
                        if (s == num)
                            return true;
                    }
            return false;
        }
};