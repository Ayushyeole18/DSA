class Solution {
    public int sumOfMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        
        int sum = 0;
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                sum += mat[i][j];
            }
        }
        return sum;
        
    }
}
