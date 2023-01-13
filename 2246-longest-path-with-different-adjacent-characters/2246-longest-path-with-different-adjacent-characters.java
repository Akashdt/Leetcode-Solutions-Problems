class Solution {
    static int[] dfs(int idx, int[] parent, String s, List<List<Integer>> adjList, int[] visited, int currLength, int maxLength) {
        if (visited[idx] == 1) return new int[]{currLength, maxLength};

        visited[idx] = 1;

        if (adjList.get(idx).size() == 0) {
            int p = parent[idx];
            if (p == -1) {
                maxLength = Math.max(maxLength, 1);
                return new int[]{1, maxLength};
            }
            char pChar = s.charAt(p);
            char cChar = s.charAt(idx);

            if (cChar == pChar) {
                maxLength = Math.max(maxLength, 1);
                return new int[]{1, maxLength};
            } else {
                currLength += 1;
                maxLength = Math.max(maxLength, currLength);
                return new int[]{currLength, maxLength};
            }
        }


        int[] temp = new int[adjList.get(idx).size()];
        int k = 0;
        for (int i = 0; i < adjList.get(idx).size(); i++) {
            int nextIdx = adjList.get(idx).get(i);

            if (nextIdx != -1 && visited[nextIdx] == 0) {
                int[] t = dfs(nextIdx, parent, s, adjList, visited, currLength, maxLength);
                if (s.charAt(nextIdx) == s.charAt(idx))
                    t[0] = 0;
                temp[k++] = t[0];
                maxLength = Math.max(maxLength, t[1]);
            }
        }
        Arrays.sort(temp);
        if (temp.length > 1) {
            currLength = temp[temp.length - 1] + temp[temp.length - 2] + 1;
            maxLength = Math.max(maxLength, currLength);
            currLength = temp[temp.length - 1] + 1;

        } else {
            currLength = temp[temp.length - 1] + 1;
        }

        maxLength = Math.max(maxLength, currLength);


        return new int[]{currLength, maxLength};
    }

    public int longestPath(int[] parent, String s) {

        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < parent.length; i++) {

            if (parent[i] != -1) {
                adjList.get(parent[i]).add(i);
            }
        }
        int[] visited = new int[s.length()];
        int[] ans = dfs(0, parent, s, adjList, visited, 0, 0);

        return ans[1];

    }
}