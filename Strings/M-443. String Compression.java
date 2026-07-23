class Solution {
    public int compress(char[] chars) {
        StringBuilder sb = new StringBuilder();
        int i = 0;

        while (i < chars.length) {
            int j = i;
            while (j < chars.length && chars[j] == chars[i]) {
                j++;
            }
            sb.append(chars[i]);
            if (j - i > 1) {
                sb.append(j - i);
            }
            i = j;
        }
        for (int k = 0; k < sb.length(); k++) {
            chars[k] = sb.charAt(k);
        }

        return sb.length();
    }
}
