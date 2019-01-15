package controlleur;

import model.Data;
import vue.TypeWindow;
/**
 * 
 * @author Cheikh Saliou Ndiaye
 *
 */
// classe MenuCreationControler herite de la classe abstraite AbstractMenuControlleur
public class MenuCreationControler extends AbstractMenuControlleur {
    private Data data;
    public MenuCreationControler(Data data)
    {
        this.data = data;
    }
    /**
     * retour menu principal
     */
    public void btnRetourClicked()
    {
        this.notifyObserver(TypeWindow.MENU_PRINCIPAL); //menu principal
    }
    /**
     * 
     * @param string identifiant
     * @param int age
     * @param string sexe
     * @param int langue
     */
    public void btnConfirmerClicked(String identifiant, int age, String sexe, int langue)
    {
        // utilisateur vide
        if (identifiant.isEmpty())
            this.notifyObserver(TypeWindow.POP_UP_ERROR_NOM_EMPTY); // identifiant vide
        
        // utilisateur utilisé
        else if (!data.checkUtilisateurExist(identifiant))
            this.notifyObserver(TypeWindow.POP_UP_ERROR_NOM_USE);// identifiant non existant
        // age non valide
        else if (age < 0)
            this.notifyObserver(TypeWindow.POP_UP_ERROR_AGE); // erreur age
        
        //  sinon creer user et afficher le pop up de fin de creation de compte
        else
        {
            this.data.addUser(identifiant, age, sexe, langue);
            this.data.connectUser(identifiant);
            this.notifyObserver(TypeWindow.POP_UP_REDIRECTION_END_CREATION); // fin de creation compte ->generer pop up
        }
    }
}
