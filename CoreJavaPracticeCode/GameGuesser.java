import java.util.Scanner;

class Guesser {
    int guessNum() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Guesser kindly guess the number:");
        int guessNum = sc.nextInt();
        sc.close();
        return guessNum;
    }
}

class Player {
    int guessNum() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Player kindly guess the number:");
        int guessNum = sc.nextInt();
        sc.close();
        return guessNum;
    }
}

class Umpire {
    int numFromGuesser;
    int numFromPlayer1;
    int numFromPlayer2;
    int numFromPlayer3;

    void collectNumFromGuesser() {
        Guesser g = new Guesser();
        numFromGuesser = g.guessNum();
    }

    void collectNumFromPlayer() {
        Player p1 = new Player();
        Player p2 = new Player();
        Player p3 = new Player();
        numFromPlayer1 = p1.guessNum();
        numFromPlayer2 = p2.guessNum();
        numFromPlayer3 = p3.guessNum();
    }

    void compare() {
        if (numFromGuesser == numFromPlayer1) {
            System.out.println("Player 1 won the game");
        } else if (numFromGuesser == numFromPlayer2) {
            System.out.println("Player 2 won the game");
        } else if (numFromGuesser == numFromPlayer3) {
            System.out.println("Player 3 won the game");
        } else {
            System.out.println("Game lost. Try Again!");
        }
    }
}

public class GameGuesser {
    public static void main(String[] args) {
        Umpire umpire = new Umpire();

        umpire.collectNumFromGuesser();
        umpire.collectNumFromPlayer();
        umpire.compare();
    }
}
