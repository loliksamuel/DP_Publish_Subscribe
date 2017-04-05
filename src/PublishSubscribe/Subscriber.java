package PublishSubscribe;

//sometimes called subscriber or Listener
public abstract class Subscriber {
    //sometimes called topic\channel
    protected Subscriber.Subject subject;

    //sometimes called subscribe or listen
    public void register(){
        subject.attach(this);
    }

    //sometimes called fire/actionPerformed/publish
    public abstract void update();
}