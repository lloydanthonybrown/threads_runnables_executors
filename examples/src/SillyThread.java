public class SillyThread extends Thread{
	public void run(){
		for (int i = 0; i < 3; i++) {
			System.out.println("Thread id: "
                               +Thread.currentThread().getName() + " is at " + i);
			try {
				Thread.currentThread().sleep(100);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args){
        	for (int threadCnt = 0; threadCnt < 3; threadCnt++) {
           		 SillyThread aSillyThread =  new SillyThread();
           		 aSillyThread.start();
       		 }
	}
}
