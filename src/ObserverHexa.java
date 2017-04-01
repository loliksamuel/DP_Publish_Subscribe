public class ObserverHexa extends Observer{

    public ObserverHexa(Subject subject){
        this.subject = subject;
    }

    @Override
    public void update() {
        System.out.println( "new update in mail: Hex String changed to: " + Integer.toHexString( subject.getState() ).toUpperCase() +"("+subject.getState()+")" );
    }
}