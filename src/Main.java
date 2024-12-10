
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        boolean running = true;
        Scanner scanner = new Scanner(System.in);
        ToDoList memo = new ToDoList();

        while (running){
            memo.printMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter the task: ");
                    String task = scanner.nextLine();
                    memo.addTask(task);
                    break;
                case 2:
                    memo.viewTasks();
                    break;
                case 3:
                    System.out.print("Enter the task number to mark as completed: ");
                    int comNum = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    memo.markCompleted(comNum);
                    break;
                case 4:
                    System.out.print("Enter the task number to remove: ");
                    int removeNum = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    memo.removeTask(removeNum);
                    break;
                case 5:
                    running = false;
                    System.out.println("Exiting the application. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                }
        }
    }
}