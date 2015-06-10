package org.example.myapp.main;

import org.avaje.metric.annotation.NotTimed;
import org.example.myapp.service.NotInteresting;

/**
 * Attempt at rough calculation of overhead using 'per request aware' enhancement.
 */
public class LoopRoughRunner {

  /**
   * Run this with and without metrics enhancement.
   */
  public static void main(String[] args) {

    LoopRoughRunner runner = new LoopRoughRunner();

    for (int i = 0; i <10; i++) {
      runner.runId();
    }

  }

  NotInteresting notInteresting = new NotInteresting();

  public void runId() {

    long start = System.nanoTime();
    int count = roughRun();
    long exe = System.nanoTime() - start;

    //1424397
    System.out.println("ran in "+exe+ "   value:"+count);
  }

  @NotTimed
  public int roughRun() {

    int total = 0;
    for (int i = 0; i < 100000000; i++) {
      total += notInteresting.nextRandomInt();
    }
    return total;
  }

  // rough calculation of overhead:

  // take best for non-enhanced  =  1191591869 (total)
  // take worst for enhanced     = 14535160849 (total)

  // difference = 14535160849 - 1191591869 = 13343568980 nanos (total)
  // total diff / 100000000 method invocations = 133.4 nanos

}
