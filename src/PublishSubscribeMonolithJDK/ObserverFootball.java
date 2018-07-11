package PublishSubscribeMonolithJDK;
import java.util.Observable;

public class ObserverFootball implements java.util.Observer{


    @Override
    public void update(Observable o, Object arg) {
        System.out.println(((ObservableFootballGame)o).getName()+" : ObserverFootball got The news:"+(String)arg );
    }
}