package org.example.myapp.service

import org.avaje.metric.annotation.Timed
import javax.inject.Singleton


/**
 * Muse service
 */
@Singleton
public class Muse {

  fun resistance() {

    // do stuff
    notThatResistant();
    iDoTheRealWorkAroundHere();
    notParticularlyResistant();
  }

  fun originOfSymmetry() {

    // do stuff but not much really
    Thread.sleep(1);
  }

  fun iDoTheRealWorkAroundHere() {
    // the real worker bee ...
    Thread.sleep(500);
  }


  fun notParticularlyResistant() {
    // do not much at all
  }

  /**
   * Protected and private methods are not 'enhanced' for timing by default
   * so adding @Timed means it will be.
   */
  @Timed
  protected fun notThatResistant() {
    // do not much at all
  }

}