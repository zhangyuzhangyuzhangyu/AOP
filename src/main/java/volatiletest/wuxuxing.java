package volatiletest;

public class wuxuxing {
    private static boolean ready;
    private static int number;
    private static class ReaderThread extends Thread {
        @Override
        public void run() {
            while(!ready) {
                Thread.yield();
                System.out.println(number+"****");

            }
            System.out.println(number);
        }
    }
    public static void main(String[] args) throws InterruptedException {
        new ReaderThread().start();
        Thread.sleep(10000);
        number = 42;
        ready = true;
    }
}
