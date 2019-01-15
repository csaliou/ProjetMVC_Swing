package controlleur;

import java.util.ArrayList;
import model.Data;
import model.Session;
import model.Utilisateur;
import vue.TypeWindow;
/**
 * 
 * @author Cheikh Saliou Ndiaye
 *
 */

//classe MenuHistoriqueControler herite de la classe abstraite AbstractMenuControlleur

public class MenuHistoriqueControler  extends AbstractMenuControlleur {
    private Data data;
    public MenuHistoriqueControler(Data data)
    {
        this.data = data;
    }
    
    public void btnRetourClicked()
    {
        this.notifyObserver(TypeWindow.MENU_SESSION);
    }
    /**
     * 
     * @return liste des session
     */
    public ArrayList<Session> getAllSession()
    {
        ArrayList<Session> list = data.getUserConnected().getAllSession();
        return list;
    }
    /**
     * fonction getLastSession
     * return session
     */
    public Session getLastSession()
    {
        return data.getSession();
    }
}
