package ToDoList;

import java.util.ArrayList;

public class ToDoList {
    private final ArrayList<String> tasks = new ArrayList<>();
    private final ArrayList<Boolean> isCompleted = new ArrayList<>();
    private int size;

    public ToDoList (){
        this.size = 0;
    }

    public void printMenu() {
        System.out.println("\nTo-Do List Application");
        System.out.println("1. Add a task");
        System.out.println("2. View all tasks");
        System.out.println("3. Mark a task as completed");
        System.out.println("4. Remove a task");
        System.out.println("5. Exit");
        System.out.print("Choose an option (1-5) and press Enter: ");
    }

    public void addTask(String str){
        this.size += 1;
        this.tasks.add(this.size - 1, str);
        this.isCompleted.add(this.size - 1, false);
        System.out.println("Task added.");
    }

    public void viewTasks() {
        System.out.println("\nTo-Do List:");
        for(int i = 0; i < this.size; i++){
            String status = this.isCompleted.get(i) ? "Completed" : "Pending";
            System.out.println((i + 1) + ". " + this.tasks.get(i) + " [" + status + "]");
        }
    }

    public void markCompleted(int choice) {
        if (choice > 0 && choice <= this.size) {
            isCompleted.set(choice - 1, true);
            System.out.println("Task marked as completed.");
        } else {
            System.out.println("Invalid task number.");
        }
    }

    public void removeTask(int choice){
        if (choice > 0 && choice <= this.size) {
            this.tasks.remove(choice - 1);
            this.isCompleted.remove(choice - 1);
            this.size--;
            System.out.println("Task removed.");
        } else {
            System.out.println("Invalid task number.");
        }
    }
}
