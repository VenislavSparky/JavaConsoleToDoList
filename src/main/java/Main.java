import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        List<String> toDosList = new ArrayList<>();

        System.out.println("Choose command:\n" +
                "Create\n" +
                "Delete\n" +
                "Close\n" +
                "Show\n" +
                "Edit\n");

        String command = scanner.nextLine().trim();

        while (!command.equals("Close")) {
            switch (command) {
                case "Create":
                    System.out.println("Enter name of the new task:");
                    String task = scanner.nextLine().trim();
                    toDosList.add(task);
                    System.out.println("Task " + task + " Created!");
                    break;
                case "Delete":
                    if (toDosList.size() == 0) {
                        System.out.println("There are no tasks to delete!");
                        break;
                    }
                    System.out.println("Enter name of the task to delete:");
                    task = scanner.nextLine().trim();
                    if (!toDosList.contains(task)) {
                        System.out.println("There is no such task!");
                        break;
                    }
                    toDosList.remove(task);
                    System.out.println("Task " + task + " Deleted!");
                    break;
                case "Show":
                    if (toDosList.isEmpty()) {
                        System.out.println("The list is empty there is nothing to show!");
                        break;
                    }
                    toDosList.sort(String::compareTo);
                    int numberOfTask = 1;
                    System.out.println("Tasks:");
                    for (String toDo : toDosList) {
                        System.out.println(numberOfTask + ". " + toDo);
                        numberOfTask++;
                    }
                    break;
                case "Edit":
                    if (toDosList.isEmpty()) {
                        System.out.println("There are no tasks to edit!");
                        break;
                    }
                    System.out.println("Enter name of the task to edit:");
                    task = scanner.nextLine().trim();
                    System.out.println("Enter the new name of the task:");
                    String newTask = scanner.nextLine().trim();
                    toDosList.remove(task);
                    toDosList.add(newTask);
                    System.out.println(task + " edited to " + newTask);
                    break;
            }
            command = scanner.nextLine().trim();
        }


    }
}
