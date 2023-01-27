package authent.modele;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component("facadeJoueurs")
public class FacadeJoueurImpl implements FacadeJoueur {


    /**
     * Dictionnaire des joueurs inscrits
     */
    private Map<String,Joueur> joueurs;

    /**
     * Dictionnaire des joueurs connectés indexés par une clé aléatoire
     */
    private Map<String,Joueur> joueursConnectes;

    public FacadeJoueurImpl() {
        this.joueurs = new HashMap<>();
        this.joueursConnectes = new HashMap<>();
    }


    @Override
    public void inscription(String nouveauJoueur, String mdp) throws PseudoDejaPrisException {

        if (joueurs.containsKey(nouveauJoueur))
            throw new PseudoDejaPrisException();

        this.joueurs.put(nouveauJoueur,new Joueur(nouveauJoueur,mdp));
    }



    @Override
    public void desincription(String pseudo, String mdp) throws JoueurInexistantException, OperationNonAutorisee {
        if (!joueurs.containsKey(pseudo))
            throw new JoueurInexistantException();

        Joueur j = joueurs.get(pseudo);
        if (j.checkPassword(mdp)) {
            this.joueurs.remove(pseudo);
        }
        else {
            throw new OperationNonAutorisee();
        }


    }

    @Override
    public Joueur getJoueurByPseudo(String pseudo) throws JoueurInexistantException {
        if (this.joueursConnectes.containsKey(pseudo))
            return this.joueurs.get(pseudo);
        else
            throw new  JoueurInexistantException();
    }



}