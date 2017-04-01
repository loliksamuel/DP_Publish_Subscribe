import java.util.ArrayList;
import java.util.List;
//sometimes called topic\channel
public class Subject {

    private List<Observer> observers = new ArrayList<Observer>();
    private int state;

    public int getState() {
        return state;
    }
   //we notify all subscribers for every change in state
    public void setState(int state) {
        this.state = state;
        notifyAllObservers();
    }
    //sometimes called register/addSubscriber/addListener()
    public void attach(Observer observer){
        observers.add(observer);
    }
    //sometimes called unregister/removeSubscriber
    public void detach(Observer observer){
        observers.remove(observer);
    }
    //sometimes called publishAllSubscribers/fire()
    public void notifyAllObservers(){
        for (Observer observer : observers) {
            observer.update();
        }
    }
}