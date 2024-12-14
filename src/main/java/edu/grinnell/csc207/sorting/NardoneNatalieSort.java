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
    sortHelper(values, 0, values.length - 1);
    // merge sort, switch to insertion sort when reaches 10 elements
  } // sort(T[])

  /**
   * Sorts an array from index l to index u in place.
   *
   * @param values
   *   the array to sort
   * @param l
   *   the lower bound for sorting
   * @param u
   *   the upper bound for sorting
   */
  public void sortHelper(T[] values, int l, int u) {
    if (u - l > 0) {
      if (values.length > 10) {
        int midpoint = ((u - l) / 2) + l; // fix
        sortHelper(values, l, midpoint);
        sortHelper(values, midpoint + 1, u);
        merge(values, l, u + 1, midpoint + 1); // merge values from l to r
      } else {
        insertionSort(values, l, u + 1);
      } // if/else
    } // if
  } // sortHelper(T[], int, int)

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
    } else if (curRight < endRight) {
      for (int i = index; i < u; i++) {
        values[i] = newArray[curRight];
        curRight++;
      } // for
    } // if/else
  } // merge(T[], int, int, int)

  /**
   * Sorts an array from index l to u using insertion sort.
   *
   * @param values
   *   the array to sort
   * @param l
   *   the lower bound for sorting
   * @param u
   *   the upper bound for sorting
   */
  public void insertionSort(T[] values, int l, int u) {
    int current;
    int prev;
    for (int i = l; i < u; i++) {
      current = i;
      if (current > 0) {
        prev = i - 1;
        while ((current > 0) && (order.compare(values[current], values[prev]) < 0)) {
          T temp = values[current];
          values[current] = values[prev];
          values[prev] = temp;
          current--;
          prev--;
        } // while
      } // if
    } // for
  } // insertionSort(T[])
} // class NardoneNatalieSort
