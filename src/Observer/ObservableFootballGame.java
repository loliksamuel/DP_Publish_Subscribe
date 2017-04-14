package Observer;

import java.util.Observable;

//sometimes called topic\subject\channel
public class ObservableFootballGame extends Observable {
// implements Observable_Interface{

    // can be any state of the subject. like new article in site, or new goal in football game, or a new medicine in shop
    private boolean gameStarted;
    private boolean gameInHalfTime;
    private boolean gameFinished;
    private int minuiteOfGoal;
    private int goalsTeamHome;
    private int goalsTeamVisitor;
    private boolean newGoalForTeamHome;
    private boolean newGoalForTeamVisitor;
    private String results;

    public void setGameStarted(boolean gameStarted) {
        this.gameStarted = gameStarted;
        setChanged();
        notifyObservers("game has Started. "+goalsTeamHome+":"+goalsTeamVisitor);
    }

    public void setGameInHalfTime(boolean gameInHalfTime) {
        this.gameInHalfTime = gameInHalfTime;
        setChanged();
        notifyObservers("45 minuites finished. half time result is "+goalsTeamHome+":"+goalsTeamVisitor);
    }

    public void setGameFinished(boolean gameFinished) {
        this.gameFinished = gameFinished;
        setChanged();
        notifyObservers("game has finished. final result is "+goalsTeamHome+":"+goalsTeamVisitor);
    }


    //we notify all subscribers for every change in minuiteOfGoal
    public void setMinuiteOfGoal(int minuiteOfGoal, boolean isHomeTeam) {
        if (isHomeTeam==true)
            goalsTeamHome++;
        else
            goalsTeamVisitor++;
        setChanged();
        notifyObservers(minuiteOfGoal +" minutes in game... new goal. current result is "+goalsTeamHome+":"+goalsTeamVisitor);
    }



}