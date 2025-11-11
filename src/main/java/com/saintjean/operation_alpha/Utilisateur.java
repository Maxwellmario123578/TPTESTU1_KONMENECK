package com.saintjean.operation_alpha;

import java.util.ArrayList;
import java.util.Optional;
import java.util.regex.Pattern;

// Exceptions personnalisées
class EmailInvalidException extends Exception {
    public EmailInvalidException(String message) {
        super(message);
    }
}

class SuppressionInvalidException extends Exception {
    public SuppressionInvalidException(String message) {
        super(message);
    }
}

// Nouvelle exception pour le solde général négatif
class NegativeGeneralBalanceException extends Exception {
    public NegativeGeneralBalanceException(String message) {
        super(message);
    }
}

public class Utilisateur {
    private int id;
    private String nom;
    private int age;
    private String email;
    private String telephone;
    private String ville;
    private double soldePersonnel;

    static ArrayList<Utilisateur> users = new ArrayList<>();

    public Utilisateur(int id, String nom, int age, String email, String telephone, String ville, double soldePersonnel) {
        this.id = id;
        this.nom = nom;
        this.age = age;
        this.email = email;
        this.telephone = telephone;
        this.ville = ville;
        this.soldePersonnel = soldePersonnel;
    }

    // Getters et Setters
    public int getId() { return id; }
    public String getNom() { return nom; }
    public int getAge() { return age; }
    public String getEmail() { return email; }
    public String getTelephone() { return telephone; }
    public String getVille() { return ville; }
    public double getSoldePersonnel() { return soldePersonnel; }

    public void setNom(String nom) { this.nom = nom; }
    public void setAge(int age) { this.age = age; }
    public void setEmail(String email) { this.email = email; }
    public void setTelephone(String telephone) { this.telephone = telephone; }
    public void setVille(String ville) { this.ville = ville; }
    public void setSoldePersonnel(double soldePersonnel) { this.soldePersonnel = soldePersonnel; }

    // Validation email
    private static void validerEmail(String email) throws EmailInvalidException {
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        if (!Pattern.matches(regex, email)) {
            throw new EmailInvalidException("Email invalide : " + email);
        }
    }

    // Ajouter un utilisateur avec validation email
    public static void ajouter(Utilisateur user) throws EmailInvalidException {
        validerEmail(user.getEmail());
        users.add(user);
        System.out.println("Utilisateur ajouté : " + user.getNom());
    }

    // Supprimer un utilisateur par ID avec exception si inexistant
    public static void supprimer(int id) throws SuppressionInvalidException {
        Optional<Utilisateur> userOpt = users.stream()
                .filter(u -> u.getId() == id)
                .findFirst();
        if (userOpt.isPresent()) {
            users.remove(userOpt.get());
            System.out.println("Utilisateur supprimé : ID " + id);
        } else {
            throw new SuppressionInvalidException("Impossible de supprimer : utilisateur ID " + id + " inexistant");
        }
    }

    // Lister tous les utilisateurs
    public static void lister() {
        if (users.isEmpty()) {
            System.out.println("Aucun utilisateur enregistré.");
        } else {
            System.out.println("Liste des utilisateurs :");
            for (Utilisateur u : users) {
                System.out.println("ID: " + u.getId() + ", Nom: " + u.getNom() + ", Email: " + u.getEmail());
            }
        }
    }

    // Afficher un utilisateur par ID
    public static void afficher(int id) {
        Optional<Utilisateur> userOpt = users.stream()
                .filter(u -> u.getId() == id)
                .findFirst();
        if (userOpt.isPresent()) {
            Utilisateur u = userOpt.get();
            System.out.println("Détails de l'utilisateur ID " + id + ":");
            System.out.println("Nom: " + u.getNom());
            System.out.println("Age: " + u.getAge());
            System.out.println("Email: " + u.getEmail());
            System.out.println("Téléphone: " + u.getTelephone());
            System.out.println("Ville: " + u.getVille());
            System.out.println("Solde personnel: " + u.getSoldePersonnel());
        } else {
            System.out.println("Utilisateur non trouvé : ID " + id);
        }
    }

    public static ArrayList<Utilisateur> getUsers1() {
        return users;
    }



    public static double analyseSoldeGeneral() throws NegativeGeneralBalanceException {
        double total = users.stream().mapToDouble(Utilisateur::getSoldePersonnel).sum();
        if (total < 0) {
            throw new NegativeGeneralBalanceException("Solde général négatif : " + total);
        }
        System.out.println("Solde général des utilisateurs : " + total);
        return total;
    }


    public static Utilisateur getUtilisateurLePlusRiche() {
        if (users.isEmpty()) {
            System.out.println("Aucun utilisateur enregistré.");
            return null;
        }
        Utilisateur riche = users.stream()
                .max((u1, u2) -> Double.compare(u1.getSoldePersonnel(), u2.getSoldePersonnel()))
                .orElse(null);
        System.out.println("Utilisateur le plus riche : " + riche.getNom() + " avec " + riche.getSoldePersonnel());
        return riche;
    }

    // Getter pour les tests
    public static ArrayList<Utilisateur> getUsers() {
        return users;
    }

}
