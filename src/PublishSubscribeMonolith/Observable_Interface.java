package PublishSubscribeMonolith;

/**
 * Created by lolik on 2017-04-14.
 */
public interface Observable_Interface {

    public int getState() ;

    //we notify all subscribers for every change in state
    public void setState(int state) ;

    //sometimes called attach/register/subscribe/addObserver/addXXXListener()
    public void addObserver(Observer observer);

    //sometimes called detach/unregister/unsubscribe/removeObserver/removeXXXListener()
    public void removeObserver(Observer observer);

    //sometimes called publishAllSubscribers/fireXXXStateChanged()
    public void notifyAllObservers();

    public int countObservers();
}
