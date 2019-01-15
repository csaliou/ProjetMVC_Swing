package vue;
import controlleur.MenuPrincipalControler;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.System.exit;
import javax.swing.JLabel;
import javax.swing.JPanel;
import model.observer.Observable;
 /**
  * 
  * @author Cheikh Saliou Ndiaye
  *
  */
public class MenuPrincipal extends JPanel {
    private MenuPrincipalControler controler;
    private JLabel label = new JLabel();
    private Bouton btnCreation = new Bouton("Créer un compte");
    private Bouton btnConnection = new Bouton("Se connecter");
    private Bouton btnConnectionAnonyme = new Bouton("Connexion annonyme");
    private Bouton btnQuitteProgramme = new Bouton("Quitter le programme");
    private Bouton btnListUser = new Bouton("Liste de tous les utilisateurs");
    
    private Bouton helpp = new Bouton("help");
    public MenuPrincipal(MenuPrincipalControler controler)
    {
        this.controler = controler;
        Font police = new Font("DS-digital", Font.TYPE1_FONT, 15);
        this.label.setFont(police);
        this.label.setHorizontalAlignment(JLabel.CENTER);
        this.label.setText("Bienvenue sur le menu principal");
        
        //clic sur creation
        this.btnCreation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controler.ButtonCreationClickded();
            }
        });
        //clic sur connexion sur son compte
        this.btnConnection.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controler.ButtonConnexionClicked();
            }
        });
        //connexion anonyme
        this.btnConnectionAnonyme.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controler.ButtonConnexionAnnonymeClicked();
            }
        });
        //quitter le programme
        this.btnQuitteProgramme.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exit(0);
            }
        });
        this.btnListUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controler.ButtonListUserClicked();
            }
        });
        GridLayout gl = new GridLayout(6, 1, 50, 20);
        this.setLayout(gl);
        this.add(this.label, BorderLayout.CENTER);
        this.add(this.btnCreation);
        this.add(this.btnConnection);
        this.add(this.btnConnectionAnonyme);
        this.add(this.btnQuitteProgramme);
        this.add(this.btnListUser);     
        //this.add(this.helpp);

    }
}