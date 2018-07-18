package PublishSubscribeMonolith;

public class ObserverOctal extends Observer{

    public ObserverOctal(ObservableTopic subject){
        this.subject = subject;
    }

    @Override
    public void getUpdates() {
        System.out.println( "new getUpdates in mail: Octal String changed to: " + Integer.toOctalString( subject.getState() ) +"("+subject.getState()+")" );
    }
}