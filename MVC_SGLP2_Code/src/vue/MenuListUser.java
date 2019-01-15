package vue;

import controlleur.MenuListUserControler;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import model.Utilisateur;
import java.io.File;
/**
 * 
 * @author Cheikh Saliou Ndiaye
 *
 */
public class MenuListUser extends JPanel {
     private JLabel label = new JLabel();
    private Bouton btnRetour = new Bouton("Revenir au menu principal");
    private MenuListUserControler controler;
    public MenuListUser(MenuListUserControler controler)
    {
    	
        this.controler = controler;
        Font police = new Font("DS-digital", Font.TYPE1_FONT, 15);
        this.label.setFont(police);
        this.label.setHorizontalAlignment(JLabel.CENTER);
        this.label.setText("Liste des utilisateurs enregistrés");
        JPanel grid = new JPanel();
        
        Font policeLab = new Font("Arial", Font.TYPE1_FONT, 12);
        ArrayList<Utilisateur> listUser = controler.getAllUtil();
        int nb = 3;
        if (!listUser.isEmpty())
        {
            nb = 2 + listUser.size();
        }
        GridLayout gl = new GridLayout(nb, 1, 50, 20);
        grid.setLayout(gl);
        grid.add(this.label, BorderLayout.CENTER);
        //si il n'y a aucun utilisateur on affiche qu'il n'y en a pas
        if (listUser.isEmpty())
        {
            JLabel labNoUser = new JLabel("Il n'y a aucun utilisateur d'enregistré.");
            labNoUser.setFont(policeLab);
            grid.add(labNoUser);
        }
        else
        {
            //on parcourt la liste des utilisateurs pour les affiché un par un
            for(int i = 0; i < listUser.size(); i++)
            {
                Utilisateur user = listUser.get(i);
                JLabel labUser = new JLabel(user.print());
                labUser.setFont(policeLab);
                grid.add(labUser);
            }
        }
        //retour 
        btnRetour.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controler.btnRetourClicked();
            }
        });
        
        grid.add(this.btnRetour);
        this.add(grid);
    }
}
