package edu.grinnell.csc207.sorting;

import org.junit.jupiter.api.BeforeAll;

/**
 * Tests of my sort.
 *
 * @author Natalie Nardone
 */
public class TestNardoneNatalieSort extends TestSorter {
  /**
   * Set up the sorters.
   */
  @BeforeAll
  static void setup() {
    stringSorter = new NardoneNatalieSort<String>((x,y) -> x.compareTo(y));
    intSorter = new NardoneNatalieSort<Integer>((x,y) -> x.compareTo(y));
  } // setup()

} // class TestQuicksorter
