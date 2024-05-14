class Solution {
    int gold = 0;
    int max = 0;
    public int getMaximumGold(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if(grid[i][j] != 0) {
                    
                    gold = 0;
                    getMaximumGoldHelper(grid, i, j, m, n);
                }
            }
        }
        return max;
    }
    public void getMaximumGoldHelper(int[][] grid, int i, int j, int m, int n) {
        if(i >= m || i < 0 || j >= n || j < 0 || grid[i][j] == 0) {
            max = Math.max(gold, max);
            return;
        }
        int val = grid[i][j];
        gold += val;
        grid[i][j] = 0;
        int temp = gold;

        getMaximumGoldHelper(grid, i + 1, j, m, n);
        gold = temp;
        getMaximumGoldHelper(grid, i - 1, j, m, n);
        gold = temp;
        getMaximumGoldHelper(grid, i, j + 1, m, n);
        gold = temp;
        getMaximumGoldHelper(grid, i, j - 1, m, n);
        gold = temp;

        grid[i][j] = val;

    }

}