package vue;

import controlleur.MenuPrincipalControler;
import controlleur.MenuSessionControler;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.System.exit;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 * 
 * @author Cheikh Saliou Ndiaye
 *
 */
public class MenuSession extends JPanel {
    private JLabel label = new JLabel();
    private Bouton btnExercice = new Bouton("Faire un exercice");
    private Bouton btnHistorique = new Bouton("Historique");
    private Bouton btnUpdateProfil = new Bouton("Mettre à jour votre profil");
    private Bouton btnDeconnection = new Bouton("Deconnection");
    private Bouton btnQuitte = new Bouton("Quitter");
    private MenuSessionControler controler;
    
    public MenuSession(MenuSessionControler controler)
    {
        this.controler = controler;
        Font police = new Font("DS-digital", Font.TYPE1_FONT, 15);
        this.label.setFont(police);
        this.label.setHorizontalAlignment(JLabel.CENTER);
        this.label.setText("Bienvenue sur le menu session");
        this.btnExercice.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controler.ButtonExerciceClickded();
            }
        });
        this.btnHistorique.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controler.ButtonHistoriqueClickded();
            }
        });
        this.btnUpdateProfil.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controler.ButtonUpdateProfilClicked();
            }
        });
        this.btnDeconnection.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controler.ButtonDeconnectionClicked();            }
        });
        this.btnQuitte.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controler.ButtonDeconnectionClicked();
            }
        });
        GridLayout gl = new GridLayout(6, 1, 50, 20);
        this.setLayout(gl);
        this.add(this.label, BorderLayout.CENTER);
        this.add(this.btnExercice);
        //si ce n'est pas un utilisateur annonyme on affiche toutes les fonctionnalités du compte
        if (!this.controler.isAnonymous())
        {
            this.add(this.btnHistorique);
            this.add(this.btnUpdateProfil);
            this.add(this.btnDeconnection);
        }
        else
        {
            this.add(this.btnQuitte);        
        }
    }
}
