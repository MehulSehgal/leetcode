class Solution {
    public int numberOfPermutations(int n, int[][] requirements) {
        int MOD = 1000000007;
        int[] req = new int[n];
        for (int i = 0; i < n; i++) {
            req[i] = -1;
        }
        
        int maxEnd = 0;
        for (int[] r : requirements) {
            req[r[0]] = r[1];
            if (r[0] > maxEnd) {
                maxEnd = r[0];
            }
        }
        
        if (req[0] > 0) {
            return 0;
        }
        
        int maxInv = req[maxEnd];
        for (int i = 0; i < maxEnd; i++) {
            if (req[i] > maxInv) {
                return 0;
            }
        }
        
        int[][] dp = new int[maxEnd + 1][maxInv + 1];
        dp[0][0] = 1;
        
        for (int i = 1; i <= maxEnd; i++) {
            for (int j = 0; j <= maxInv; j++) {
                for (int k = 0; k <= Math.min(i, j); k++) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j - k]) % MOD;
                }
            }
            if (req[i] != -1) {
                for (int j = 0; j <= maxInv; j++) {
                    if (j != req[i]) {
                        dp[i][j] = 0;
                    }
                }
            }
        }
        
        long ans = dp[maxEnd][maxInv];
        for (int i = maxEnd + 1; i < n; i++) {
            ans = (ans * (i + 1)) % MOD;
        }
        
        return (int) ans;
    }
}
