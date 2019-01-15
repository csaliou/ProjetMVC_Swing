package vue;


import controlleur.AbstractMenuControlleur;
import controlleur.MenuConnectionControler;
import controlleur.MenuCreationControler;
import controlleur.MenuExerciceControler;
import controlleur.MenuHistoriqueControler;
import controlleur.MenuListUserControler;
import controlleur.MenuPrincipalControler;
import controlleur.MenuSessionControler;
import controlleur.MenuUpdateProfilControler;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import model.Data;
/**
 * 
 * @author Cheikh Saliou Ndiaye
 *
 */
//classe principal c'est elle qui change les menus
//fenetre herite de la classe AbstractFenetre
public class Fenetre extends AbstractFenetre {
    private JPanel afficher;
    private Data data = new Data();
    public Fenetre(){
        //On initialise la JFrame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(true);
        this.setSize(800, 600);  // la taille du JFrame
	
        //permet d'initialiser la première vue -> menu principal
        MenuPrincipalControler controler = new MenuPrincipalControler();
        MenuPrincipal pan = new MenuPrincipal(controler);
        this.afficher = pan;
        controler.addObserver(this);
        this.getContentPane().add(pan);
        this.setVisible(true);
    }
    
    
    //surcouche de la fonction appelé depuis l'observer
    //sert a changer l'affichage en fonction de l'enum TypeWindow
    public void update(TypeWindow nb)
    {
        if (nb.getValue() == TypeWindow.MENU_PRINCIPAL.getValue())
        {
        	//affiche dans la console ce message
            System.out.println("menu principal affiché");

            //afiche le menu principal
            this.afficher.removeAll();
            this.getContentPane().remove(this.afficher);
            this.getContentPane().repaint();
            MenuPrincipalControler controler = new MenuPrincipalControler();
            MenuPrincipal pan = new MenuPrincipal(controler);
            this.afficher = pan;
            controler.addObserver(this);
            this.getContentPane().add(pan);
            this.setVisible(true);
        }
        
        else if (nb.getValue() == TypeWindow.MENU_CREATION.getValue())
        {
        	//message console
            System.out.println("menu création affiché");

            //affiche le menu création
            this.getContentPane().remove(this.afficher);
            this.getContentPane().repaint();
            MenuCreationControler controler = new MenuCreationControler(this.data);
            MenuCreation pan = new MenuCreation(controler);
            this.afficher = pan;
            controler.addObserver(this);
            this.getContentPane().add(pan);
            this.setVisible(true);
        }           
        else if (nb.getValue() == TypeWindow.POP_UP_ERROR_NOM_EMPTY.getValue())
        {
        	System.out.println("erreur identifiant: l'identifiant ne peut pas être vide!!");
            //Boîte du message d'erreur
            JOptionPane jopErreurAge = new JOptionPane();
            jopErreurAge.showMessageDialog(null, "Le nom d'utilisateur ne peut être vide", "Erreur nom d'utilisateur", JOptionPane.ERROR_MESSAGE);
        }
        else if (nb.getValue() == TypeWindow.POP_UP_ERROR_NOM_USE.getValue())
        {
        	System.out.println("erreur identifiant: l'identifiant dejâ prise!!");
            //Boîte du message d'erreur
            JOptionPane jopErreurAge = new JOptionPane();
            jopErreurAge.showMessageDialog(null, "Ce nom d'utilisateur est déjà pris", "Erreur nom d'utilisateur", JOptionPane.ERROR_MESSAGE);
        }
        else if (nb.getValue() == TypeWindow.POP_UP_ERROR_AGE.getValue())
        {
        	System.out.println("erreur age: verifier l'age saisi!!");
            //Boîte du message d'erreur
            JOptionPane jopErreurAge = new JOptionPane();
            jopErreurAge.showMessageDialog(null, "Veuillez saisir un age supérieur ou égale à 0", "Erreur age", JOptionPane.ERROR_MESSAGE);
        }
        else if (nb.getValue() == TypeWindow.POP_UP_REDIRECTION_END_CREATION.getValue())
        {
            //Boîte du message de demande de redirection a la fin de la creation de compte
            JOptionPane jopErreurAge = new JOptionPane();
            int option = jopErreurAge.showConfirmDialog(null, "Voullez vous vous connectez maintenant ?", "Fin de la création de compte", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (option == JOptionPane.OK_OPTION){
            	System.out.println("Bienvenue dans menu session!!");
                this.data.startSession();
                this.update(TypeWindow.MENU_SESSION);
            }
            else
            {
            	System.out.println("Menu principal affiché!!");
                this.data.disconnectUser();
                this.update(TypeWindow.MENU_PRINCIPAL);
            }
        }
        else if (nb.getValue() == TypeWindow.POP_UP_ERROR_NOM_NOT_USE.getValue())
        {
        	System.out.println("Ce nom d'utilisateur n'existe pas!!");
            //Boîte du message d'erreur
            JOptionPane jopErreurAge = new JOptionPane();
            jopErreurAge.showMessageDialog(null, "Ce nom d'utilisateur n'existe pas", "Erreur nom d'utilisateur", JOptionPane.ERROR_MESSAGE);
        }
        else if (nb.getValue() == TypeWindow.MENU_CONNEXION.getValue())
        {
            System.out.println("menu connexion affiché");

            //affiche le menu de connection
            this.getContentPane().remove(this.afficher);
            this.getContentPane().repaint();
            MenuConnectionControler controler = new MenuConnectionControler(this.data);
            MenuConnection pan = new MenuConnection(controler);
            this.afficher = pan;
            controler.addObserver(this);
            this.getContentPane().add(pan);
            this.setVisible(true);
        }
        else if (nb.getValue() == TypeWindow.MENU_SESSION.getValue())
        {
            System.out.println("menu connexion affiché");

            //affiche le menu session
            this.getContentPane().remove(this.afficher);
            this.getContentPane().repaint();
            MenuSessionControler controler = new MenuSessionControler(this.data);
            MenuSession pan = new MenuSession(controler);
            this.afficher = pan;
            controler.addObserver(this);
            this.getContentPane().add(pan);
            this.setVisible(true);
        }
        else if (nb.getValue() == TypeWindow.MENU_UPDATE_PROFIL.getValue())
        {
            System.out.println("menu connexion affiché");

            //affiche le menu update profil
            this.getContentPane().remove(this.afficher);
            this.getContentPane().repaint();
            MenuUpdateProfilControler controler = new MenuUpdateProfilControler(this.data);
            MenuUpdateProfil pan = new MenuUpdateProfil(controler);
            this.afficher = pan;
            controler.addObserver(this);
            this.getContentPane().add(pan);
            this.setVisible(true);
        }
        else if (nb.getValue() == TypeWindow.MENU_LIST_USER.getValue())
        {
            System.out.println("menu liste des utilisateurs affiché");

            //affiche le menu list user
            this.getContentPane().remove(this.afficher);
            this.getContentPane().repaint();
            MenuListUserControler controler = new MenuListUserControler(this.data);
            MenuListUser pan = new MenuListUser(controler);
            this.afficher = pan;
            controler.addObserver(this);
            this.getContentPane().add(pan);
            this.setVisible(true);
        }
        else if (nb.getValue() == TypeWindow.MENU_EXERCICE.getValue())
        {
            System.out.println("menu exercice affiché");

            //affiche le menu exercice
            this.getContentPane().remove(this.afficher);
            this.getContentPane().repaint();
            MenuExerciceControler controler = new MenuExerciceControler(this.data);
            MenuExercice pan = new MenuExercice(controler);
            this.afficher = pan;
            controler.addObserver(this);
            this.getContentPane().add(pan);
            this.setVisible(true);
        }
        else if (nb.getValue() == TypeWindow.MENU_HISTORIQUE.getValue())
        {
            System.out.println("menu historique affiché");

            //affiche le menu historique
            this.getContentPane().remove(this.afficher);
            this.getContentPane().repaint();
            MenuHistoriqueControler controler = new MenuHistoriqueControler(this.data);
            MenuHistorique pan = new MenuHistorique(controler);
            this.afficher = pan;
            controler.addObserver(this);
            this.getContentPane().add(pan);
            this.setVisible(true);
        }
        
    }
}