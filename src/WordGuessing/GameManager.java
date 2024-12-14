package WordGuessing;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class GameManager {
    private String wordToGuess;
    private int lives;
    private int[] showOrNot;

    // default constructor
    public GameManager(){
        Random rand = new Random();
        int rand_idx = rand.nextInt(1, 1023);
        int i = 1;
        String line;
        String filePath = "src/WordGuessing/words.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            while ((line = br.readLine()) != null) {
                this.wordToGuess = line;
                this.lives = line.length();
                if(i == rand_idx){ break; }
                i++;
            }
            this.showOrNot = new int[this.lives];
            randDisplay();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void randDisplay(){
        for(int i = 0; i < this.wordToGuess.length(); i++){
            Random rand = new Random();
            this.showOrNot[i] = rand.nextInt(2);
            }
    }

    private boolean checkGuess(char guess){
        boolean found = false;
        for(int i = 0; i < this.wordToGuess.length(); i++){
            if(guess == this.wordToGuess.charAt(i)){
                this.showOrNot[i] = 1;
                found = true;
            }
        }
        return found;
    }

    public void displayAfterGuess(char guess){
        boolean found = checkGuess(guess);
        if(found){
            System.out.println("You're right!");
        } else {
            lives -= 1;
            System.out.println("You're incorrect. There is no " + guess + " in the word!");
        }
    }

    public void displayBeforeGuess(){
        System.out.println("Your lives: " + this.lives);
        System.out.println("Guess a letter: ");
    }

    public void displayWord() {
        for (int i = 0; i < this.wordToGuess.length(); i++) {
            if(this.showOrNot[i] == 1){
                System.out.print(this.wordToGuess.charAt(i) + " ");
            } else {
                System.out.print(" _ ");
            }
        }
        System.out.println();
    }

    public boolean completeOrNot(){
        boolean complete = true;
        for (int j : this.showOrNot) {
            if (j == 0) {
                complete = false;
                break;
            }
        }
        return complete;
    }

    public String getWordToGuess() {
        return this.wordToGuess;
    }

    public int getLives(){
        return this.lives;
    }
}
