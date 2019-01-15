package controlleur;

import java.util.ArrayList;
import model.Data;
import model.Utilisateur;
import vue.TypeWindow;
/**
 * 
 * @author Cheikh Saliou Ndiaye
 *
 */
//classe MenuListUserControler herite de la classe abstraite AbstractMenuControlleur
public class MenuListUserControler extends AbstractMenuControlleur {
    private Data data;
  
    public MenuListUserControler(Data data)
    {
        this.data = data;
    }
    
    public void btnRetourClicked()
    {
        this.notifyObserver(TypeWindow.MENU_PRINCIPAL); //menu principal
    }
    /**
     * 
     * @return data
     */
    public ArrayList<Utilisateur> getAllUtil()
    {
        return data.getAllUtil();
    }
}
