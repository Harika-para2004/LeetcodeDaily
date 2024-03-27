class Solution {
    public void rotate(int[][] matrix) {
        //transpose 
        for(int i=0;i<matrix.length;i++){
            for(int j=i+1;j<matrix[i].length;j++){
                int t = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = t;
            }
        }
        //now reverse cols
        for(int row[] : matrix){
            for(int i=0;i<row.length/2;i++){
                int t = row[i];
                row[i] = row[row.length-i-1];
                row[row.length-i-1] = t;
            }
        }
        //  matrix;
    }
}