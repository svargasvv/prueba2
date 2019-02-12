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

  @Test
  public void pushTest(){

    setup();
    stack.push("cat");
    assertEquals(stack.size(), 1);
    assertEquals(stack.pop(), "cat");

    for(int i = 0; i < 5; i++){
      stack.push("cat " + 1);
    }
    assertEquals(stack.size(), 5);
  }


}