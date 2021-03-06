package vue;

import controlleur.MenuCreationControler;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
/**
 * 
 * @author Cheikh Saliou Ndiaye
 *
 */
public class MenuCreation extends JPanel {
    private JLabel label = new JLabel();
    private JLabel labIdentifiant = new JLabel("Entrez votre identifiant");
    private JLabel labAge = new JLabel("Entrez votre age");
    private JLabel labSexe = new JLabel("Entrez votre sexe");
    private JLabel labLangue = new JLabel("Choisissez la langue");
    private JTextField jtfIdentifiant = new JTextField("");
    private JFormattedTextField jtfAge = new JFormattedTextField(NumberFormat.getIntegerInstance());
    private JComboBox jcbSexe = new JComboBox();
    private JComboBox jcbLangue = new JComboBox();
    private Bouton btnRetour = new Bouton("Revenir au menu principal");
    private Bouton btnValider = new Bouton("Créer le compte");
    private MenuCreationControler controler;
    public MenuCreation(MenuCreationControler controler)
    {
        this.controler = controler;
        Font police = new Font("DS-digital", Font.TYPE1_FONT, 15);
        this.label.setFont(police);
        this.label.setHorizontalAlignment(JLabel.CENTER);
        this.label.setText("Veuillez indiquez vos informations.");
        JPanel grid = new JPanel();
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
        jtfAge.setPreferredSize(new Dimension(150, 30));
        top.add(this.labIdentifiant);
        top.add(jtfIdentifiant);
        grid.add(top);
        JPanel top2 = new JPanel();        
        top2.setLayout(gl2);
        this.labAge.setFont(policeLab);
        this.labAge.setHorizontalAlignment(JLabel.RIGHT);
        top2.add(this.labAge);
        top2.add(this.jtfAge);
        grid.add(top2);
        JPanel top3 = new JPanel();        
        top3.setLayout(gl2);
        this.labSexe.setFont(policeLab);
        this.labSexe.setHorizontalAlignment(JLabel.RIGHT);
        top3.add(this.labSexe);
        this.jcbSexe.addItem("Homme");
        this.jcbSexe.addItem("Femme");
        top3.add(this.jcbSexe);
        grid.add(top3);
        
        JPanel top4 = new JPanel();        
        top4.setLayout(gl2);
        this.labLangue.setFont(policeLab);
        this.labLangue.setHorizontalAlignment(JLabel.RIGHT);
        top4.add(this.labLangue);
        this.jcbLangue.addItem("Anglais");
        this.jcbLangue.addItem("Espagnol");
        this.jcbLangue.addItem("Italien");
        this.jcbLangue.addItem("Allemand");
        top4.add(this.jcbLangue);
        grid.add(top4);

        JPanel top5 = new JPanel();        
        top5.setLayout(gl2);
        
        btnRetour.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controler.btnRetourClicked();
            }
        });
        
        btnValider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int age = -1;
                try
                {
                    age = Integer.parseInt(jtfAge.getText());
                }
                catch (NumberFormatException excep)
                {
                    
                }
                controler.btnConfirmerClicked(jtfIdentifiant.getText(), age, (String)jcbSexe.getSelectedItem(), jcbLangue.getSelectedIndex());
            }
        });
        top5.add(this.btnRetour);
        top5.add(this.btnValider);
        grid.add(top5);
        this.add(grid);
    }
  
}
