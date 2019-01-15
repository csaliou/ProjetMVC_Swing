package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * 
 * @author Cheikh Saliou Ndiaye
 *
 */
public class Utilisateur {
	// attributs d'un user
    ArrayList<Session> listSession;
    String identifiant;
    int age;
    String genre;
    int langue;
    /**
     * 
     * @param identifiant
     * @param age
     * @param genre
     * @param langue
     */
	public Utilisateur(String identifiant, int age, String genre, int langue) {
            this.listSession = new ArrayList<>();
            this.identifiant = identifiant;
            this.age = age;
            this.genre = genre;
            this.langue = langue;
         //   this.save();
	}
	
		/**
		 * 
		 * @param session
		 */
	public void addSession(Session session)
	{
            this.listSession.add(session);
           // this.save();
	}
        
	//fonction qui sert a modifier les informations d'un utilisateur
	public void update(int age, String genre, int langue) {
            this.age = age;
            this.genre = genre;
            this.langue = langue;
            //this.save();

	}
	
	//affiche un utilisateur
	public String print() {
            String txt;
            txt = "L'utilisateur " + this.identifiant + " est un";
    
      if (this.genre.compareTo("Femme") == 0)
         txt += "e femme";
      else
        txt += " homme";
      	txt += " qui a " + this.age + " ans et qui étudie l'";
            switch (langue) {
            case 0:
				txt += "anglais";
				break;
            case 1:
            	txt += "espagnol";
            	break;
            case 2:
            	txt += "italien";
            	break;
            case 3:
            	txt += "allemand";
				break;
			}
            txt +=".";
            return txt; 
	}
        
	
	//retourn l'identifiant
	public String getIdentifiant()
	{
            return this.identifiant;
	}
	
    public int getAge()
    {
        return this.age;
    }
        
        public String getSexe()
        {
            return this.genre;
        }
	//retourn la langue
	public int getLangue()
	{
       return this.langue;
	}
        //liste des sessions
    public ArrayList<Session> getAllSession()
    {
         return this.listSession;
     }
    
	
	


}
