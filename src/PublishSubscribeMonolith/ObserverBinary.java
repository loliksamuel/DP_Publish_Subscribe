package PublishSubscribeMonolith;

public class ObserverBinary extends Observer{

    public ObserverBinary(ObservableTopic subject){
        this.subject = subject;
    }

    @Override
    public void getUpdates() {
        System.out.println( "new getUpdates in mail: Binari String changed to: " + Integer.toBinaryString( subject.getState() )+"("+subject.getState()+")" );
    }
}