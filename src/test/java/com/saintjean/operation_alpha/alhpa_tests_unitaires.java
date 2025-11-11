package com.saintjean.operation_alpha;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

class alhpa_tests_unitaires {

    @BeforeEach
    void setUp() {
        Utilisateur.getUsers().clear();
    }

    @AfterEach
    void tearDown() {
        Utilisateur.getUsers().clear();
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



    @Test
    void testAnalyseSoldeGeneral_Positive() throws Exception {
        Utilisateur u1 = new Utilisateur(1, "KONMENECK", 23, "konmeneck@gmail.com", "690000000", "Yaoundé", 5000);
        Utilisateur u2 = new Utilisateur(2, "FAGME", 25, "fagme@gmail.com", "691111111", "Douala", 3000);
        Utilisateur.ajouter(u1);
        Utilisateur.ajouter(u2);

        double total = Utilisateur.analyseSoldeGeneral();
        assertEquals(8000, total, 0.001, "Le solde total doit être 8000");
    }

    @Test
    void testAnalyseSoldeGeneral_Negatif() throws Exception {
        Utilisateur u1 = new Utilisateur(1, "KONMENECK", 23, "konmeneck@gmail.com", "690000000", "Yaoundé", -5000);
        Utilisateur u2 = new Utilisateur(2, "FAGME", 25, "fagme@gmail.com", "691111111", "Douala", -2000);
        Utilisateur.ajouter(u1);
        Utilisateur.ajouter(u2);

        Exception exception = assertThrows(NegativeGeneralBalanceException.class, () -> {
            Utilisateur.analyseSoldeGeneral();
        });

        assertTrue(exception.getMessage().contains("Solde général négatif"));
    }

    @Test
    void testGetUtilisateurLePlusRiche() throws Exception {
        Utilisateur u1 = new Utilisateur(1, "KONMENECK", 23, "konmeneck@gmail.com", "690000000", "Yaoundé", 4000);
        Utilisateur u2 = new Utilisateur(2, "FAGME", 25, "fagme@gmail.com", "691111111", "Douala", 9500);
        Utilisateur u3 = new Utilisateur(3, "NGONO", 27, "ngono@gmail.com", "692222222", "Bafoussam", 5000);

        Utilisateur.ajouter(u1);
        Utilisateur.ajouter(u2);
        Utilisateur.ajouter(u3);

        Utilisateur riche = Utilisateur.getUtilisateurLePlusRiche();
        assertNotNull(riche);
        assertEquals("FAGME", riche.getNom(), "L’utilisateur le plus riche doit être FAGME");
    }

    @Test
    void testGetUtilisateurLePlusRiche_Vide() {
        Utilisateur.getUsers().clear();
        Utilisateur riche = Utilisateur.getUtilisateurLePlusRiche();
        assertNull(riche, "Doit retourner null si aucun utilisateur n’est enregistré");
    }
}
