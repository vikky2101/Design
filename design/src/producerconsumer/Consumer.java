package producerconsumer;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {

  private BlockingQueue<Person> blockingQueue;

  public Consumer(BlockingQueue<Person> blockingQueue) {
    this.blockingQueue = blockingQueue;
  }

  @Override
  public void run() {
    while (true) {
      try {
        System.out.println("Consumed Person: " + blockingQueue.take());
      } catch (InterruptedException e) {
        System.out.println("Waiting Consumer");
      }
    }
  }
}
