class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        int[][] projects = new int[n][2];
        for (int i = 0; i < n; i++) {
            projects[i][0] = profits[i];
            projects[i][1] = capital[i];
        }
        Arrays.sort(projects, Comparator.comparingInt(o -> o[1]));
        int cur = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        while (k-- > 0) {
            while (cur < n && projects[cur][1] <= w) {
                pq.add(projects[cur++][0]);
            }
            if (pq.isEmpty()) {
                return w;
            }
            int maxProfit = pq.poll();
            w += maxProfit;
        }
        return w;
    }
}