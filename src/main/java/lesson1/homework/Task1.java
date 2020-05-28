package lesson1.homework;

import java.util.Arrays;

public class Task1<T extends Object> {
  private T[] arr;

  public Task1(Integer length) {
    arr = (T[]) new Object[length];
  }

  @Override
  public String toString() {
    return "Task{" + "arr=" + Arrays.toString(arr) + '}';
  }

  public boolean addToArray(T el1) {
    int tmp = 0;
    while (tmp <= arr.length - 1) {
      if (arr[tmp] == null) {
        arr[tmp] = el1;
        return true;
      }
      tmp++;
    }
    return false;
  }

  public boolean swap(T el1, T el2) {
    int i2 = getIndex(el2);
    int i1 = getIndex(el1);
    if (i1 == -1 || i2 == -1) {
      System.out.println("Wrong data");
      return false;
    }
    T tmp = el1;
    arr[getIndex(el1)] = arr[i2];
    arr[i2] = tmp;
    return true;
  }

  private boolean contains(T el) {
    for (T elem : arr) {
      if (elem.equals(el)) {
        return true;
      }
    }
    return false;
  }

  private int getIndex(T el1) {
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] != null && arr[i].equals(el1)) {
        return i;
      }
    }
    return -1;
  }
}
