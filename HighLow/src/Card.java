public class Card {   
     //String that holds the suit of the card
   
    private String suit;

    // String that holds the rank of the card
     
    private String rank;

    
    // int value that holds the point value.
    
    private int pointValue;


   //Constructor for card class
    public Card(String cardRank, String cardSuit, int cardPointValue) {
        rank = cardRank;
        suit = cardSuit;
        pointValue = cardPointValue;
    }


    //returns card suit
    public String suit() {
        return suit;
    }

    //returns the cards rank
    public String rank() {
        return rank;
    }

    //returns point value
    public int pointValue() {
        return pointValue;
    }

    //returns if card is the same as the other
    public boolean matches(Card otherCard) {
        if(suit.equals(otherCard.suit) && pointValue == otherCard.pointValue && rank.equals(otherCard.rank)){
            return true;
        }
        else{
            return false;
        }
    }

    //returns the rank and suit of a card in the form of a string
    	public String toString() {
        return rank + " of " + suit;
    }
}