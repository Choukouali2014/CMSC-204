import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class CarQueue{
	private Queue<Integer> queue;
	private Random rdm = new Random();

	public CarQueue() {
		queue = new LinkedList<Integer>();
		queue.add(rdm.nextInt(5));
		queue.add(rdm.nextInt(5));
		queue.add(rdm.nextInt(5));
		queue.add(rdm.nextInt(5));
		queue.add(rdm.nextInt(5));
		queue.add(rdm.nextInt(5));
	}
	public void addToQueue() {
		class addRunnable implements Runnable {
			@Override
			public void run() {
				try {
					while(true) {
						queue.add(rdm.nextInt(5));
						Thread.sleep(1);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		addRunnable run = new addRunnable();
		Thread thread = new Thread(run);
		thread.start();
		
	}

	public int deleteQueue() {

		return queue.remove();
	}

	

}
