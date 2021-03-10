import java.util.ArrayList;

public class BaccaratGame {

    public ArrayList<Card> playerHand;
    public ArrayList<Card> bankerHand;
    public BaccaratDealer theDealer;
    public double currentBet;
    public double totalWinnings;
    public String betChoice;

    public BaccaratGame(){
        playerHand = new ArrayList<>();
        bankerHand = new ArrayList<>();
        theDealer = new BaccaratDealer();
        currentBet = 0;
        totalWinnings = 0;
        betChoice = "";
    }

    public double evaluateWinnings(){
        BaccaratGameLogic evaluate = new BaccaratGameLogic();
        Card playerCard = null;

        if(evaluate.evaluatePlayerDraw(playerHand) == true){
            playerCard = theDealer.drawOne();
            playerHand.add(playerCard);
        }
        if(evaluate.evaluateBankerDraw(bankerHand, playerCard) == true){
            bankerHand.add(theDealer.drawOne());
        }


        if (evaluate.whoWon(playerHand, bankerHand).equals(betChoice)){
            if(betChoice.equals("Player")){
                totalWinnings += currentBet;
                System.out.println("Player wins!");
                return currentBet;
            }
            else if(betChoice.equals("Banker")){
                totalWinnings += (0.95)*currentBet;
                System.out.println("Player wins!");
                return (0.95)*currentBet;
            }
            else if(betChoice.equals("Tie")){
                totalWinnings += (7)*currentBet;
                System.out.println("Player wins!");
                return (7)*currentBet;
            }
        }
        System.out.println("Player loses!");
        return currentBet*(-1);
    }

}
