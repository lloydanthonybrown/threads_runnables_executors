import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class SandboxingExecutors {
    public static void main(String[] args) {
        Executor anExecutor = java.util.concurrent.Executors.newCachedThreadPool();
        for (int threadCnt = 0; threadCnt < 3; threadCnt++) {
            SimpleRunnable aSimpleRunnable = new SimpleRunnable();
            anExecutor.execute(aSimpleRunnable);
        }

        try {
            // Why should I put this thread to sleep here? Does it have a purpose?
            Thread.sleep(1000);
            System.out.println("Done Sleeping");
            for (int threadCnt = 0; threadCnt < 3; threadCnt++) {
                SimpleRunnable aSimpleRunnable = new SimpleRunnable();
                anExecutor.execute(aSimpleRunnable);
                // nasty path: executing a null
                anExecutor.execute(null);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}