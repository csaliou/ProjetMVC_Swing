package model;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * 
 * @author Cheikh Saliou Ndiaye
 *
 */
public class Session {
	
	// attribut d'une session ( exos, date demarrage, date de fin , duree)
	ArrayList<Exercice> listExercice;
	long dateStart;
	long dateEnd;
	long duree;
	
	public Session() {
            this.listExercice = new ArrayList<>();
            this.startSession();
	}
	
	//fonction appelé au démarrage d'une session
	public void startSession() {
            this.dateStart = System.currentTimeMillis(); //sauvegarde l'heure de début de la session en milliseconde
	}
        /**
         * ajouter exercice
         * @param exo
         */
        public void addExercice(Exercice exo)
        {
            this.listExercice.add(exo);
        }
	/**
	 * calculer la durée
	 * @return durée ( debut-fin)
	 */
        public String getDuration()
        {
            Timestamp stamp = new Timestamp(this.dateStart);
            Date dateStart = new Date(stamp.getTime());
            String txt = "La session daté du " + dateStart + " a durée " + this.duree / 1000 + " secondes.";
	    return txt;
        }
	//affiche une session
	public ArrayList<String> print()
	{
            ArrayList<String> tab_txt = new ArrayList<>();
            if (this.listExercice.size() == 0)
            {
		tab_txt.add("Il y a eu aucun d'exercice de fait");
            }
            else
            {
		tab_txt.add("Il y a eu " + this.listExercice.size() + " d'exercice de fait");
		for(int n = 0; n < this.listExercice.size(); n++)
		{
                    tab_txt.add(this.listExercice.get(n).print());
		}
            }
            return tab_txt;
	}
	
	//fin de la session
	public void endSession() {
		this.dateEnd = System.currentTimeMillis();
		this.duree = this.dateEnd - this.dateStart;
	}
}