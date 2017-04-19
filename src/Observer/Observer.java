package Observer;

//sometimes called subscriber or Listener
public abstract class Observer {
    //sometimes called topic\channel
    protected ObservableTopic subject;//this class has reference to subject class . also class subject has reference to this class

    //sometimes called subscribe/register/listen/addXXXListener()
    public void register(){
        subject.addObserver(this);
    }
    //sometimes called fireXXX/actionPerformed/publish\onEvent  this fuction get executed when a new update\event occur
    public abstract void update();
}