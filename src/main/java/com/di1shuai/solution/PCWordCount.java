package com.di1shuai.solution;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;


//实现一个高性能多生产者(producer)和消费者(consumer)模型的word count程序。
//多个生产者线程(或进程)同时随机生成word，多个消费者线程(或进程)做word的数量统计。
//例子：producer-1: [abc, def], producer-2: [abc, ghi] => 统计结果 {abc: 2, def: 1, ghi: 1}

/**
 * @author: Shea
 * @date: 2020/12/1
 * @description:
 */
public class PCWordCount {

    public static void main(String[] args) {
        PCWordCount pcWordCount = new PCWordCount();
        pcWordCount.product(3);
        pcWordCount.comsumer(3);
    }

    private static Random random = new Random();

    public static String[] getWords() {
        String[][] ss = {{"aa", "bb", "cc"}, {"aa", "dd", "ee"}};
        return ss[random.nextInt(2)];
    }

    private final ConcurrentHashMap<String, AtomicLong> map = new ConcurrentHashMap<>();

    private final LinkedBlockingQueue<String[]> queue = new LinkedBlockingQueue<>();

    private final ThreadPoolExecutor producerPool = new ThreadPoolExecutor(
            Runtime.getRuntime().availableProcessors(),
            20,
            60L,
            TimeUnit.SECONDS,
            new SynchronousQueue<Runnable>(),
            new DefaultThreadFactory("Producer"));
    private final ThreadPoolExecutor comsumerPool = new ThreadPoolExecutor(
            Runtime.getRuntime().availableProcessors(),
            20,
            60L,
            TimeUnit.SECONDS,
            new SynchronousQueue<Runnable>(),
            new DefaultThreadFactory("Comsumer"));

    public void product(int num) {
        for (int i = 0; i < num; i++) {
            producerPool.execute(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        Thread.currentThread().getName();
                        queue.offer(getWords());
                        try {
                            Thread.sleep(800);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        }

    }

    public void comsumer(int num) {
        for (int i = 0; i < num; i++) {
            comsumerPool.execute(new Runnable() {
                @Override
                public void run() {
                    String threadName = Thread.currentThread().getName();
                    while (true) {
                        String[] poll = queue.poll();
                        if (poll != null) {
                            System.out.print(threadName + " -> ");
                            for (String s : poll) {
                                AtomicLong num = map.get(s);
                                if (null == num) {
                                    map.put(s, new AtomicLong(1L));
                                } else {
                                    num.incrementAndGet();
                                }
                            }
                            System.out.println(map);
                        }
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        }

    }


}

class DefaultThreadFactory implements ThreadFactory {
    private final AtomicInteger threadNumber = new AtomicInteger(1);
    private final String namePrefix;

    DefaultThreadFactory(String namePrefix) {
        this.namePrefix = namePrefix + "-";
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r, namePrefix + threadNumber.getAndIncrement());
        if (t.getPriority() != Thread.NORM_PRIORITY) {
            t.setPriority(Thread.NORM_PRIORITY);
        }
        return t;
    }
}
