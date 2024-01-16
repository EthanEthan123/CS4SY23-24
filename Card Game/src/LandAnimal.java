
public class LandAnimal extends Card {

    public LandAnimal(String n, String t) {
        super(n, t);
        type = "land";
    }
    
    public void special() {
        System.out.println("EARTHQUAKE!!!!");
        
    }
}
