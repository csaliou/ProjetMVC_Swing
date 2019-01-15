package vue;
/**
 * 
 * @author Cheikh Saliou Ndiaye
 *
 */
//enum qui sert a afficher chaque partie de l'application
public enum TypeWindow {
    MENU_PRINCIPAL(0),
    MENU_CONNEXION(1),
    MENU_CREATION(2),
    POP_UP_ERROR_AGE(3),
    POP_UP_ERROR_NOM_EMPTY(4),
    POP_UP_ERROR_NOM_USE(5),
    POP_UP_REDIRECTION_END_CREATION(6),
    MENU_SESSION(7),
    MENU_UPDATE_PROFIL(8),
    POP_UP_ERROR_NOM_NOT_USE(9),
    MENU_LIST_USER(10),
    MENU_EXERCICE(11),
    MENU_HISTORIQUE(12);
    
    
    private int value = 0;
    
    TypeWindow(int nb)
    {
        this.value = nb;
    }
    
    public int getValue()
    {
        return this.value;
    }
}
