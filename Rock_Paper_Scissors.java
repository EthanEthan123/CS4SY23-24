package com.mycompany.rock_paper_scissors;

/**
 *
 * @author Ethan
 */
import static com.mycompany.rock_paper_scissors.Move.compareMoves;
import java.util.Scanner;

public class Rock_Paper_Scissors {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Move rock = new Move("Rock");
        Move paper = new Move("Paper");
        Move scissors = new Move("Scissors");
        Move boo = new Move("error");
        Move playerMove = boo;
        Move computerMove = boo;
        int stop = 0;
        int roundsToWin = 2;

        rock.setStrongAgainst(scissors);
        paper.setStrongAgainst(rock);
        scissors.setStrongAgainst(paper);

        do {
            System.out.printf(
                    "Welcome to Rock, Paper, Scissors. Please choose an option: %n 1. Start game %n 2. Change number of rounds %n 3. Exit application %n");
            String choice1 = sc.nextLine();
            int choice = Integer.parseInt(choice1);

            switch (choice) {
                case (1) -> {
                    int playerPoints = 0;
                    int computerPoints = 0;
                    System.out.printf("This match will be first to %d wins.%n", roundsToWin);
                    do {
                        int random = (int) Math.floor(Math.random() * 3) + 1;
                        switch (random) {
                            case (1) -> {
                                computerMove = rock;
                                break;
                            }
                            case (2) -> {
                                computerMove = paper;
                                break;
                            }
                            case (3) -> {
                                computerMove = scissors;
                                break;
                            }

                        }
                        System.out.printf("The computer has selected its move. Select your move: %n 1. Rock %n 2. Paper%n 3. Scissors%n");

                        String move = sc.nextLine();
                        int player = Integer.parseInt(move);
                        switch (player) {
                            case (1) -> {
                                playerMove = rock;
                                break;
                            }
                            case (2) -> {
                                playerMove = paper;
                                break;
                            }
                            case (3) -> {
                                playerMove = scissors;
                                break;
                            }
                        }
                        int result = compareMoves(playerMove, computerMove);
                        switch (result) {
                            case (0) -> {
                                System.out.printf("Player chose %s. Computer chose %s. Player wins :)%n", playerMove.getName(), computerMove.getName());
                                playerPoints++;
                                System.out.printf("Player: %d - Computer: %d%n%n", playerPoints, computerPoints);
                                break;
                            }
                            case (1) -> {
                                System.out.printf("Player chose %s. Computer chose %s. Computer wins :(%n", playerMove.getName(), computerMove.getName());
                                computerPoints++;
                                System.out.printf("Player: %d - Computer: %d%n%n", playerPoints, computerPoints);
                                break;
                            }
                            case (2) -> {
                                System.out.printf("Player chose %s. Computer chose %s. No-one Wins ?!?!?%n", playerMove.getName(), computerMove.getName());
                                System.out.printf("Player: %d - Computer: %d%n%n", playerPoints, computerPoints);
                                break;
                            }
                        }
                    } while (playerPoints < roundsToWin && computerPoints < roundsToWin);
                    if (playerPoints > computerPoints) {
                        System.out.println("Player Wins!");
                    } else {
                        System.out.println("Computer Wins!");
                    }
                    break;
                }
                case (2) -> {
                    System.out.println("How many wins are needed to win a match?");
                    String wins = sc.nextLine();
                    roundsToWin = Integer.parseInt(wins);
                    System.out.println("New setting has been changed. \n");
                    break;
                }
                case (3) -> {
                    System.out.println("Thanks for Playing! ");
                    stop++;
                    break;
                }
            }
        } while (stop == 0);

    }
}
