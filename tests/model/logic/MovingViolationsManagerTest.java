package model.logic;

import org.junit.Test;

public class MovingViolationsManagerTest {

  private MovingViolationsManager mvm = new MovingViolationsManager();

  @Test
  public void testLoadMovingViolations(){

      mvm.loadMovingViolations("/data/Moving_Violations_Issued_in_February_2018_ordered");

  }

}