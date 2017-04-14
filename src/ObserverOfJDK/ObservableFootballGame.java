package ObserverOfJDK;

//sometimes called topic\subject\channel
public class ObservableFootballGame extends java.util.Observable {
// implements Observable_Interface{



    // can be any state of the subject. like new article in site, or new goal in football game, or a new medicine in shop
    private String name = "2017 Finals in England. game between liverpool and totenham";
    private boolean gameStarted=false;
    private boolean gameInHalfTime=false;
    private boolean gameFinished=false;
    private int minuiteOfGoal=-1;
    private int goalsTeamHome=0;
    private int goalsTeamVisitor=0;
    private boolean newGoalForTeamHome=false;
    private boolean newGoalForTeamVisitor=false;
    private String results="0:0";

    public String getName() {
        return name;
    }

    public void setGameStarted(boolean gameStarted) {
        this.gameStarted = gameStarted;
        setChanged();
        notifyObservers("game has Started. "+goalsTeamHome+":"+goalsTeamVisitor);
    }

    public void setGameInHalfTime(boolean gameInHalfTime) {
        this.gameInHalfTime = gameInHalfTime;
        setChanged();
        notifyObservers("45 minuites finished.         half time result is "+goalsTeamHome+":"+goalsTeamVisitor+" to be continued....");
    }

    public void setGameFinished(boolean gameFinished) {
        this.gameFinished = gameFinished;
        setChanged();
        notifyObservers("this amazing game has finished. ..final result is "+goalsTeamHome+":"+goalsTeamVisitor +". thank you.");
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