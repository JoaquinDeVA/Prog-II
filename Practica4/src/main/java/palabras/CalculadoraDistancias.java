package palabras;

public class CalculadoraDistancias {
    
    public static int calcularDistancia(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        // Initialize the dp table with -1 to indicate uncomputed values
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = -1; // Initialize with -1 to indicate that the value has not been computed yet
            }
        }

        // Start the recursion from the full strings (i.e., i = m, j = n)
        return calcularRecursivo(s1, s2, dp, m, n);
    }

    // Recursive function with memoization
    private static int calcularRecursivo(String s1, String s2, int[][] dp, int i, int j) {
        // Base cases: if one string is empty, the distance is the length of the other string
        if (i == 0) {
            return j;  // If s1 is empty, we need to insert all characters of s2
        }
        if (j == 0) {
            return i;  // If s2 is empty, we need to remove all characters of s1
        }

        // Check if the value has already been computed
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        // If characters match, no operation is needed, so we move diagonally
        if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
            dp[i][j] = calcularRecursivo(s1, s2, dp, i - 1, j - 1);
        } else {
            // Compute the minimum cost between the three possible operations: insertion, deletion, substitution
            int insertion = calcularRecursivo(s1, s2, dp, i, j - 1) + 1;
            int deletion = calcularRecursivo(s1, s2, dp, i - 1, j) + 1;
            int substitution = calcularRecursivo(s1, s2, dp, i - 1, j - 1) + 1;
            dp[i][j] = Math.min(insertion, Math.min(deletion, substitution));
        }

        return dp[i][j];
    }
}
