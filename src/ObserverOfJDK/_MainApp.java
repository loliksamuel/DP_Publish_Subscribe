package ObserverOfJDK;

/**
 * Created by lolik on 2017-04-01.
 */
public class _MainApp {
    public static void main(String[] args) {




        ObservableFootballGame game = new ObservableFootballGame();
        ObserverFootball observer = new ObserverFootball();
        game.addObserver(observer);
        game.setGameStarted(true);
        game.setMinuiteOfGoal(12,true);
        game.setGameInHalfTime(true);
        game.setMinuiteOfGoal(46,true);
        game.setMinuiteOfGoal(56,false);
        game.setMinuiteOfGoal(86,false);
        game.setMinuiteOfGoal(92,false);
        game.setGameFinished(true);

    }
}
