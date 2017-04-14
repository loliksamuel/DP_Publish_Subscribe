package ObserverOfJDK;
import java.util.Observable;

public class ObserverFootball implements java.util.Observer{


    @Override
    public void update(Observable o, Object arg) {
        System.out.println("FirstNewsReader got The news:"+(String)arg);

    }
}