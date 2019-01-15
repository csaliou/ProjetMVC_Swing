package vue;

import controlleur.MenuHistoriqueControler;
import controlleur.MenuListUserControler;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;
import model.Session;
import model.Utilisateur;
/**
 * 
 * @author Cheikh Saliou Ndiaye
 *
 */
public class MenuHistorique  extends JPanel {
    private JLabel label = new JLabel();
    private Bouton btnRetour = new Bouton("Revenir au menu session");
    private MenuHistoriqueControler controler;
    public MenuHistorique(MenuHistoriqueControler controler)
    {
        this.controler = controler;
        Font police = new Font("DS-digital", Font.TYPE1_FONT, 15);
        this.label.setFont(police);
        this.label.setHorizontalAlignment(JLabel.CENTER);
        this.label.setText("Liste des sessions de l'utilisateur");
        JPanel grid = new JPanel();
        
        Font policeLab = new Font("Arial", Font.TYPE1_FONT, 12);
        ArrayList<Session> listSession = controler.getAllSession();
        int nb = 5;
        if (!listSession.isEmpty())
        {
            nb = 5 + listSession.size();
        }
        GridLayout gl = new GridLayout(nb, 1, 50, 20);
        grid.setLayout(gl);
        grid.add(this.label, BorderLayout.CENTER);
        //on parcourt la liste des sessions pour les afficher ensuite
        for(int i = 0; i < listSession.size(); i++)
        {
            Session session = listSession.get(i);
            this.printSession(session, grid, policeLab);
        }
        JLabel labLastSession = new JLabel("Session actuelle");
        labLastSession.setFont(policeLab);
        grid.add(labLastSession);
        //on affiche la session actuelle
        this.printSession(this.controler.getLastSession(), grid, policeLab);
        
        
        btnRetour.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controler.btnRetourClicked();
            }
        });
        
        grid.add(this.btnRetour);
        this.add(grid);
    }
   
    //sert a afficher une session
    public void printSession(Session session, JPanel grid, Font policeLab)
    {
        ArrayList<String> list_exo = session.print();
        JPanel gridSession = new JPanel();
        GridLayout glSession = new GridLayout(list_exo.size() + 1, 1, 5, 2);
        gridSession.setLayout(glSession);
        JLabel labUser = new JLabel(session.getDuration());
        labUser.setFont(policeLab);
        gridSession.add(labUser);
        //on parcourt la liste des exercices de la session pour les afficher
        for(int n = 0; n < list_exo.size(); n++)
        {
            JLabel labExo = new JLabel(list_exo.get(n));
            labExo.setFont(policeLab);
            gridSession.add(labExo);
        }
        grid.add(gridSession);
    }
}
