package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

//设置业务模拟
class MyRunnable implements Runnable {
    private int count;

    public MyRunnable(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100000; i++) {
            count += i;
        }
        System.out.println("结果："+count);
    }

    //模拟线程池复用线程执行业务
    public static void main(String[] args) throws InterruptedException {
        Long start = System.currentTimeMillis();
        int count =0;
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        MyRunnable myRunnable = new MyRunnable(count);
        for (int i = 0; i < 1000; i++) {
            executorService.execute(myRunnable);
        }
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.DAYS);
        System.out.println("时间："+(System.currentTimeMillis() - start));

    }

//    //模拟每次执行业务都开一个线程
//    public static void main(String[] args) throws InterruptedException {
//        Long start = System.currentTimeMillis();
//        int count =0;
//        MyRunnable myRunnable = new MyRunnable(count);
//        for (int i = 0; i < 1000; i++) {
//            Thread thread = new Thread(myRunnable);
//            thread.start();
//            thread.join();
//        }
//        System.out.println("时间：" + (System.currentTimeMillis() - start));
//    }
}



