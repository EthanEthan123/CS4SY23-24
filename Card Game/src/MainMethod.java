import java.util.ArrayList;
import java.util.Scanner;

public class MainMethod {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Tile t1 = new Tile();
        Tile t2 = new Tile();
        Tile t3 = new Tile();
        Tile t4 = new Tile();
        Tile t5 = new Tile();
        Tile t6 = new Tile();
        Tile t7 = new Tile();
        Tile t8 = new Tile();
        Tile t9 = new Tile();
        Tile t10 = new Tile();
        Tile t11 = new Tile();
        Tile t12 = new Tile();
        Tile t13 = new Tile();
        Tile t14 = new Tile();
        Tile t15 = new Tile();
        Tile t16 = new Tile();
        Tile t17 = new Tile();
        Tile t18 = new Tile();
        Tile t19 = new Tile();
        Tile t20 = new Tile();
        Tile t21 = new Tile();
        Tile t22 = new Tile();
        Tile t23 = new Tile();
        Tile t24 = new Tile();

        FlyingAnimal A = new FlyingAnimal("bird", "this is a bird!");
        FlyingAnimal B = new FlyingAnimal("pig", "this is a pig!");
        LandAnimal C = new LandAnimal("horse", "this is a horse!");
        LandAnimal D = new LandAnimal("human", "this is a human!");
        AquaticAnimal E = new AquaticAnimal("fish", "this is a fish!");
        AquaticAnimal F = new AquaticAnimal("shark", "this is a shark!");
        FlyingAnimal G = new FlyingAnimal("eagle", "this is an eagle!");
        FlyingAnimal H = new FlyingAnimal("eraser", "this is an eraser!");
        LandAnimal I = new LandAnimal("pikachu", "this is a pikachu!");
        LandAnimal J = new LandAnimal("hedgehog", "this is a hedgehog!");
        AquaticAnimal K = new AquaticAnimal("whale", "this is a whale!");
        AquaticAnimal L = new AquaticAnimal("octopus", "this is an octopus!");

        Player first = new Player("Sandy");
        Player second = new Player("Jekjek");
        boolean gameend = false;
        String tile;
        String tile2;
        Game one = new Game(first, second);
        for (int i = 0; i < 24; i++) {
            System.out.println(Tile.board.get(i).getCardContained().getName());
        }
        
        while(one.getCardsFlipped() < 24) {
            System.out.println("Which tile? ");
            tile = sc.nextLine();
            System.out.println("Which tile? ");
            tile2 = sc.nextLine();
            one.compare(Tile.board.get(Integer.parseInt(tile)), Tile.board.get(Integer.parseInt(tile2)));
            one.setCardsFlipped(0);
            for(int i = 0; i < 24; i++) {
                if (Tile.board.get(i).isFlipped()) {
                    one.setCardsFlipped(one.getCardsFlipped()+ 1);
                }
                else {
                    one.setCardsFlipped(0);
                }
            }
        }
        one.end();
    }

}
