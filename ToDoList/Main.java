package ToDoList;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<User> users = new ArrayList<>();

    public static void main (String[] args){
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("1. Create a new User");
            System.out.println("2. Add a Task");
            System.out.println("3. Mark Task as Completed");
            System.out.println("4. View Tasks");
            System.out.println("5. Delete a Task");
            System.out.println("6. Exit List");
            System.out.println("Please select an option: ");
            int option = scanner.nextInt();
            scanner.netLine();

            switch (otion) {
                case 1:
                    createUser(scanner);
                    break;
                case 2:
                    addTask(scanner);
                    break;
                case 3:
                    markTaskComplete(scanner);
                    break;
                case 4:
                    viewTasks(scanner);
                    break;
                case 5:
                    deleteTask(scanner);
                    break;
                case 6:
                    System.out.println("You are now leaving the list.");
                    return;
                default:
                    System.out.println("Not a valid option - please try again"):
            }
        }
    }
    private static void creatUser(Scanner scanner){
        System.out.print("Please enter a username: ");
        String name = scanner.nextLine();
        users.add(new User(name));
        System.out.println("User created:" +name);
    }

    private static void addTask(Scanner scanner){
        User user = getUser(scanner);
        if(user!=null){
            System.out.print("Enter task description:");
            String description = scanner.nextLine();
            user.addTask(description);
            System.out.println("Task added:"+description);
        }
    }
    private static void viewTasks(Scanner scanner){
        User user = getUser(scanner);
        if(user!=null){
            user.printTasks();
        }
    }
    private static void deleteTask(Scanner scanner){
        User user = getUser(scanner);
        if(user!=null){
            user.printTasks();
            System.out.print("Enter tasks position to delete: ");
            int position = scanner.nextInt();
            scanner.nextLine();
            user.deleteTask(position);
            System.out.println("Task deleted at position:"+position);
        }
    }
    private static User getUser(Scanner scanner){
        System.out.print("Enter a username:")
        String name = scanner.nextLine();
        for (User user:users){
            if(user.getName().equals(name)){
                return user;
            }
        }
        System.out.println("User not found:"+name);
        return null;
    }
}
