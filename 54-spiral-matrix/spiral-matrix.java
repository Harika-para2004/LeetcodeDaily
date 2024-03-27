class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();

        if(matrix.length == 0){
            return res;
        }

        int top =0;
        int bottom =matrix.length;
        int left=0;
        int right = matrix[0].length;

        while(top<bottom && left<right){
            //traverse right
            for(int j=left;j<right;j++){
                res.add(matrix[top][j]);
            }
            top++;

            //traverse down
            for(int j=top;j<bottom;j++){
                res.add(matrix[j][right-1]);
            }
            right--;

            //traverse left
            if(top < bottom){
                for(int j=right-1;j>=left;j--){
                    res.add(matrix[bottom-1][j]);
                }
            }
            bottom--;

            //traverse top
            if(left<right){
                for(int j=bottom-1;j>=top;j--){
                    res.add(matrix[j][left]);
                }
            }
            left++;
        }
        return res;
    }
}