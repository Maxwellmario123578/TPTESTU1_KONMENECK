package com.saintjean.operation_alpha;

import java.util.ArrayList;
import java.util.Optional;

public class Utilisateur {
    private int id;
    private String nom;
    private int age;
    private String email;
    private String telephone;
    private String ville;
    private double soldePersonnel;

    // Liste statique pour stocker tous les utilisateurs
    private static ArrayList<Utilisateur> users = new ArrayList<>();

    public Utilisateur(int id, String nom, int age, String email, String telephone, String ville, double soldePersonnel) {
        this.id = id;
        this.nom = nom;
        this.age = age;
        this.email = email;
        this.telephone = telephone;
        this.ville = ville;
        this.soldePersonnel = soldePersonnel;
    }

    // Getters
    public int getId() { return id; }
    public String getNom() { return nom; }
    public int getAge() { return age; }
    public String getEmail() { return email; }
    public String getTelephone() { return telephone; }
    public String getVille() { return ville; }
    public double getSoldePersonnel() { return soldePersonnel; }

    // Setters
    public void setNom(String nom) { this.nom = nom; }
    public void setAge(int age) { this.age = age; }
    public void setEmail(String email) { this.email = email; }
    public void setTelephone(String telephone) { this.telephone = telephone; }
    public void setVille(String ville) { this.ville = ville; }
    public void setSoldePersonnel(double soldePersonnel) { this.soldePersonnel = soldePersonnel; }

    // Méthodes demandées

    // Ajouter un utilisateur
    public static void ajouter(Utilisateur user) {
        users.add(user);
        System.out.println("Utilisateur ajouté : " + user.getNom());
    }

    // Supprimer un utilisateur par ID
    public static void supprimer(int id) {
        Optional<Utilisateur> userOpt = users.stream()
                .filter(u -> u.getId() == id)
                .findFirst();
        if (userOpt.isPresent()) {
            users.remove(userOpt.get());
            System.out.println("Utilisateur supprimé : ID " + id);
        } else {
            System.out.println("Utilisateur non trouvé : ID " + id);
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
}
