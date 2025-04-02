package palabras;

public class CalculadoraDistancias {
    
    public static int calcularDistancia(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        // Inicializamos a -1 para indicar que el valor no ha sido calculado
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            
            for (int j = 0; j <= n; j++) {
                
                dp[i][j] = -1; 
            }
        }
        return auxiliarCalcularDistancia(s1, s2, dp, m, n);
    }


    private static int auxiliarCalcularDistancia(String s1, String s2, int[][] dp, int i, int j) {
       
        //Para palabras vacias
        if (i == 0) {
           
            return j;  
        }
        if (j == 0) {
            
            return i;  
        }

        // Comprobar si nuestro valor ha sido calculado previamente
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
           
            dp[i][j] = auxiliarCalcularDistancia(s1, s2, dp, i - 1, j - 1);
        } else {

            int insertion = auxiliarCalcularDistancia(s1, s2, dp, i, j - 1) + 1;
            int deletion = auxiliarCalcularDistancia(s1, s2, dp, i - 1, j) + 1;
            int substitution = auxiliarCalcularDistancia(s1, s2, dp, i - 1, j - 1) + 1;
            dp[i][j] = Math.min(insertion, Math.min(deletion, substitution));
        }

        return dp[i][j];
    }
}
