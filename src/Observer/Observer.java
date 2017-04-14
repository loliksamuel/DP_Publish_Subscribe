package Observer;

//sometimes called subscriber or Listener
public abstract class Observer {
    //sometimes called topic\channel
    protected ObservableTopic subject;//this class has reference to subject class . also class subject has reference to this class

    //sometimes called subscribe/register/listen()
    public void register(){
        subject.addObserver(this);
    }

    //sometimes called fire/actionPerformed/publish
    public abstract void update();
}