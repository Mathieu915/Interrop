package authent.modele;

public class Joueur {

    private String nomJoueur;
    private String mdpJoueur;


    public Joueur(String nomJoueur, String mdpJoueur) {
        this.nomJoueur = nomJoueur;
        this.mdpJoueur = mdpJoueur;

    }








    public String getNomJoueur() {
        return nomJoueur;
    }

    public String getPassword() {
        return mdpJoueur;
    }

    public boolean checkPassword(String password) {
        return this.mdpJoueur.equals(password);
    }
}
