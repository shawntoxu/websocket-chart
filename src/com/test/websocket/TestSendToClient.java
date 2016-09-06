package com.test.websocket;

import java.util.Random;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TestSendToClient {
	
	
	public static java.util.concurrent.CopyOnWriteArraySet<String>  sets = new CopyOnWriteArraySet<String>();
	
	public static java.util.concurrent.ExecutorService   execService  = java.util.concurrent.Executors.newCachedThreadPool() ;
	public static int a ;
	public static void doTest(){
		ExecutorService thss = new ThreadPoolExecutor(0, Integer.MAX_VALUE,
                60L, TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>());
		
	/**	
		mythread a = new mythread() ;
		a.start();
		**/
		
		//每个客户端发送50个数据
		for (final String ss : SessionUtil.clients.keySet() ) {
			if(!sets.contains(ss)){
				sets.add(ss);
				execService.submit(new Runnable() {
					
					@Override
					public void run() {
						for (int i = 0; i < 50; i++) {
							long t = System.currentTimeMillis();
							Random r = new Random() ;
							int a=r.nextInt(100);
							String result = "{\"x\":"+t+",\"y\":"+a+"}";
							SessionUtil.get(ss).getAsyncRemote().sendText(result);
							
							try {
								Thread.currentThread().sleep(1000);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					}
				});
			}else{
				continue  ;
			}
			
		}
	}

	
	public static void main(String[] args) {
		Random r = new Random() ;
		int a=r.nextInt(100);
		System.out.println(a);
	}
}


/**	
	
	@SuppressWarnings("static-access")
	public static void main(String[] args) throws InterruptedException {

		mythread a = new mythread() ;
		a.start();
	}
	
	

	static class mythread extends Thread {
		@Override
		public void run() {
//			while(true){
//				try {
//					Thread.currentThread().sleep(1000);
//				} catch (InterruptedException e1) {
//					e1.printStackTrace();
//				}
				

			final String  predata = "send-";
			for (int i = 0; i < 50 ; i++) {
				a++ ; 
				try {
					Thread.currentThread().sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			 // send msg to all session client 
				for (final String ss : SessionUtil.clients.keySet() ) {
					execService.execute(new Runnable() {
						
						@Override
						public void run() {
							
							SessionUtil.get(ss).getAsyncRemote().sendText(predata+a);
						}
					});
					
					
				}
				
			}
			
			
/**			//标记连接的client 标号
			//是0 就不断发送消息到client
			if(SessionUtil.hasConnection("0")){
				String  predata = "send-";
				for (int i = 0; i < 50 ; i++) {
					try {
						Thread.currentThread().sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					SessionUtil.get("0").getAsyncRemote().sendText(predata+i);
				}
				
			}else{
				System.out.println("wait");
				//throw new NullPointerException("connect is null");
				}
			
		**/
		  //}//end run

		//} 
//	}
//}
