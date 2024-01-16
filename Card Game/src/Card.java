
import java.util.ArrayList;

public abstract class Card {

    private String name;
    private String trivia;
    private int points;
    public String type;
    public static ArrayList<Card> deck = new ArrayList<>();

    public Card(String n, String t) {
        name = n;
        trivia = t;
        deck.add(this);
        deck.add(this);
    }

    public String getName() {
        return name;
    }

    public String getTrivia() {
        return trivia;
    }

    public String getType() {
        return type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract void special();


}
