package com.saintjean.operation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestOperationMathematique {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	@Test
	void testmasNumba() {
        double[] tableau1 = {1.5, 3.2, 7.8, 2.1};
        assertEquals(7.8, OperationMathematique.maxNumba(tableau1));

        double[] tableau2 = {-5.0, -2.1, -9.3, -0.5};
        assertEquals(-0.5, OperationMathematique.maxNumba(tableau2));

        double[] tableau3 = {-1.2, 3.4, 0.0, 2.1};
        assertEquals(3.4, OperationMathematique.maxNumba(tableau3));

        double[] tableau4 = {42.0};
        assertEquals(42.0, OperationMathematique.maxNumba(tableau4));

    }
	@Test
    void testduTrie() {
        int[] tableau = {5, 2, 9, 1, 7};
        int[] attendu = {9, 7, 5, 2, 1};
        int [] tableau_1= {2,8,1,0,11,45};
        int [] attendu_1= {0,1,2,8,45,11};

        int[] resultat = OperationMathematique.trier(tableau);
        int[] resultat_1=OperationMathematique.trier(tableau_1);
        assertArrayEquals(attendu, resultat, "Le tableau doit être trié par ordre décroissant");
        assertArrayEquals(attendu_1, resultat_1, "Le tableau doit être trié par ordre décroissant");
    }
	@Test
	
	void testestpositif() {
		assertTrue(OperationMathematique.estPositif(12));
		assertTrue(OperationMathematique.estPositif(45));
		assertTrue(OperationMathematique.estPositif(20));
		assertTrue(OperationMathematique.estPositif(-45));
	}

	@Test
	void testfactorielle() throws IllegalParamISIException{
		System.out.println("Test de factorielle");
		assertEquals(6,OperationMathematique.factorielle(3));
		assertEquals(24,OperationMathematique.factorielle(4));
		assertEquals(1,OperationMathematique.factorielle(1));
		assertEquals(1,OperationMathematique.factorielle(0));
		assertEquals(1,OperationMathematique.factorielle(-44));
		
	}
}
