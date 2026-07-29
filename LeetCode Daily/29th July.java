//H- 3518. Smallest Palindromic Rearrangement II

class Solution {
    static final long LIMIT = 1000000L;

    public String smallestPalindrome(String s, int k) {
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) cnt[c - 'a']++;

        int[] half = new int[26];
        int halfLen = 0;
        String mid = "";

        for (int i = 0; i < 26; i++) {
            if ((cnt[i] & 1) == 1) mid = "" + (char) ('a' + i);
            half[i] = cnt[i] / 2;
            halfLen += half[i];
        }

        long[][] C = buildComb(halfLen);

        if (countWays(half, C) < k) return "";

        StringBuilder left = new StringBuilder();

        for (int pos = 0; pos < halfLen; pos++) {
            for (int ch = 0; ch < 26; ch++) {
                if (half[ch] == 0) continue;

                half[ch]--;
                long ways = countWays(half, C);

                if (ways >= k) {
                    left.append((char) ('a' + ch));
                    break;
                } else {
                    k -= ways;
                    half[ch]++;
                }
            }
        }

        StringBuilder ans = new StringBuilder();
        ans.append(left);
        ans.append(mid);
        ans.append(new StringBuilder(left).reverse());

        return ans.toString();
    }

    private long[][] buildComb(int n) {
        long[][] C = new long[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            C[i][0] = C[i][i] = 1;
            for (int j = 1; j < i; j++) {
                C[i][j] = Math.min(LIMIT, C[i - 1][j - 1] + C[i - 1][j]);
            }
        }

        return C;
    }

    private long countWays(int[] half, long[][] C) {
        int remain = 0;
        for (int x : half) remain += x;

        long ans = 1;

        for (int x : half) {
            if (x > 0) {
                ans = Math.min(LIMIT, ans * C[remain][x]);
                remain -= x;
            }
        }

        return ans;
    }
}
