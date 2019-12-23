package producerconsumer;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {

  private BlockingQueue<Person> blockingQueue;

  public Producer(BlockingQueue<Person> blockingQueue) {
    this.blockingQueue = blockingQueue;
  }

  @Override
  public void run() {
    while (true) {
      Person person = new Person("Hiten", 789678545);
      try {
        blockingQueue.put(person);
      } catch (InterruptedException e) {
        System.out.println("Queue full Producer Waiting  Person");
      }
      System.out.println("Produced Person: [" + person.toString()+ "]");
    }
  }
}
