import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Implement a to do list. Tasks have a priority between 
 * 1 and 9 (with 1 being most urgent), and a description.
 * When the user enters the command 'add priority description', 
 * the program adds a new task. When the user enters next, 
 * the program removes and prints the most urgent task. 
 * The quit command quits the program. 
 * Use a priority queue in your solution.
 */
public class ToDoList
{
    // Instance variable(s)
    
    private PriorityQueue<Task> taskQueue;

    /**
     * Constructor
    */
    public ToDoList()
    {
        // Complete this
        taskQueue = new PriorityQueue<>();
    }

    /**
     * Display a menu and accepts commands.
     */
    public void run()
    {
        String option = "";
        System.out.println("To Do List - Please enter an option");
        System.out.println("     add priority description (add a new task)");
        System.out.println("     next (remove and print most urgent task)");
        System.out.println("     quit (exit this program)");
        System.out.println();
        
        Scanner in = new Scanner(System.in);
        
        do
        {
            System.out.print("> ");
            option = in.nextLine();
            if (option.startsWith("add"))
            {
                addTask(option);
            } else if (option.equals("next"))
            {
                nextTask();
            }
        } 
        while (! option.equals("quit"));
        
        in.close(); 
    }
    
    /**
     * Parse the add option line.
     *
     * @param optionStr the option line
    */
    public void addTask(String optionStr)
    {
        // Complete this method
        try {
            String[] parts = optionStr.split(" ", 3);
            if (parts.length < 3) {
                System.out.println("Invalid add command. Usage: add priority description");
                return;
            }
            int priority = Integer.parseInt(parts[1]);
            if (priority < 1 || priority > 9) {
                System.out.println("Priority must be between 1 and 9.");
                return;
            }
            String description = parts[2];
            Task newTask = new Task(priority, description);
            taskQueue.add(newTask);
            System.out.println("Added task: " + description + " with priority " + priority);
        } catch (NumberFormatException e) {
            System.out.println("Invalid priority. Please enter an integer between 1 and 9.");
        }
    }

    /**
     * Get the next highest priority task and
     * display the description to the user.
    */
    public void nextTask()
    {
        Task next = null;
        
        // Complete this method
        if (!taskQueue.isEmpty()) {
            next = taskQueue.poll();
        }
        
        if (next == null)
        {
            System.out.println("There are no tasks in the list.");
        } else
        {
            System.out.println("Next task: " + next.getDescription() + " (Priority: " + next.getPriority() + ")");
        }
    }
}
