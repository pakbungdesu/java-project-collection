
package MathQuizzes;
import java.util.Scanner;

public class MathQuiz {
    int score;

    MathQuiz (){ this.score = 0;}

    public void startQuiz(){
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 5; i++) { // 5 questions per quiz
            askQuestion(sc);
        }
        System.out.println("Your final score is: " + score + "/5");
        sc.close();
    }

    public void askQuestion(Scanner sc){
        Question q = new Question();
        q.generateQuestion();
        double answer = sc.nextDouble();

        if (q.checkAnswer(answer)) {
            System.out.println("Correct!");
            this.score++;
        } else {
            System.out.println("Incorrect.");
        }
    }
}
