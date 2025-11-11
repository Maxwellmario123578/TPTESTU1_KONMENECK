package com.saintjean.operation_alpha;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class alhpa_tests_unitaires {

    @BeforeEach
    void clearUsers() {
        Utilisateur.getUsers().clear();
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
    void testAjouterUtilisateurValide() throws EmailInvalidException {
        Utilisateur u = new Utilisateur(1, "KONMENECK", 20, "konmeneckmasewellmathurin@gmail.com", "691380083", "Yaoundé", 1000);
        Utilisateur.ajouter(u);
        assertEquals(1, Utilisateur.getUsers().size());
        assertEquals("KONMENECK", Utilisateur.getUsers().get(0).getNom());
    }

    @Test
    void testAjouterUtilisateurEmailInvalide() {
        Utilisateur u = new Utilisateur(2, "FAGME", 30, "fagme#example.com", "678365268", "Douala", 500);
        EmailInvalidException exception = assertThrows(EmailInvalidException.class, () -> {
            Utilisateur.ajouter(u);
        });
        assertEquals("Email invalide : fagme#example.com", exception.getMessage());
        assertEquals(0, Utilisateur.getUsers().size());
    }

    @Test
    void testSupprimerUtilisateurExistant() throws EmailInvalidException, SuppressionInvalidException {
        Utilisateur u = new Utilisateur(1, "KONMENECK", 20, "konmeneckmasewellmathurin@gmail.com", "691380083", "Yaoundé", 1000);
        Utilisateur.ajouter(u);
        Utilisateur.supprimer(1);
        assertEquals(0, Utilisateur.getUsers().size());
    }

    @Test
    void testSupprimerUtilisateurInexistant() {
        SuppressionInvalidException exception = assertThrows(SuppressionInvalidException.class, () -> {
            Utilisateur.supprimer(99);
        });
        assertEquals("Impossible de supprimer : utilisateur ID 99 inexistant", exception.getMessage());
    }

    @Test
    void testListerEtAfficher() throws EmailInvalidException {
        Utilisateur u1 = new Utilisateur(1, "KONMENECK", 20, "konmeneckmasewellmathurin@gmail.com", "691380083", "Yaoundé", 1000);
        Utilisateur u2 = new Utilisateur(2, "FAGME", 30, "fagme@example.com", "678365268", "Douala", 500);

        Utilisateur.ajouter(u1);
        Utilisateur.ajouter(u2);

        assertEquals(2, Utilisateur.getUsers().size());
        assertEquals("KONMENECK", Utilisateur.getUsers().stream().filter(u -> u.getId() == 1).findFirst().get().getNom());
        assertEquals("FAGME", Utilisateur.getUsers().stream().filter(u -> u.getId() == 2).findFirst().get().getNom());
    }
}


