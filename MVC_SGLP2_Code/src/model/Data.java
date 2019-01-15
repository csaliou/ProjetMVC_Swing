package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
/**
 * 
 * @author Cheikh Saliou Ndiaye
 *
 */
public class Data {

    private ArrayList<Utilisateur> listUser; //liste des users
    private Utilisateur userConnected; // si user est connecté
    private Session session; // session pour enregistrer les données
    public Data()
    {
        this.userConnected = null;
        this.session = null;
        this.listUser = new ArrayList<>();
    }
    /**
     * 
     * @param identifiant
     * @param age
     * @param genre
     * @param langue
     * ajouter utilisateur dans la liste (listUser)
     */
    public void addUser(String identifiant, int age, String genre, int langue)
    {
        Utilisateur user = new Utilisateur(identifiant, age, genre, langue);
        this.listUser.add(user);

    }
    /**
     * 
     * @param type_lecon
     * @param num_exo
     * @param langue
     * ajouter l'exo dans la session
     */
    public void doExercice(int type_lecon, int num_exo, int langue)
    {
        Exercice exo = new Exercice(type_lecon, num_exo, langue);
        this.session.addExercice(exo);
    }
    /**
     * demarrer la session
     */
    public void startSession()
    {
        this.session = new Session();
    }
    /**
     * connexion anonyme
     * @return boolean (true |false )
     * true si l'utilisateurConnected est nul
     */
    public boolean isAnonymous()
    {
        if (this.userConnected == null)
            return true;
        return false;
    }
    /**
     * 
     * @param String identifiant
     * return bool true|false
     */
    
    public boolean connectUser(String identifiant)
    {
    	//parcours liste user
        for(int i = 0; i < this.listUser.size(); i++)
        {
        	// user
            Utilisateur user = this.listUser.get(i);
            
            if (user.getIdentifiant().compareTo(identifiant) == 0)
            {
                this.userConnected = user;
		return true;
            }
        }
       	return false;
    }
   /**
    * fonction deconnecter utilisateur
    * verifie si user est connecter si oui oui arreter la session
    * deconnexion user 
    */
    public void disconnectUser()
    {
        if (this.userConnected != null)
        {
        	// session existe
            if (session != null)
            {
            	//fin de session
                this.session.endSession();
                this.userConnected.addSession(session);
            }
        }
        //deconnexion user & session
        this.userConnected = null;
        this.session = null;
    }
    

    
    /**
     *  verifie si l'identifiant n'existe pas déja
     * @param String id
     * @return true |false 
     */
    public boolean checkUtilisateurExist(String id) {
	for(int i = 0; i < this.listUser.size(); i++)
	{
            Utilisateur user = this.listUser.get(i);
            if (user.getIdentifiant().compareTo(id) == 0)
            {
		return false;
            }
     }
       	return true;
    }

    // utilisateur connecté
    public Utilisateur getUserConnected()
    {
        return this.userConnected;
    }
    
    //listUser
    public ArrayList<Utilisateur> getAllUtil()
    {
        return this.listUser;
    }
    
    // session (get)
    public Session getSession()
    {
        this.session.endSession();
        return this.session;
    }
    
	
	
	
	
	
}
