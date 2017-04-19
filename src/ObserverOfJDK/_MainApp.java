package ObserverOfJDK;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by lolik on 2017-04-01.
 */
public class _MainApp {
    public static void main(String[] args) {




        ObservableFootballGame   gameFootBall   = new ObservableFootballGame();
        ObservableBasketballGame gameBasketBall = new ObservableBasketballGame();


        gameFootBall.addObserver(new ObserverFootball());

        gameBasketBall.addObserver(new Observer() {
            @Override
            public void update(Observable o, Object arg) {
                System.out.println(((ObservableBasketballGame)o).getName()+": ObserverBaksetBall got The news:"+(String)arg );

            }
        });
        gameFootBall.setGameStarted(true);
        gameFootBall.setMinuiteOfGoal(12,true);
        gameFootBall.setGameInHalfTime(true);
        gameFootBall.setMinuiteOfGoal(46,true);
        gameBasketBall.setGameStarted(true);
        gameFootBall.setMinuiteOfGoal(56,false);
        gameFootBall.setMinuiteOfGoal(86,false);
        gameFootBall.setMinuiteOfGoal(92,false);
        gameFootBall.setGameFinished(true);

    }
}
