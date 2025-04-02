package palabras;

public class CalculadoraDistancias {
    /**
     * Calcula la distancia de edición, tal y como la expone
     * Jurafsky entre las cadenas `s1` y `s2`.
     * 
     * @param s1,s2 S
     */
    public static int calcularDistancia(String s1, String s2) {
        
        int m = s1.length();
        int n = s2.length();

        // Crear matriz para la programación dinámica
        int[][] dp = new int[m + 1][n + 1];

        // Inicializar la matriz con valores base (ejes)
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }

        // Llenar la matriz de manera iterativa
        for (int i = 1; i <= m; i++) {
            
            for (int j = 1; j <= n; j++) {
                
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) { //Si son iguales simplemente mantenemos el valor de la diagonal
                    dp[i][j] = dp[i - 1][j - 1];      
                } else {
                    int insercion = dp[i][j - 1] + 1;           //Comprobamos si queremos borrar, instetar o sustituir al ser distintos.
                    int eliminacion = dp[i - 1][j] + 1;
                    int sustitucion = dp[i - 1][j - 1] + 1;
                    dp[i][j] = Math.min(insercion, Math.min(eliminacion, sustitucion)); //Minimo entre los 3 valores (Math.min compara entre 2)
                }
            }
        }
        return dp[m][n];
    }
}