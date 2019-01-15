package controlleur;

import model.Data;
import model.Utilisateur;
import vue.TypeWindow;
/**
 * 
 * @author Cheikh Saliou Ndiaye
 *
 */

//classe MenuExerciceControler herite de la classe abstraite AbstractMenuControlleur
public class MenuExerciceControler extends AbstractMenuControlleur {
    private Data data;
    public MenuExerciceControler(Data data)
    {
        this.data = data;
    }
    
    public void btnRetourClicked()
    {
        this.notifyObserver(TypeWindow.MENU_SESSION);
    }
    /**
     * 
     * @param int type_lecon
     * @param int num_exo
     */
    public void btnConfirmerClicked(int type_lecon, int num_exo)
    {
        Utilisateur user = this.data.getUserConnected();
        int langue = 0;
        // user existe
        if (user != null)
        {
        	langue = user.getLangue(); // recup la langue
            // exo fait 
        	this.data.doExercice(type_lecon, num_exo + 1, langue);
        }
        this.notifyObserver(TypeWindow.MENU_SESSION); //session
    }
}
