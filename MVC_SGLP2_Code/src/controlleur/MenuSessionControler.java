package controlleur;

import model.Data;
import vue.TypeWindow;
/**
 * 
 * @author Cheikh Saliou Ndiaye
 *
 */

//classe MenuSessionControler herite de la classe abstraite AbstractMenuControlleur

public class MenuSessionControler extends AbstractMenuControlleur {
    private Data data;
    public MenuSessionControler(Data data)
    {
        this.data = data;
    }
    /**
     * 
     * connexion anonyme
     */
    public boolean isAnonymous()
    {
        return this.data.isAnonymous();
    }
  
    public void ButtonExerciceClickded()
    {
        this.notifyObserver(TypeWindow.MENU_EXERCICE); //menu exercice
    }

    public void ButtonHistoriqueClickded()
    {
        this.notifyObserver(TypeWindow.MENU_HISTORIQUE); // historique 
    }

    public void ButtonUpdateProfilClicked()
    {
        this.notifyObserver(TypeWindow.MENU_UPDATE_PROFIL); // mis à jour profil
    }
    
    public void ButtonDeconnectionClicked()
    {
         data.disconnectUser(); // user deconnecté
         this.notifyObserver(TypeWindow.MENU_PRINCIPAL); // menu principal
    }
}
