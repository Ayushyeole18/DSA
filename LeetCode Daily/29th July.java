class Solution {
    static final long LIMIT = 1000001;

    public String smallestPalindrome(String s, int k) {
        int[] freq = new int[26];

        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        char mid = 0;
        int[] half = new int[26];
        int len = 0;

        for (int i = 0; i < 26; i++) {
            if ((freq[i] & 1) == 1) {
                mid = (char) ('a' + i);
            }
            half[i] = freq[i] / 2;
            len += half[i];
        }

        if (countWays(half, len) < k) {
            return "";
        }

        StringBuilder left = new StringBuilder();

        for (int pos = 0; pos < len; pos++) {
            for (int c = 0; c < 26; c++) {
                if (half[c] == 0) continue;

                half[c]--;
                long ways = countWays(half, len - pos - 1);

                if (ways >= k) {
                    left.append((char) ('a' + c));
                    break;
                } else {
                    k -= ways;
                    half[c]++;
                }
            }
        }

        StringBuilder ans = new StringBuilder();
        ans.append(left);

        if (mid != 0) ans.append(mid);

        ans.append(new StringBuilder(left).reverse());

        return ans.toString();
    }

    private long countWays(int[] cnt, int total) {
        long res = 1;

        for (int i = 2; i <= total; i++) {
            res = Math.min(LIMIT, res * i);
        }

        for (int x : cnt) {
            for (int i = 2; i <= x; i++) {
                res /= i;
            }
        }

        return Math.min(res, LIMIT);
    }
}
