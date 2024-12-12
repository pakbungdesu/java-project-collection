
package MathQuizzes;
import java.util.Random;

public class Question {
    private int operand1, operand2;
    private String operator;
    private double correctAnswer;

    private void setQuestion (){
        Random rand = new Random();
        String[] arr = {"+", "-", "*", "/"};

        this.operand1 = rand.nextInt(1, 101);
        this.operand2 = rand.nextInt(1, 101);

        int opt = rand.nextInt(4);
        this.operator = arr[opt];

        switch (opt) {
            case 0:
                this.correctAnswer = this.operand1 + this.operand2 * 1.0;
                break;
            case 1:
                this.correctAnswer = this.operand1 - this.operand2 * 1.0;
                break;
            case 2:
                this.correctAnswer = this.operand1 * this.operand2 * 1.0;
                break;
            case 3:
                this.correctAnswer = this.operand1 / (this.operand2 * 1.0);
                break;
        }
    }

    public void generateQuestion (){
        setQuestion();
        System.out.println("Note: If there are floating points, round it to 3 decimal places");
        System.out.println("What is " + this.operand1 + " " + this.operator + " " + this.operand2 + "?");
    }

    public boolean checkAnswer(double answer){
        return answer == this.correctAnswer;
    }
}