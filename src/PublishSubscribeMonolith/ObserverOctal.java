package PublishSubscribeMonolith;

public class ObserverOctal extends Observer{

    public ObserverOctal(ObservableTopic subject){
        this.subject = subject;
    }

    @Override
    public void update() {
        System.out.println( "new update in mail: Octal String changed to: " + Integer.toOctalString( subject.getState() ) +"("+subject.getState()+")" );
    }
}