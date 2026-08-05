class Solution {

    List<Integer>[] graph;
    boolean[] suspicious;

    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {

        graph = new ArrayList[n];
        suspicious = new boolean[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        // Build graph
        for (int[] edge : invocations) {
            graph[edge[0]].add(edge[1]);
        }

        // Mark suspicious methods
        dfs(k);

        // Check if any outside method calls a suspicious method
        for (int[] edge : invocations) {
            int u = edge[0];
            int v = edge[1];

            if (!suspicious[u] && suspicious[v]) {
                List<Integer> ans = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    ans.add(i);
                }
                return ans;
            }
        }

        // Return remaining methods
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (!suspicious[i]) {
                ans.add(i);
            }
        }

        return ans;
    }

    private void dfs(int node) {
        suspicious[node] = true;

        for (int next : graph[node]) {
            if (!suspicious[next]) {
                dfs(next);
            }
        }
    }
}
