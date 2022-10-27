class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;

        int result = 0;

        for (int i=0;i<n;i++) {
            for (int j=0;j<n;j++) {
                int curr = 0;
                for (int a=i;a<n;a++) {
                    for (int b=j;b<n;b++) {
                        if (img2[a][b] == img1[a-i][b-j])
                            curr += img2[a][b];
                    }
                }
                result = Math.max(result, curr);
            }
        }

        for (int i=0;i<n;i++) {
            for (int j=0;j<n;j++) {
                int curr = 0;
                for (int a=i;a<n;a++) {
                    for (int b=j;b<n;b++) {
                        if (img2[a-i][b] == img1[a][b-j])
                            curr += img2[a-i][b];
                    }
                }
                result = Math.max(result, curr);
            }
        }

        for (int i=0;i<n;i++) {
            for (int j=0;j<n;j++) {
                int curr = 0;
                for (int a=i;a<n;a++) {
                    for (int b=j;b<n;b++) {
                        if (img1[a-i][b] == img2[a][b-j])
                            curr += img1[a-i][b];
                    }
                }
                result = Math.max(result, curr);
            }
        }
        return result;
    }
}