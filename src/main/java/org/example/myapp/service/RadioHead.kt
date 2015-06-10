package org.example.myapp.service

import javax.inject.Inject
import javax.inject.Singleton

/**
 * RadioHead service.
 */
@Singleton
public class RadioHead {

  protected val muse: Muse;

  @Inject
  constructor(muse: Muse) {
    this.muse = muse;
  }

  fun theBends() {

    // doing stuff
    Thread.sleep(10);
    pabloHoney();
  }

  fun pabloHoney() {

    // doing stuff
    Thread.sleep(50)
    muse.resistance();
  }

  fun kidA() {

    // doing stuff
    muse.originOfSymmetry();
    notTimed();
  }

  /**
   * Private methods are not enhanced for timing metrics collection by default.
   */
  private fun notTimed() {
    Thread.sleep(50)
  }
}