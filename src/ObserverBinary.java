public class ObserverBinary extends Observer{

    public ObserverBinary(Subject subject){
        this.subject = subject;
    }

    @Override
    public void update() {
        System.out.println( "new update in mail: Binari String changed to: " + Integer.toBinaryString( subject.getState() )+"("+subject.getState()+")" );
    }
}