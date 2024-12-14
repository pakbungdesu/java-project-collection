package WordGuessing;
import java.util.Locale;
import java.util.Scanner;

public class PlayGame {

    public static void main (String[] args){
        Scanner scanner = new Scanner(System.in);
        GameManager mygame = new GameManager();
        boolean complete = false;

        while(!complete && mygame.getLives() > 0){
            mygame.displayWord();
            mygame.displayBeforeGuess();
            String guessStr = scanner.nextLine().toLowerCase(Locale.ROOT);
            char guessChar = guessStr.charAt(0);
            mygame.displayAfterGuess(guessChar);
            complete = mygame.completeOrNot();
        }

        if(complete){
            System.out.println("You win! Congratulation.");
        } else {
            System.out.println("You lost!");
        }
        System.out.println("The word is " + mygame.getWordToGuess());
    }
}
