import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class SillyThreadPool {
    
	public static void main(String[] args) {
		Executor anExecutor = Executors.newCachedThreadPool();
		for(int threadCnt = 0; threadCnt < 3; threadCnt++){
			SimpleRunnable aSimpleRunnable = new SimpleRunnable();
			anExecutor.execute(aSimpleRunnable);
		}

		try {
			Thread.sleep(1000);
			System.out.println("Done Sleeping");
			for(int threadCnt = 0; threadCnt < 3; threadCnt++){
				SimpleRunnable aSimpleRunnable = new SimpleRunnable();
				anExecutor.execute(aSimpleRunnable);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        
	}
}