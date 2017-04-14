package Observer;

import java.util.ArrayList;
import java.util.List;
//sometimes called topic\subject\channel
public class ObservableTopic implements Observable_Interface{
// implements Observable_Interface{
    //extends Observable {

    private List<Observer> observers = new ArrayList<Observer>();

    // can be any state of the subject. like new article in site, or new goal in football game, or a new medicine in shop
    private int state;

    //get the state
    public int getState() {
        return state;
    }

    //we notify all subscribers for every change in state
    public void setState(int state) {
        this.state = state;
        notifyAllObservers();
    }

    //sometimes called register/subscribe/addListener()
    public void addObserver(Observer observer){
        observers.add(observer);
    }

    //sometimes called unregister/removeSubscriber
    public void removeObserver(Observer observer){
        observers.remove(observer);
    }

    //sometimes called publishAllSubscribers/fire()
    public void notifyAllObservers(){
        for (Observer observer : observers) {
            observer.update();
        }
    }

    public int countObservers(){
        return observers.size();
    }

}