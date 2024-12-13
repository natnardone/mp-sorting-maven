package edu.grinnell.csc207.sorting;

import java.util.Comparator;

/**
 * Something that sorts using my sort.
 *
 * @param <T>
 *   The types of values that are sorted.
 *
 * @author Natalie Nardone
 */

public class NardoneNatalieSort<T> implements Sorter<T> {
  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The way in which elements are ordered.
   */
  Comparator<? super T> order;

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a sorter using a particular comparator.
   *
   * @param comparator
   *   The order in which elements in the array should be ordered
   *   after sorting.
   */
  public NardoneNatalieSort(Comparator<? super T> comparator) {
    this.order = comparator;
  } // NardoneNatalieSort(Comparator)

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Sort an array in place using my sort.
   *
   * @param values
   *   an array to sort.
   *
   * @post
   *   The array has been sorted according to some order (often
   *   one given to the constructor).
   * @post
   *   For all i, 0 &lt; i &lt; values.length,
   *     order.compare(values[i-1], values[i]) &lt;= 0
   */
  @Override
  public void sort(T[] values) {
    // STUB
  } // sort(T[])
} // class NardoneNatalieSort
