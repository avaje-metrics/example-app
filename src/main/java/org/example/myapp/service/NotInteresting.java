package org.example.myapp.service;

import javax.inject.Singleton;
import java.util.Random;

/**
 * This gets enhanced.
 */
@Singleton
public class NotInteresting {

  final Random random = new Random();

  /**
   * Do something but not much.
   */
  public int nextRandomInt() {

    return random.nextInt(100);
  }
}
