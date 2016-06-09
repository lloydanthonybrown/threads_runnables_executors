import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class BasicThreadPoolExecutor {
    public static void main(String[] args) {
        // Nasty path pass it a null and run the thread

        //Use the executor created by the newCachedThreadPool() method
        //only when you have a reasonable number of threads
        //or when they have a short duration.
        try {
            ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
            for (int i = 0; i <= 5; i++) {
                Task task = new Task("Task " + i);
                System.out.println("A new task has been added : " + task.getName());
                executor.execute(task);
                // For Nasty Path change the executor.execute(null);
            }
            executor.shutdown();
        } catch (NullPointerException e) {
            System.out.println("Null Pointer Exception Caught");
            System.out.println();
        }
    }
}
