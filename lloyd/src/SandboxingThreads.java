public class SandboxingThreads extends Thread{
    // deadlock, where two threads are trying to access the same data
    // Would it be more meaningful to name the objects differently?
    public static Object Damen = new Object();
    public static Object Liz = new Object();

    public static void main(String args[]) {
        // Ethan suggested this:
        SandboxedThread1 T1 = new SandboxedThread1();
        SandboxedThread2 T2 = new SandboxedThread2();
        T1.start();
        T2.start();
    }

    // If Damen is synchronized first and Liz second on this Thread, the process completes successfully.
    private static class SandboxedThread1 extends Thread {
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
