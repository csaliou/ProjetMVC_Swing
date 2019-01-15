package model.observer;

import vue.TypeWindow;

public interface Observable {
    //Implémentation du pattern observer
  public void addObserver(Observer obs);
  //fonction qui sert à notifier tous les observer
  public void notifyObserver(TypeWindow tw);
  //fonction qui sert a supprimer un observer
  public void removeObserver();
}
