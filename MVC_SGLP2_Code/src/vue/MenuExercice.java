package vue;

import controlleur.MenuCreationControler;
import controlleur.MenuExerciceControler;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
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
public class MenuExercice extends JPanel {
    private JLabel label = new JLabel();
    private JLabel labSexe = new JLabel("Choisissez votre type de leçon");
    private JLabel labLangue = new JLabel("Choisissez le numéro de l'exercice");
    private JComboBox jcbSexe = new JComboBox();
    private JComboBox jcbLangue = new JComboBox();
    private Bouton btnRetour = new Bouton("Revenir au menu session");
    private Bouton btnValider = new Bouton("Faire l'exercice");
    private MenuExerciceControler controler;
    public MenuExercice(MenuExerciceControler controler)
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
        
        GridLayout gl2 = new GridLayout(1, 2, 20, 20);
        Font policeLab = new Font("Arial", Font.TYPE1_FONT, 12);
        JPanel top3 = new JPanel();        
        top3.setLayout(gl2);
        this.labSexe.setFont(policeLab);
        this.labSexe.setHorizontalAlignment(JLabel.RIGHT);
        top3.add(this.labSexe);
        this.jcbSexe.addItem("Grammaire");
        this.jcbSexe.addItem("Conjugaison");
        this.jcbSexe.addItem("Orthographe");
        this.jcbSexe.addItem("Vocabulaire");
        top3.add(this.jcbSexe);
        grid.add(top3);
        
        JPanel top4 = new JPanel();        
        top4.setLayout(gl2);
        this.labLangue.setFont(policeLab);
        this.labLangue.setHorizontalAlignment(JLabel.RIGHT);
        top4.add(this.labLangue);
        this.jcbLangue.addItem("1");
        this.jcbLangue.addItem("2");
        this.jcbLangue.addItem("3");
        this.jcbLangue.addItem("4");
        this.jcbLangue.addItem("5");
        this.jcbLangue.addItem("6");
        this.jcbLangue.addItem("7");
        this.jcbLangue.addItem("8");
        this.jcbLangue.addItem("9");
        this.jcbLangue.addItem("10");
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
                
                controler.btnConfirmerClicked(jcbSexe.getSelectedIndex(), jcbLangue.getSelectedIndex());
            }
        });
        top5.add(this.btnRetour);
        top5.add(this.btnValider);
        grid.add(top5);
        this.add(grid);
    }
}
