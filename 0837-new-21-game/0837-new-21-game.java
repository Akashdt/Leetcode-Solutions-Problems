class Solution {
    public double new21Game(int n, int k, int maxPts) {
        double[] p = new double[n + 1];
        double factor = 1.0 / maxPts;
        p[0] = 1.0;
        double sum = 0.0;
        for (int i = 0; i < n; i++) {
            if (i < k) sum += p[i] * factor;
            if (i >= maxPts && i - maxPts < k) sum -= p[i - maxPts] * factor;
            p[i + 1] = sum;
        }
        double P = 0.0;
        for (int i = k; i <= n; i++) P += p[i];
        return P;
    }
}