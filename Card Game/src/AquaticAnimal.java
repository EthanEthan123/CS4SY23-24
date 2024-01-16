
public class AquaticAnimal extends Card {

    public AquaticAnimal(String n, String t) {
        super(n, t);
        type = "aquatic";
    }
    
    public void special() {
        System.out.println("Double Trouble!");
        
    }
}
