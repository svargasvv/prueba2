package TestStructures;

import static org.junit.Assert.*;
import model.data_structures.Queue;
import org.junit.Before;
import org.junit.Test;

public class QueueTest {

  private Queue<String> queue;

  @Before
  public void setup(){

    queue = new Queue<>();

  }

  @Before
  public void setup2(){

    setup();
    for(int i = 0; i < 5; i ++){
      queue.enqueue("mice " + i);
    }

  }

  @Test
  public void enqueueTest(){

    setup();
    queue.enqueue("mice");
    assertEquals(queue.size(), 1);
    assertEquals(queue.dequeue(), "mice");

  }

  @Test
  public void dequeueTest(){

    setup2();
    assertEquals(queue.dequeue(), "mice 0");
    assertEquals(queue.size(), 4);

    for(int i = 1; i < 5; i++){
      assertEquals(queue.dequeue(), "mice " + i);
    }

    assert queue.isEmpty();

    setup2();
    assertEquals(queue.peek(), "mice 0");
    assertEquals(queue.size(), 5);
    assertEquals(queue.peek(), queue.dequeue());

  }

}
