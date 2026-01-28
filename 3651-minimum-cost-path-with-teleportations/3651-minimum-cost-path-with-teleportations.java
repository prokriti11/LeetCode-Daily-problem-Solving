class Solution {
    public int minCost(int[][] grid, int k) {
        int n = grid.length, m = grid[0].length;

        int maxVal = 0;
        for(int[] row : grid){
            for(int val : row) maxVal = Math.max(maxVal, val);
        }
        int[][] dp = new int[n][m];
        int[] temp = new int[maxVal + 1];
        int[] best = new int[maxVal + 1];
   Arrays.fill(temp, Integer.MAX_VALUE);
        temp[grid[n-1][m-1]] = 0;

        for(int i = n - 1; i >= 0; i--) {
            for(int j = m - 1; j >= 0; j--) {
                if(i == n - 1 && j == m - 1) continue; // Skip target
                
                int down = (i + 1 < n) ? dp[i + 1][j] + grid[i + 1][j] : Integer.MAX_VALUE;
                int right = (j + 1 < m) ? dp[i][j + 1] + grid[i][j + 1] : Integer.MAX_VALUE;
                
                dp[i][j] = Math.min(down, right);
                
                // Update the best known cost for this cell's value
                if (dp[i][j] != Integer.MAX_VALUE) {
                    temp[grid[i][j]] = Math.min(temp[grid[i][j]], dp[i][j]);
                }
            }
        }

        // --- LAYERS (K > 0) ---
        // For each allowed teleport, we try to relax the grid costs
        for(int x = 0; x < k; x++) {
            
            // 1. Build Prefix Minimum Array
            // best[v] = min cost obtainable from any cell with value <= v
            best[0] = temp[0];
            for(int v = 1; v <= maxVal; v++) {
                best[v] = Math.min(best[v - 1], temp[v]);
            }
            
            // 2. Update DP Table with Teleport Options
            for(int i = n - 1; i >= 0; i--) {
                for(int j = m - 1; j >= 0; j--) {
                    if(i == n - 1 && j == m - 1) continue;
                    
                    int down = (i + 1 < n) ? dp[i + 1][j] + grid[i + 1][j] : Integer.MAX_VALUE;
                    int right = (j + 1 < m) ? dp[i][j + 1] + grid[i][j + 1] : Integer.MAX_VALUE;
                    int walkCost = Math.min(down, right);
                    
                    // Teleport Option: Jump to the best state with value <= grid[i][j]
                    int teleportCost = best[grid[i][j]];
                    
                    dp[i][j] = Math.min(walkCost, teleportCost);
                    
                    // Update temp for the NEXT iteration
                    if (dp[i][j] != Integer.MAX_VALUE) {
                        temp[grid[i][j]] = Math.min(temp[grid[i][j]], dp[i][j]);
                    }
                }
            }
        }
        
        return dp[0][0];
    }
}