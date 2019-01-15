package controlleur;

import model.Data;
import vue.TypeWindow;
/**
 * 
 * @author Cheikh Saliou Ndiaye
 *
 */
// de la class AbstractMenuControlleur
public class MenuConnectionControler extends AbstractMenuControlleur {
    private Data data;
    public MenuConnectionControler(Data data)
    {
        this.data = data;
    }
    
    /**
     * retour menu principal
     */
    public void btnRetourClicked()
    {
        this.notifyObserver(TypeWindow.MENU_PRINCIPAL);
    }
    /**
     * 
     * @param string identifiant
     */
    public void btnConfirmerClicked(String identifiant)
    {
        // si l'identifiant est vide 
    	if (identifiant.isEmpty())
    		// popup nom vide
            this.notifyObserver(TypeWindow.POP_UP_ERROR_NOM_EMPTY); //erreur nom vide
        else
        {
            if (!this.data.connectUser(identifiant))
            {
                this.notifyObserver(TypeWindow.POP_UP_ERROR_NOM_NOT_USE); //utilisateur non existant 
            }
            else
            {
            	// demarer session
                this.data.startSession();
                this.notifyObserver(TypeWindow.MENU_SESSION); // identifiant correcte ->session
            }
        }
    }
}
