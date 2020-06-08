package PublishSubscribeMonolith;

//sometimes called subscriber or Listener
public abstract class Observer {
    //sometimes called topic\channel
    protected ObservableTopic subject;//this class has reference to subject class . also class subject has reference to this class

    //sometimes called register/subscribe/register/listen/addXXXListener()
    public void observe(){
        subject.addObserver(this);
    }
    //sometimes called fireXXX/actionPerformed/publish\onEvent  this fuction get executed when a new getUpdates\event occur
    public abstract void getUpdates();
}