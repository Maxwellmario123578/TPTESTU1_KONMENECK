package com.saintjean.operation;

import java.util.Arrays;

public class OperationMathematique {
	public static boolean estPositif(int nombre) {
		return nombre>0;
		
		}
	public static long factorielle(int n) throws IllegalParamISIException {
        if (n < 0) {
            throw new IllegalParamISIException("Il faut un nombre strictement positif");
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
