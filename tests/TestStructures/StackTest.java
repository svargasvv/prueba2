package TestStructures;

import static org.junit.Assert.*;

import model.data_structures.Stack;
import org.junit.Before;
import org.junit.Test;

public class StackTest {

  private Stack<String> stack;

  @Before
  public void setup(){

    stack = new Stack<>();

  }

  public void setup2(){

    setup();
    for(int i = 0; i < 5; i++){
      stack.push("cat " + i);
    }

  }

  @Test
  public void pushTest(){

    setup();
    stack.push("cat");
    assertEquals(stack.size(), 1);
    assertEquals(stack.pop(), "cat");

    setup2();
    assertEquals(stack.size(), 5);
  }

  @Test
  public void popTest(){

    setup();
    assert stack.isEmpty();

    stack.push("tag");
    stack.push("siege");

    assertEquals(stack.size(), 2);

    assertEquals("siege", stack.pop());
    assertEquals(stack.size(), 1);

    assertEquals("tag", stack.pop());
    assert stack.isEmpty();

    try{
      stack.pop();
      fail("No debe funcionar si la lista esta vacia");
    }
    catch(Exception e){

    }
  }

  @Test
  public void peekTest(){

    setup2();
    assertEquals(stack.size(), 5);

    assertEquals(stack.peek(), "cat 4");
    assertEquals(stack.size(), 5);

    assertEquals(stack.peek(), stack.pop());
    assertEquals(stack.peek(), "cat 3");


  }


}