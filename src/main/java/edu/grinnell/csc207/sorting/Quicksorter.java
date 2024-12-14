package edu.grinnell.csc207.sorting;

import java.util.Comparator;

/**
 * Something that sorts using Quicksort.
 *
 * @param <T>
 *   The types of values that are sorted.
 *
 * @author Natalie Nardone
 * @author Samuel A. Rebelsky
 */

public class Quicksorter<T> implements Sorter<T> {
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
  public Quicksorter(Comparator<? super T> comparator) {
    this.order = comparator;
  } // Quicksorter(Comparator)

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Sort an array in place using Quicksort.
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
    quickSortHelper(values, 0, values.length);
  } // sort(T[])

  /**
   * Sort an array from lb to ub in place using Quicksort.
   *
   * @param values
   *   an array to sort
   * @param lb
   *   the lower bound to sort from
   * @param ub
   *   the upper bound to sort to
   */
  public void quickSortHelper(T[] values, int lb, int ub) {
    if (ub > lb) {
      int[] pivots = partition(values, lb, ub);
      if (lb < pivots[0]) {
        quickSortHelper(values, lb, pivots[0]);
      } // if
      if (ub > pivots[1]) {
        quickSortHelper(values, pivots[1], ub);
      } // if
    } // if
  } // quickSortHelper(T[], int, int)

  /**
   * Uses the Dutch National Flag algorithm to partition part of an array into three parts.
   * @param values
   *   the array to partition
   * @param lb
   *   the lower bound of the section to partition
   * @param ub
   *   the upper bound of the section to partition
   * @return an array with the index of the end of the "smaller" section and the index
   *         of the beginning of the "larger" section
   */
  public int[] partition(T[] values, int lb, int ub) {
    int pivot = ((int) (Math.random() * (ub - lb))) + lb;
    T temp = values[pivot];
    if (pivot != lb) {
      for (int i = pivot - 1; i >= lb; i--) {
        values[i + 1] = values[i];
      } // for
      values[lb] = temp; // pivot now in position 0
    } // if
    int r = lb;
    int w = lb;
    int b = lb;
    int n = ub;

    while (b < n) {
      // if values[b] is less than pivot
      if (order.compare(values[b], temp) < 0) {
        if (w != b) {
          swap(values, r, w);
          swap(values, r, b);
        } // if
        if (w == b) {
          swap(values, w, b);
          swap(values, r, w);
        } // if
        r++;
        w++;
        b++;
      } else if (order.compare(values[b], temp) == 0) {
        swap(values, w, b);
        w++;
        b++;
      } else if (order.compare(values[b], temp) > 0) {
        b++;
      } // if/else
    } // while
    return new int[] {r, w};
  } // partition(T[], int, int)

  /**
   * Swaps two values in an array.
   * @param values
   *   The array
   * @param first
   *   The index of the first value
   * @param second
   *   The index of the second value
   */
  public void swap(T[] values, int first, int second) {
    T temp = values[first];
    values[first] = values[second];
    values[second] = temp;
  } // swap(T[], int, int)
} // class Quicksorter
