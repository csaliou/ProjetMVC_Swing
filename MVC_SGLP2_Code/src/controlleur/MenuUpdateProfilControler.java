package controlleur;

import model.Data;
import model.Utilisateur;
import vue.TypeWindow;
/**
 * 
 * @author Cheikh Saliou Ndiaye
 *
 */
//classe MenuSessionControler herite de la classe abstraite AbstractMenuControlleur

public class MenuUpdateProfilControler extends AbstractMenuControlleur {
    private Data data;
    public MenuUpdateProfilControler(Data data)
    {
        this.data = data;
    }
    /**
     * 
     * @return age
     */
    public int getAge()
    {
        return data.getUserConnected().getAge();
    }
    /**
     * 
     * @return sexe
     */
    
    public String getSexe()
    {
        return data.getUserConnected().getSexe();
    }
    /**
     * 
     * @return langue
     */
    
    public int getLangue()
    {
        return data.getUserConnected().getLangue();
    }
    
    /**
     * session
     */
    public void btnRetourClicked()
    {
        this.notifyObserver(TypeWindow.MENU_SESSION);
    }
    /**
     * 
     * @param int age
     * @param String sexe
     * @param int langue
     */
    public void btnConfirmerClicked(int age, String sexe, int langue)
    {
  
        if (age < 0) {
        	// pupup error
            this.notifyObserver(TypeWindow.POP_UP_ERROR_AGE);
        }
        //age correcte
        else
        {
            this.data.getUserConnected().update(age, sexe, langue);
            this.notifyObserver(TypeWindow.MENU_SESSION);
        }
    }
    
}
