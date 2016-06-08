public class SandboxingThreads extends Thread{
    // 1) race condition
    // 2) locks - two threads trying to use one piece of data
    // 3) nulls
    // 4) main method begins the threads and other processes. Does each class use the same main method?

    // deadlock, where two threads are trying to access the same data
    // Would it be more meaningful to name the objects differently?
    public static Object Damen = new Object();
    public static Object Liz = new Object();

    public static void main(String args[]) {
        // Can I use a regular thread instead of a ThreadDemo?
        Thread SandboxedThread1 = new Thread();
        Thread SandboxedThread2 = new Thread();
        SandboxedThread1.start();
        SandboxedThread2.start();

        // What are ThreadDemos? How are they working?
    }

    // If Damen is synchronized first and Liz second on this Thread, the process completes successfully.
    // Well, I'm not exactly sure if this is true. Why can't I print out the statements?
    private static class SandboxedThread1 extends Thread {
        // They both have to have a run method that overrides the default Thread behavior, I get that.
        public void run() {
            synchronized (Damen) {
                System.out.println("I am taking the only fork for the salad.");
                try { Thread.sleep(10); }
                // What's this catch doing? Why would the process be interrupted?
                catch (InterruptedException e) {}
                System.out.println("Waiting for the knife.");
                synchronized (Liz) {
                    System.out.println("I have both, so now I can finally eat!");
                }
            }
        }
    }

    private static class SandboxedThread2 extends Thread {
        public void run() {
            synchronized (Liz) {
                System.out.println("I am taking the only knife to cut the steak.");
                try { Thread.sleep(10); }
                catch (InterruptedException e) {}
                System.out.println("Waiting for the fork.");
                synchronized (Damen) {
                    System.out.println("I have both, so now I can finally eat!");
                }
            }
        }
    }

}
