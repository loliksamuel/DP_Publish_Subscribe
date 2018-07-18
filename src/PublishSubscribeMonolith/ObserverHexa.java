package PublishSubscribeMonolith;

public class ObserverHexa extends Observer{

    public ObserverHexa(ObservableTopic subject){
        this.subject = subject;
    }

    @Override
    public void getUpdates() {
        System.out.println( "new getUpdates in mail: Hex String changed to: " + Integer.toHexString( subject.getState() ).toUpperCase() +"("+subject.getState()+")" );
    }
}