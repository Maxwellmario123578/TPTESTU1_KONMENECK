package com.saintjean.operation;

import java.util.Arrays;

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
	public static int[] trier(int[] liste) {
	    
	    Arrays.sort(liste);
	    for (int i = 0; i < liste.length / 2; i++) {
	        int temp = liste[i];
	        liste[i] = liste[liste.length - 1 - i];
	        liste[liste.length - 1 - i] = temp;
	    }
	    return liste;
	}

}
