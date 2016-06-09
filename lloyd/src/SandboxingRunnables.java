public class SandboxingRunnables implements Runnable{

    // POST a runnable? Perform this in Android Studio. Make a background thread communicate with a main thread.

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
