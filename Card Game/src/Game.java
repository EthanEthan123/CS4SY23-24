
import java.util.ArrayList;
import java.util.Collections;

public class Game {

    private String previousType;
    private int currentPoints;
    private Player playerOne;
    private Player playerTwo;
    private Player playerCurrent;
    private int playerTracker;
    private int cardsFlipped;

    public Game(Player p, Player q) {
        playerOne = p;
        playerTwo = q;
        Collections.shuffle(Card.deck);
        for(int i = 0; i < 24; i++) {
            Tile.board.get(i).setCardContained(Card.deck.get(i));
        }
        Card.deck.clear();
    }

    public void compare(Tile a, Tile b) {
        if (playerTracker % 2 == 0) {
            playerCurrent = playerOne;
        } else {
            playerCurrent = playerTwo;
        }
        System.out.println(a.getCardContained().getName() + " and " + b.getCardContained().getName());
        if (a.isFlipped() || b.isFlipped()) {
            System.out.println("you already picked that card!");

        } else if (a.getCardContained() == b.getCardContained()) {
            System.out.println("It's a match!");
            System.out.println(a.getCardContained().getTrivia());
            a.setFlipped(true);
            b.setFlipped(true);
            if (a.getCardContained().getType().equals(previousType)) {
                a.getCardContained().special();
                playerCurrent.powerUp(a.getCardContained().getType());
            }
            previousType = a.getCardContained().getType();
            currentPoints += 1000;
        } else {
            if (playerCurrent.isAngelActive()) {
                System.out.println("it's not a match :(");
                System.out.println("your guardian angel saved you!");
                playerCurrent.setAngelActive(false);
            } else {
                System.out.println("it's not a match :(");
                System.out.println(playerCurrent.getName() + " got " + currentPoints + " points!");
                playerCurrent.setTotalPoints(playerCurrent.getTotalPoints() + currentPoints);
                currentPoints = 0;
                playerTracker += 1;
                previousType = null;
                if (playerTracker % 2 == 0) {
                    System.out.println(playerOne.getName() + "'s Turn!");
                } else {
                    System.out.println(playerTwo.getName() + "'s Turn!");
                }
            }
        }
    }

    public void end() {
        System.out.println(playerOne.getName() + " got a total of " + playerOne.getTotalPoints() + " points!");
        System.out.println(playerTwo.getName() + " got a total of " + playerTwo.getTotalPoints() + " points!");
        playerOne.setTotalPoints(0);
        playerTwo.setTotalPoints(0);
    }

    public int getCardsFlipped() {
        return cardsFlipped;
    }

    public void setCardsFlipped(int cardsFlipped) {
        this.cardsFlipped = cardsFlipped;
    }
}
