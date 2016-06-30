public class SandboxingRunnables implements Runnable{

    // POST a runnable? Perform this in Android Studio. Make a background thread communicate with a main thread.
    // Main thread communicates directly with UI. Creates runnable to send post to be executed in background thread.
    // Background thread makes connections and retrieves/changes data, then creates a runnable.
    // Sends this runnable/task back to the Main thread's queue to be completed.
    // Example: clicking a button on a webpage several times, it kinda freezes as it processes each click in the queue.

    public void run(){
        for(int i=0; i < 5; i++){
            System.out.println("Child Thread : " + i);
        }
        System.out.println("Child thread finished!");
    }

    public static void main(String[] args) {
        try {
//            Thread t = new Thread(new SandboxingRunnables(), "My Thread");
            Thread t = new Thread(new SandboxingRunnables(), null);
            // Nasty Path change "My Thread" to a null
            t.start();
        }
        catch(NullPointerException e) {
            System.out.println("Null Pointer Exception Caught on the child thread. ");
         }

        for(int i=0; i < 5; i++){
            System.out.println("Main thread : " + i);
        }
        System.out.println("Main thread finished!");
    }
}
