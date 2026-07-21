//3499. Maximize Active Section with Trade I

class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int ones = 0;
        int prevZero = Integer.MIN_VALUE;
        int maxZero = 0;

        int i = 0;

        while (i < s.length()) {
            int j = i;

            while (j < s.length() && s.charAt(j) == s.charAt(i)) {
                j++;
            }

            int len = j - i;

            if (s.charAt(i) == '1') {
                ones += len;
            } else {
                maxZero = Math.max(maxZero, prevZero + len);
                prevZero = len;
            }

            i = j;
        }

        return ones + maxZero;
    }
}
