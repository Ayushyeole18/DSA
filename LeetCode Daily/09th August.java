class Solution {

    int n;
    int[] suffix;
    int[][] dp;

    public int stoneGameII(int[] piles) {

        n = piles.length;

        // Suffix sum
        suffix = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            suffix[i] = suffix[i + 1] + piles[i];
        }

        dp = new int[n][n + 1];

        // -1 means not calculated
        for (int i = 0; i < n; i++) {
            java.util.Arrays.fill(dp[i], -1);
        }

        return solve(0, 1);
    }

    private int solve(int i, int M) {

        // No piles left
        if (i >= n) {
            return 0;
        }

        // Can take all remaining piles
        if (2 * M >= n - i) {
            return suffix[i];
        }

        if (dp[i][M] != -1) {
            return dp[i][M];
        }

        int best = 0;

        // Take X piles
        for (int X = 1; X <= 2 * M; X++) {

            int newM = Math.max(M, X);

            // Current player's stones
            int current = suffix[i] - solve(i + X, newM);

            best = Math.max(best, current);
        }

        return dp[i][M] = best;
    }
}
