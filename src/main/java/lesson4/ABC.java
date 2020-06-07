package lesson4;

/**
 * Создать три потока, каждый из которых выводит определенную букву (A, B и C) 5 раз (порядок –
 * ABСABСABС). Используйте wait/notify/notifyAll.
 */
public class ABC {
  private final Object mon = new Object();
  private volatile int order;
  private static final int NUMBER_OF_TIMES = 5;

  public static void main(String[] args) {
    ABC abc = new ABC();

    Thread t1 = new Thread(abc::printA);
    Thread t2 = new Thread(abc::printB);
    Thread t3 = new Thread(abc::printC);

    t1.start();
    t2.start();
    t3.start();
  }

  public void printA() {
    synchronized (mon) {
      try {
        for (int i = 0; i < NUMBER_OF_TIMES; i++) {
          while (order != 0) {
            mon.wait();
          }
          System.out.print(i + ". A" + " ");
          nextInOrder();
        }
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  public void printB() {
    synchronized (mon) {
      try {
        for (int i = 0; i < NUMBER_OF_TIMES; i++) {
          while (order != 1) {
            mon.wait();
          }
          System.out.print("B" + " ");
          nextInOrder();
        }
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  public void printC() {
    synchronized (mon) {
      try {
        for (int i = 0; i < NUMBER_OF_TIMES; i++) {
          while (order != 2) {
            mon.wait();
          }
          System.out.print("C" + " ");
          newCycle();
        }
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  private void nextInOrder() {
    order++;
    mon.notifyAll();
  }

  private void newCycle() {
    System.out.println();
    order = 0;
    mon.notifyAll();
  }
}
