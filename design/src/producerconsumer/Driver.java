package producerconsumer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Driver {

  public static void main(String[] args) {
    BlockingQueue<Person> blockingQueue = new LinkedBlockingQueue<>(2);
    Thread a = new Thread(new Producer(blockingQueue));
 //   Thread b = new Thread((new Consumer(blockingQueue)));
    a.start();
 //   b.start();


  }

}
