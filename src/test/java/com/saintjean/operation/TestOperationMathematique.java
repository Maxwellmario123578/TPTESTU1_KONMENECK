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
	
	void testestpositif() {
		assertTrue(OperationMathematique.estPositif(12));
		assertTrue(OperationMathematique.estPositif(45));
		assertTrue(OperationMathematique.estPositif(20));
		assertTrue(OperationMathematique.estPositif(-45));
	}

	@Test
	void testfactorielle() throws FactorielInvalidException{
		System.out.println("Test de factorielle");
		assertEquals(6,OperationMathematique.factorielle(3));
		assertEquals(24,OperationMathematique.factorielle(4));
		assertEquals(1,OperationMathematique.factorielle(1));
		assertEquals(1,OperationMathematique.factorielle(0));
		assertEquals(1,OperationMathematique.factorielle(-45));
		
	}
}
