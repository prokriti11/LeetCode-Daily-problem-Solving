class Solution {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        final int MOD = 1000000007;
        
        // dp[i] = number of people who learn the secret on day i
        int[] dp = new int[n + 1];
        dp[1] = 1; // First person learns on day 1
        
        int sharing = 0;   // People who can share today
        int total = 1;     // Total people who currently know the secret
        
        for (int day = 2; day <= n; day++) {
            // People who learned (day - delay) days ago can start sharing today
            if (day - delay >= 1) {
                sharing = (sharing + dp[day - delay]) % MOD;
            }
            
            // People who learned (day - forget) days ago forget today
            if (day - forget >= 1) {
                sharing = (sharing - dp[day - forget] + MOD) % MOD;
                total = (total - dp[day - forget] + MOD) % MOD;
            }
            
            // New people learn the secret today (from all who can share)
            dp[day] = sharing;
            total = (total + dp[day]) % MOD;
        }
        
        return total;
    }
}