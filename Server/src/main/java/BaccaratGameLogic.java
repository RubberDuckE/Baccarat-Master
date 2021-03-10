import java.util.ArrayList;

public class BaccaratGameLogic {

//    private BaccaratGame newGame = new BaccaratGame();
    public static String whoWon(ArrayList<Card> hand1, ArrayList<Card> hand2){
        if(handTotal(hand1) > handTotal(hand2)) return "Player";
        else if(handTotal(hand1) < handTotal(hand2)) return "Banker";
        else return "Tie";
    }

    public static int handTotal(ArrayList<Card> hand){
        int sum = 0;
        for(int i = 0; i < hand.size(); i++){
            if(hand.get(i).getValue() < 10) sum += hand.get(i).getValue();
            if(sum >= 10) sum -= 10;
        }
        return sum;
    }
    public static boolean evaluateBankerDraw(ArrayList<Card> hand, Card playerCard){
        int BankerTotal = handTotal(hand);

        if(BankerTotal > 6) return false;
        else if(BankerTotal < 3) return true;

        if((playerCard == null && BankerTotal < 6) ||
          ((playerCard.getValue() == 0 || playerCard.getValue() == 1 || playerCard.getValue() == 9) && BankerTotal < 4) ||
          ((playerCard.getValue() == 2 || playerCard.getValue() == 3) && BankerTotal < 5) ||
          ((playerCard.getValue() == 4 || playerCard.getValue() == 5) && BankerTotal < 6) ||
          ((playerCard.getValue() == 6 || playerCard.getValue() == 7) && BankerTotal < 7) ||
          (playerCard.getValue() == 8 && BankerTotal < 3)) return true;

        return false;
    }
    public static boolean evaluatePlayerDraw(ArrayList<Card> hand){
        if(handTotal(hand) < 6) return true;
        else return false;
    }

}
