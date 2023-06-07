class Solution {
    public int minFlips(int a, int b, int c) {
        int ans = 0, ord = a | b;
        if (ord != c) {
            for (int i = 0; i < 32; i++) {
                int mask = 1 << i, bitOrd = mask & ord, bitC = mask & c;
                if (bitOrd != bitC) {
                    if (bitOrd != 0) {
                        if ((mask & a) != 0) ans++;
                        if ((mask & b) != 0) ans++;
                    } else {
                        ans++; // just need to flip one bit to make it 1
                    }
                }
            }
        }
        return ans;
    }
}