package service;

import exceptions.PersonneIntrouvableException;
import modele.Personne;

import java.util.Collection;

public interface Facade {

    public String searchTelephone(String nom);
    public Personne searchPersonne(String nom) throws PersonneIntrouvableException;
    public void addPersonne(Personne p);
    public void addPersonneList(String nom, String prenom, String tel);
    public Collection<String> getAllNom();

}
