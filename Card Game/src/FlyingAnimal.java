
public class FlyingAnimal extends Card {

    public FlyingAnimal(String n, String t) {
        super(n, t);
        type = "flying";
        
    }
    
    public void special() {
        System.out.println("Guardian Angel... Activate!");
    }
}
