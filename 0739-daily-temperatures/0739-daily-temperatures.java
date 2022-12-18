class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
          if (temperatures == null) {
            throw new IllegalArgumentException("Input array is null");
        }

        int len = temperatures.length;
        int[] result = new int[len];
        if (len <= 1) {
            return result;
        }

        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                int idx = stack.pop();
                result[idx] = i - idx;
            }
            stack.push(i);
        }

        return result;
    }
}
   