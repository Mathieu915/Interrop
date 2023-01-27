package authent.modele;

public interface FacadeJoueur {
    /**
     * Inscription d'un nouveau joueur à la POFOL
     *
     * @param nouveauJoueur
     * @param mdp
     * @throws PseudoDejaPrisException
     */
    void inscription(String nouveauJoueur, String mdp) throws PseudoDejaPrisException;


    /**
     * Permet de se désinscrire de la plate-forme
     * @param pseudo
     * @param mdp
     * @throws JoueurInexistantException
     */
    void desincription(String pseudo, String mdp) throws JoueurInexistantException, OperationNonAutorisee;


    Joueur getJoueurByPseudo(String pseudo)  throws JoueurInexistantException;
}
