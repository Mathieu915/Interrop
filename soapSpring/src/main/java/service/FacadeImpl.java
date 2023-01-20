package service;

import exceptions.PersonneIntrouvableException;
import jakarta.jws.WebService;
import jakarta.xml.ws.WebServiceRef;
import modele.Contact;
import modele.Personne;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@WebService
public class FacadeImpl implements Facade {
    private static Map<String, Personne> annuaire = new HashMap<>();
    static {
        Personne fred = new Personne("moal", "frederic");
        fred.addContact(new Contact("tel", "0238000000", fred));
        fred.addContact(new Contact("mail", "frederic.moal@univ-orleans.fr", fred));
        annuaire.put(fred.getNom(), fred);

        final Personne matthieu = new Personne("exbrayat", "matthieu");
        matthieu.addContact(new Contact("tel","0202020202", matthieu));
        annuaire.put(matthieu.getNom(), matthieu);

        final Personne yohan = new Personne("yohan", "boichut");
        matthieu.addContact(new Contact("mail","yohan.boichut@univ-orleans.fr", yohan));
        annuaire.put(yohan.getNom(), yohan);
    };

    @Override
    public String searchTelephone(String nom) {
        Personne p =  annuaire.get(nom);
        if (p==null) {
            return "Pas trouve";
        }
        return p.getContacts().stream().filter(c->c.getType().startsWith("tel")).findAny().get().getAdresse();
    }
    @Override
    public Personne searchPersonne(String nom) throws PersonneIntrouvableException {
        Personne p = annuaire.get(nom);
        if(p == null){
            throw new PersonneIntrouvableException();
        }
        return p;
    }
    @Override
    public void addPersonne(Personne p) {
        annuaire.put(p.getNom(), p);
    }
    @Override
    public void addPersonneList(String nom, String prenom, String tel) {
        Personne p = new Personne(nom,prenom);
        annuaire.put(p.getNom(), p);
    }
    @Override
    public Collection<String> getAllNom() {
        return annuaire.keySet();
    }
}
