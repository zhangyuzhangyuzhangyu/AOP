package DuoXianChengAndSingleThread;

public class ConcurrentTest {
    private static int count=10000000;
    public static void main(String[] arg) throws InterruptedException {
        MultiThread();
        serial();

    }

    public static void MultiThread() throws InterruptedException {
        long start = System.currentTimeMillis();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                int a=0;
                for (int i = 0; i < count; i++) {
                    a+=5;
                }

            }
        });
        thread.start();
        int b=0;
        for (int i = 0; i < count; i++) {
            b--;
        }
        thread.join();
        long end = System.currentTimeMillis();
        System.out.println("多线程花费时间"+(end-start)+"b的值是"+b);
    }

    private static void serial() {
        long start = System.currentTimeMillis();
        int a = 0;
        for (long i = 0; i < count; i++) {
            a += 5;
        }
        int b = 0;
        for (long i = 0; i < count; i++) {
            b--;
        }
        long time = System.currentTimeMillis() - start;
        System.out.println("serial:" + time+"ms,b="+b+",a="+a);
    }
}
