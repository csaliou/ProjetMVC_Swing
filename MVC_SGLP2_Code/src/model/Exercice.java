package model;
/**
 * 
 * @author Cheikh Saliou Ndiaye
 *
 */
public class Exercice {
	// attribut d'un exercice
    int langue;
	int typeLecon;
	int numeroExercice;
	/**
	 * 
	 * @param int typeLecon
	 * @param int num_exo
	 * @param int langue
	 */
	public Exercice(int typeLecon, int num_exo, int langue) {
		this.langue = langue;
		this.typeLecon = typeLecon;
                this.numeroExercice = num_exo;
	}
	
	//fonction qui affiche un exercice en fonction de ses valeurs
	// utilisation de switchCase
	public String print()
	{
            String txt;      
            txt = "Vous avez fait l'exercice " + this.numeroExercice + " d'une leçon ";
            
            switch (typeLecon) {
			case 0:
				txt += "de grammaire";
				break;		
			case 1:			
				txt += "de conjugaison";
				break;
			case 2:
				txt += "d'orthographe";
				break;
			case 3:
				txt += "de vocabulaire";
				break;
			}
            txt += " dans la langue ";
            switch (langue) {
            
			case 0:
				txt += "Anglaise";
				break;		
			case 1:			
				txt += "Espagnol";
				break;
			case 2:
				txt += "Italienne";
				break;
			case 3:
				txt += "de Allemande";
				break;
			}
            return txt;
            
      }
}
