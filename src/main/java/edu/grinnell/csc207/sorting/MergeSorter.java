package edu.grinnell.csc207.sorting;

import java.util.Comparator;

/**
 * Something that sorts using merge sort.
 *
 * @param <T>
 *   The types of values that are sorted.
 *
 * @author Natalie Nardone
 * @author Samuel A. Rebelsky
 */

public class MergeSorter<T> implements Sorter<T> {
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
  public MergeSorter(Comparator<? super T> comparator) {
    this.order = comparator;
  } // MergeSorter(Comparator)

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Sort an array in place using merge sort.
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
    mergeSortHelper(values, 0, values.length - 1);
  } // sort(T[])

  /**
   * Sorts an array from index l to index u in place using merge sort.
   *
   * @param values
   *   an array to sort
   * @param l
   *   the starting index for sorting
   * @param u
   *   the ending index for sorting (inclusive)
   */
  public void mergeSortHelper(T[] values, int l, int u) {
    if (u - l > 0) {
      int midpoint = ((u - l) / 2) + l; // fix
      mergeSortHelper(values, l, midpoint);
      mergeSortHelper(values, midpoint + 1, u);
      merge(values, l, u + 1, midpoint + 1); // merge values from l to r
    } // if
  } // mergeSortHelper(T[], int, int)

  /**
   * Merges two parts of an array together such that they are sorted,
   * where the first array is stored from index l to m, exclusive,
   * and the second array is stored from index m to u, exclusive.
   *
   * @param values
   *   an array to sort
   * @param l
   *   the index where the first array starts
   * @param u
   *   the index where the second array ends
   * @param m
   *   the index where the first array ends/second array starts
   */
  public void merge(T[] values, int l, int u, int m) {
    T[] newArray = values.clone();

    int endLeft = m; // exclusive
    int endRight = u; // exclusive
    int curLeft = l;
    int curRight = m;
    int index = l;

    while ((curLeft < endLeft) && (curRight < endRight)) {
      if (order.compare(newArray[curLeft], newArray[curRight]) < 0) {
        values[index] = newArray[curLeft];
        curLeft++;
      } else {
        values[index] = newArray[curRight];
        curRight++;
      } // if/else
      index++;
    } // while

    if (curLeft < endLeft) {
      for (int i = index; i < u; i++) {
        values[i] = newArray[curLeft];
        curLeft++;
      } // for
    } // if
    else if (curRight < endRight) {
      for (int i = index; i < u; i++) {
        values[i] = newArray[curRight];
        curRight++;
      } // for
    } // if/else
  } // merge(T[], int, int, int)
} // class MergeSorter
