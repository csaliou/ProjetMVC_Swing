package vue;

import controlleur.MenuConnectionControler;
import controlleur.MenuCreationControler;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
/**
 * 
 * @author Cheikh Saliou Ndiaye
 *
 */
public class MenuConnection extends JPanel {
    private JLabel label = new JLabel();
    private JLabel labIdentifiant = new JLabel("Entrez votre identifiant");
    private JTextField jtfIdentifiant = new JTextField("");
    private Bouton btnRetour = new Bouton("Revenir au menu principal");
    private Bouton btnValider = new Bouton("Se connecter");
    private MenuConnectionControler controler;
    public MenuConnection(MenuConnectionControler controler)
    {
        this.controler = controler;
        Font police = new Font("DS-digital", Font.TYPE1_FONT, 15);
        this.label.setFont(police);
        this.label.setHorizontalAlignment(JLabel.CENTER);
        this.label.setText("Veuillez indiquez vos informations.");
        //On créé un panel pour y introduire tous nos bouton dedans
        JPanel grid = new JPanel();
        //on fait de se panel un grid layout de 6 de hauteur et de 1 de largeur c'est à dire une colonne de 6 case
        GridLayout gl = new GridLayout(6, 1, 50, 20);
        grid.setLayout(gl);
        grid.add(this.label, BorderLayout.CENTER);
        
        JPanel top = new JPanel();
        GridLayout gl2 = new GridLayout(1, 2, 20, 20);
        top.setLayout(gl2);
        Font policeLab = new Font("Arial", Font.TYPE1_FONT, 12);
        this.labIdentifiant.setFont(policeLab);
        this.labIdentifiant.setHorizontalAlignment(JLabel.RIGHT);
        jtfIdentifiant.setPreferredSize(new Dimension(150, 30));
        top.add(this.labIdentifiant);
        top.add(jtfIdentifiant);
        grid.add(top);
        
        JPanel top5 = new JPanel();        
        top5.setLayout(gl2);
        
        //action lorsque le bouton est cliqué
        btnRetour.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //appel au controler de la fonction correspondante
                controler.btnRetourClicked();
            }
        });
        
        btnValider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                controler.btnConfirmerClicked(jtfIdentifiant.getText());
            }
        });
        //on ajoute tous les élémeents aux JPanel
        top5.add(this.btnRetour);
        top5.add(this.btnValider);
        grid.add(top5);
        this.add(grid);
    }
}
