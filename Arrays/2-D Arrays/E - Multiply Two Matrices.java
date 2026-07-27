class Solution {
    public ArrayList<ArrayList<Integer>> multiplyMatrices(int[][] a, int[][] b) {
        int n1 = a.length;
        int m1 = a[0].length;
        int n2 = b.length;
        int m2 = b[0].length;

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        if (m1 != n2) {
            return ans;
        }

        for (int i = 0; i < n1; i++) {
            ArrayList<Integer> row = new ArrayList<>();

            for (int j = 0; j < m2; j++) {
                int sum = 0;

                for (int k = 0; k < m1; k++) {
                    sum += a[i][k] * b[k][j];
                }

                row.add(sum);
            }

            ans.add(row);
        }

        return ans;
    }
}
