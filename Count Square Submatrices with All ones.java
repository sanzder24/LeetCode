class Solution {
    public int countSquares(int[][] matrix) {

	int m = matrix.length, n = matrix[0].length, ans = 0;
	int[][] dp = new int[m][n];

	for (int i = 0; i < n - 1; i++) {
		if (matrix[m - 1][i] == 1) {
			dp[m - 1][i] = 1;
			ans++;
		}
	}

	for (int i = 0; i < m; i++) {
		if (matrix[i][n - 1] == 1) {
			dp[i][n - 1] = 1;
			ans++;
		}
	}

	for (int i = m - 2; i >= 0; i--) {
		for (int j = n - 2; j >= 0; j--) {
			if (matrix[i][j] == 0)
				continue;
			dp[i][j] = Math.min(dp[i + 1][j + 1], Math.min(dp[i + 1][j], dp[i][j + 1])) + 1;
			ans += dp[i][j];
		}
	}
    return ans;
}
}

