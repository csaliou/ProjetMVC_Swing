package controlleur;

import vue.TypeWindow;
/**
 * 
 * @author Cheikh Saliou Ndiaye
 *
 */
//classe MenuPrincipalControler herite de la classe abstraite AbstractMenuControlleur

public class MenuPrincipalControler extends AbstractMenuControlleur{
    public MenuPrincipalControler()
    {
        
    }
    
    public void ButtonCreationClickded()
    {
        this.notifyObserver(TypeWindow.MENU_CREATION); //creation de compte
    }
    
    public void ButtonConnexionClicked()
    {
        this.notifyObserver(TypeWindow.MENU_CONNEXION); // connexion compte
    }
    
    public void ButtonConnexionAnnonymeClicked()
    {
        this.notifyObserver(TypeWindow.MENU_SESSION); // session
    }
    
    public void ButtonListUserClicked()
    {
         this.notifyObserver(TypeWindow.MENU_LIST_USER);  // liste de tous les users
    }
}
