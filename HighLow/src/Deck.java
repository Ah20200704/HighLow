import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

    //makes a list of cards
    private List<Card> cards;

    //size = the amount of cards left over after dealing 
    private int size;


    //Constructor for the deck class
    public Deck(String[] ranks, String[] suits, int[] pointValues) {
        cards = new ArrayList<Card>();
        for(int i =0; i<ranks.length; i++){
            for(int s =0; s <suits.length; s++){
                size += 1;
                Card obj = new Card(ranks[i], suits[s], pointValues[i]);
                cards.add(obj);
            }
        }
            Collections.shuffle(cards);
    }


    //returns true if the deck is empty
    public boolean isEmpty() {
        if(size() == 0){
            return true;
        }
        else{
            return false;
        }
    }

    //returns size 
    public int size() {
        return size;
    }

    //randomly shuffle cards
    public void randomShuffle(){
        Collections.shuffle(cards);
    }

    //deals cards
    public Card deal() {
        if(size > 0){
            size -= 1;
            Collections.shuffle(cards);
            return cards.get(size);
        }
        else{
            return null;
        }
    }


    //returns size and and undealt cards in a string 
    public String toString() {
        String rtn = "size = " + size + "\nUndealt cards: \n";

        for (int k = size - 1; k >= 0; k--) {
            rtn = rtn + cards.get(k);
            if (k != 0) {
                rtn = rtn + ", ";
            }
            if ((size - k) % 2 == 0) {
                // Insert carriage returns so entire deck is visible on console.
                rtn = rtn + "\n";
            }
        }

        rtn = rtn + "\nDealt cards: \n";
        for (int k = cards.size() - 1; k >= size; k--) {
            rtn = rtn + cards.get(k);
            if (k != size) {
                rtn = rtn + ", ";
            }
            if ((k - cards.size()) % 2 == 0) {
                // Insert carriage returns so entire deck is visible on console.
                rtn = rtn + "\n";
            }
        }

        rtn = rtn + "\n";
        return rtn;
    }
}