package Observer;

/**
 * Created by lolik on 2017-04-14.
 */
public interface Observable_Interface {

    public int getState() ;

    //we notify all subscribers for every change in state
    public void setState(int state) ;

    //sometimes called attach/register/subscribe/addObserver/addListener()
    public void addObserver(Observer observer);

    //sometimes called detach/unregister/unsubscribe/removeObserver/removeListener()
    public void removeObserver(Observer observer);

    //sometimes called publishAllSubscribers/fire()
    public void notifyAllObservers();

    public int countObservers();
}
