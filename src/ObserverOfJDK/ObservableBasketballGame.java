package ObserverOfJDK;

//sometimes called topic\subject\channel
public class ObservableBasketballGame extends java.util.Observable {
// implements Observable_Interface{



    // can be any state of the subject. like new article in site, or new goal in football game, or a new medicine in shop
    private String name = "2017 NBA Finals . game between cleavelenad and goldenstate";
    private boolean gameStarted=false;
    private boolean gameInHalfTime=false;
    private boolean gameFinished=false;
    private int minuiteOfBasket=-1;
    private int BasketsTeamHome=0;
    private int BasketsTeamVisitor=0;
    private boolean newBasketForTeamHome=false;
    private boolean newBasketForTeamVisitor=false;
    private String results="0:0";

    public String getName() {
        return name;
    }

    public void setGameStarted(boolean gameStarted) {
        this.gameStarted = gameStarted;
        setChanged();
        notifyObservers("game has Started. "+BasketsTeamHome+":"+BasketsTeamVisitor);
    }

    public void setGameInHalfTime(boolean gameInHalfTime) {
        this.gameInHalfTime = gameInHalfTime;
        setChanged();
        notifyObservers("45 minuites finished.         half time result is "+BasketsTeamHome+":"+BasketsTeamVisitor+" to be continued....");
    }

    public void setGameFinished(boolean gameFinished) {
        this.gameFinished = gameFinished;
        setChanged();
        notifyObservers("this amazing game has finished. ..final result is "+BasketsTeamHome+":"+BasketsTeamVisitor +". thank you.");
    }


    //we notify all subscribers for every change in minuiteOfBasket
    public void setMinuiteOfBasket(int minuiteOfBasket, boolean isHomeTeam) {
        if (isHomeTeam==true)
            BasketsTeamHome++;
        else
            BasketsTeamVisitor++;
        setChanged();
        notifyObservers(minuiteOfBasket +" minutes in game... new Basket. current result is "+BasketsTeamHome+":"+BasketsTeamVisitor);
    }



}