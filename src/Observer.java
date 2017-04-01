//sometimes called subscriber or Listener
public abstract class Observer {
    //sometimes called topic\channel
    protected Subject subject;

    //sometimes called subscribe or listen
    public void register(){
        subject.attach(this);
    }

    //sometimes called fire/actionPerformed/publish
    public abstract void update();
}