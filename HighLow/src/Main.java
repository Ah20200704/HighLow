import javax.swing.*;

public class Main {

    private static int loss;
    private static int wins;
    private static Card card;
    private static Card card2;
    private static int cardCount;
    static String[] Rank = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
    static int[] pointValue = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
    static String[] Suit = {"Clubs", "Diamond", "Spades", "Hearts"};
    static String[] option1 = {"Higher", "Lower", "Exit"};


    public static void main(String[] args) {
        loss = 0;
        wins = 0;
        cardCount = 0;
        JOptionPane.showMessageDialog(null, "                      Welcome to High-LO!\n" +
                "                        The game is real simple\n" 
                + "Just check if the current card is higher or lower than the next card.\n"
                + "             If you get five guesses wrong it's curtains for you\n"
                + "              If you clear the deck, you win the whole game \n"
                + "                                        Lets play!");

        Deck deck = new Deck(Rank, Suit, pointValue);
        while (cardCount < 26 && loss < 5) {
            card = deck.deal();
            card2 = deck.deal();	
            int x = Window.option(option1, "Do you think this card will be higher or lower than the next one?\nCorrect guesses: " +wins + "\n" + card);

            if (x == 0) {
                if(card.pointValue() == card2.pointValue()){
                    JOptionPane.showMessageDialog(null, "ULTRA RARE! SAME CARD VALUE!!!!\nNothing happens lol");
                    wins=wins;
                }
                else if (card.pointValue() > card2.pointValue()) {
                    JOptionPane.showMessageDialog(null, "Right :D ! Other card is " + card2);
                    wins++;
                } else  {
                    JOptionPane.showMessageDialog(null, "Wrong ;( . Other card is " + card2);
                    loss++;
                }
            }
            if (x == 1) {
                if(card.pointValue() == card2.pointValue()){
                    JOptionPane.showMessageDialog(null, "ULTRA RARE! SAME CARD VALUE!!!!\nNothing happens lol");
                }
                if (card.pointValue() < card2.pointValue()) {
                    JOptionPane.showMessageDialog(null, "Right :D ! Other card is " + card2);
                    wins++;
                } else {
                    JOptionPane.showMessageDialog(null, "Wrong ;( . Other card is " + card2);
                    loss++;
                }
            }

            if (x == 2) {
                System.exit(0);
            }

        }
        if(loss == 5){
            JOptionPane.showMessageDialog(null, "You got Five Wrong, You lose! \n Do better next time kid \nCorrect guesses: " + wins);
        }
        if(cardCount == 26){
            JOptionPane.showMessageDialog(null, "You done did it! You went through all 52 cards and got " + loss +" wrong! \n"
            		+ "                             Good job");
        }
    }
}


