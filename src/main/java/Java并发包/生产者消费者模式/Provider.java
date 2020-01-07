package Java并发包.生产者消费者模式;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Provider implements Runnable {
	
	//共享缓存区
	private BlockingQueue<Data> queue;
	
	private volatile boolean isRunning = true;
	
	private static AtomicInteger count = new AtomicInteger();
	
	private static Random r = new Random();
	
	public Provider(BlockingQueue queue){
		this.queue = queue;
	}

	@Override
	public void run() {
		while(isRunning){
			try{
				
				Thread.sleep(r.nextInt(1000));
				int id = count.incrementAndGet();
				
				Data data = new Data(id + "", "数据" + id);
				
				System.out.println("当前线程:" + Thread.currentThread().getName() + ",获取了数据,id为:" + id + ",进行装在到公共缓冲区中...");
				
				if(!this.queue.offer(data,2,TimeUnit.SECONDS)){
					System.out.println("提交缓冲区数据失败...");
				}
				
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void stop(){
		this.isRunning = false;
	}
	
}
