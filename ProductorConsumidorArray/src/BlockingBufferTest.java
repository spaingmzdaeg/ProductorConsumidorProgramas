import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BlockingBufferTest{
    public static void main(String[] args) throws InterruptedException
    {
        // create new thread pool with two threads
        ExecutorService executorService = Executors.newCachedThreadPool();
        //create BlockingBuffer to store ints
        Buffer sharedLocation = new BlockingBuffer();
        executorService.execute(new Producer(sharedLocation));
        executorService.execute(new Consumer(sharedLocation));
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.MINUTES);
    }
} // end class BlockingBufferTest

