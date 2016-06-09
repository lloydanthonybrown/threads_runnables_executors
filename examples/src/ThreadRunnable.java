public class ThreadRunnable implements Runnable{

    public void run(){ //runnable

        for(int i=0; i < 5; i++){
            System.out.println("Child Thread : " + i);

            try{
                // Why do we make the threads go to sleep on purpose? Are we assuming they're busy with a process for that time?
                Thread.sleep(50);
            }
            catch(InterruptedException ie){
                System.out.println("Child thread interrupted! " + ie);
            }
        }

        System.out.println("Child thread finished!");
    }

    public static void main(String[] args) {
        try {
            Thread t = new Thread(new ThreadRunnable(), "My Thread");
            // Nasty Path change "My Thread" to a null

            t.start();
        }catch(NullPointerException e) {
            System.out.println("Null Pointer Exception Caught on the child thread continue code");
            System.out.println();
        }

        for(int i=0; i < 5; i++){

            System.out.println("Main thread : " + i);

            try{
                // Does it matter how long this sleeps for?
                Thread.sleep(10);
            }
            catch(InterruptedException ie){
                System.out.println("Child thread interrupted! " + ie);
            }
        }
        System.out.println("Main thread finished!");
    }
}
