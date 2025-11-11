package com.saintjean.operation;


public class OperationMathematique {
	public static boolean estPositif(int nombre) {
		return nombre>0;
		
	} 
	public static long factorielle(int n) throws FactorielInvalidException {
        if (n < 0) {
            throw new FactorielInvalidException("Le nombre doit être positif");
        }
        if(n==0) {
        	return 1;
        } 

        long resultat = 1;
        for (int i = 1; i <= n; i++) {
            resultat *= i;
        }
        return resultat;
    }
}
