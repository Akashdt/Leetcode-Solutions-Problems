class Solution {
    public int maxScore(int[] nums) {
        int state = 0;
        Map<Integer, Integer> cache = new HashMap<>();
        return dfs(state, nums, cache, 1);
    }
    int dfs(int state, int[] nums, Map<Integer, Integer> cache, int times) {
        if (cache.containsKey(state)) {
            return cache.get(state);
        }
        int max = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if((1<<i & state)!=0 || (1<<j & state)!=0)
                    continue;

                // store value so it can be restored for next value in the loop
                int tempState = state;
                state = state | 1<<i | 1<<j;
                int score = times * gcd(nums[j], nums[i]);
                max = Math.max(max, score + dfs(state, nums, cache, times+1));
                state = tempState;
            }
        }
        cache.put(state, max);
        return max;
    }
    int gcd(int n1, int n2) {
        if (n2 == 0) {
            return n1;
        }
        return gcd(n2, n1 % n2);
    }
}