public class Deadlock {
        public static Object Lock1 = new Object();
        public static Object Lock2 = new Object();

        public static void main(String args[]) {

            ThreadDemo1 T1 = new ThreadDemo1();
            ThreadDemo2 T2 = new ThreadDemo2();
            T1.start();
            T2.start();
        }

        private static class ThreadDemo1 extends Thread {
            public void run() {
                synchronized (Lock1) {
                    System.out.println("I am taking the only paint brush to paint the ceiling on the left");
                    try { Thread.sleep(10); }
                    catch (InterruptedException e) {}
                    System.out.println("Waiting for the ladder");
                    synchronized (Lock2) {
                        System.out.println("I have both so I can finish my job");
                    }
                }
            }
        }
        // This forms a deadlock if thread 2 grabs lock 2 first and then lock 1 second. If it is switched to lock 1 first and lock 2 second
        // then thread 1 finishes and unlocks both locks so that thread 2 can grab them next and it now finishes.
        private static class ThreadDemo2 extends Thread {
            public void run() {
                synchronized (Lock2) {
                    System.out.println("I am taking the only ladder to paint the ceiling on the right");
                    try { Thread.sleep(10); }
                    catch (InterruptedException e) {}
                    System.out.println("Waiting for the paint brush");
                    synchronized (Lock1) {
                        System.out.println("I have both so I can finish my job");
                    }
                }
            }
        }
}
