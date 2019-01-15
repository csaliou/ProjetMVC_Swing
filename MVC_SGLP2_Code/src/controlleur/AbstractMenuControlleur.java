package controlleur;
import java.util.ArrayList;
import model.observer.Observable;
import model.observer.Observer;
import vue.TypeWindow;

//abstraction de chaque menu qui implemente l'observable
public abstract class AbstractMenuControlleur implements Observable {
    private ArrayList<Observer> listObserver = new ArrayList<Observer>();
    
    //Implémentation du pattern observer
    public void addObserver(Observer obs) {
        this.listObserver.add(obs);
    }

    //fonction qui sert à notifier tous les observer
    public void notifyObserver(TypeWindow tw) {
        for(Observer obs : listObserver)
            obs.update(tw);
    }

    //fonction qui sert a supprimer un observer
    public void removeObserver() {
        listObserver = new ArrayList<Observer>();
    }  
}
