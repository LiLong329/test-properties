//import java.math.BigDecimal;
//import java.util.concurrent.ConcurrentLinkedQueue;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//import java.util.concurrent.atomic.AtomicInteger;
//
//import org.junit.Test;
//
//public class AlgorithmTest {
////	@Test
//	public void test1() {
//		ConcurrentLinkedQueue <Integer> queue = new ConcurrentLinkedQueue<>();
//		ExecutorService pool = Executors.newCachedThreadPool();
//		for (int i = 0; i < 108; i++) {
//			Thread t = new Thread(new Runnable() {
//				@Override
//				public void run() {
//					int a = OneOrZero();
////					queue.add(a);
//				}
//			});
//			pool.submit(t);
//		}
//		pool.shutdown();
//
//		if(pool.isShutdown()) {
//			int oneCount = 0;
//			int zeroCount = 0 ;
//			while(!queue.isEmpty()) {
//				Integer i = queue.poll();
//				if(i == 0) {
//					zeroCount ++;
//				}else if( i == 1) {
//					oneCount ++;
//				}
//			}
//			System.out.println(oneCount);
//			System.out.println(zeroCount);
//		}
//	}
//	//给一个函数，返回 0 和 1，概率为 p 和 1-p，请你实现一个函数，使得返回 01 概率一样。
//	AtomicInteger a = new AtomicInteger();
//	private int  OneOrZero() {
//		return a.incrementAndGet() % 2;
//	}
//
//	//10 亿个 url，每个 url 大小小于 56B，要求去重，内存 4G。
//	@Test
//	public void test2() {
//		BigDecimal b = new BigDecimal(4);
//		b = b.multiply(new BigDecimal(1024)).multiply(new BigDecimal(1024)).multiply(new BigDecimal(1024));
//		BigDecimal count = b.divide(new BigDecimal(58),1);
////		long a = 4 * 1024 *1024 * 1024;
//
//		BigDecimal urles = new BigDecimal("1000000000");
//		count = urles.divide(count, 0);
//		System.out.println(count.toBigInteger());
//	}
//
//
//}
//
//