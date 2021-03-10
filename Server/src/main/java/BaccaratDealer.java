import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class BaccaratDealer {
    private ArrayList<Card> deck;
    public BaccaratDealer(){
        deck = new ArrayList<Card>();
        generateDeck();
    }
    public void generateDeck(){
        ArrayList<String> suite = new ArrayList<String>();
        suite.add("Hearts");
        suite.add("Diamonds");
        suite.add("Spades");
        suite.add("Clubs");
        for(int i = 0; i < 4; i++){
            for(int j = 1; j <= 13; j++){
                Card newCard = new Card(suite.get(i), j);
                deck.add(newCard);
            }
        }
        Collections.shuffle(deck);

    }
    public ArrayList<Card> dealHand(){
        ArrayList<Card> initialHand = new ArrayList<Card>();
//        Random rand = new Random();
//
//        // picking first random card
//        int n = rand.nextInt(deck.size());
//        initialHand.add(deck.get(n));
//        deck.remove(n);

//        // picking second random card
//        n = rand.nextInt(deck.size());
//        initialHand.add(deck.get(n));
//        deck.remove(n);

        initialHand.add(drawOne());
        initialHand.add(drawOne());
        return initialHand;
    }

    public Card drawOne(){
        Random rand = new Random();
        int n = rand.nextInt(deck.size());
        Card thirdCard = deck.get(n);
        deck.remove(n);
        return  thirdCard;

    }
    public void shuffleDeck(){
        deck.clear();
        generateDeck();
        Collections.shuffle(deck);
    }

    public int deckSize(){
        return deck.size();
    }
}
