package modele;

import java.util.ArrayList;
import java.util.List;

public class Personne {
    private String nom;
    private String prenom;
    private List<Contact> contacts;

    public Personne(){}
    public Personne(String nom, String prenom){
        this.nom = nom;
        this.prenom = prenom;
        this.contacts = new ArrayList<>();
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void addContact(Contact contact) {
        this.contacts.add(contact);
    }
}
