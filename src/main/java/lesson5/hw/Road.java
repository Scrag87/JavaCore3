package lesson5.hw;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class Road extends Stage {
  Semaphore smp = new Semaphore(1);
  CyclicBarrier cb = new CyclicBarrier(4);
  volatile boolean isWinFlag;
  volatile boolean isRaceFinishedFlag;

  public Road(int length, boolean lastStage) {
    this.length = length;
    this.description = "Дорога " + length + " метров ";
    this.lastStage = lastStage;
  }

  @Override
  public void go(Car c) {
    try {
      System.out.println(c.getName() + " начал этап: " + description + System.currentTimeMillis());
      Thread.sleep(length / c.getSpeed());
      System.out.println(
          c.getName() + " закончил этап: " + description + System.currentTimeMillis());
      if (lastStage) {
        smp.acquire();
        if (!isWinFlag) {
          System.out.println(c.getName() + " Win !!!");
          isWinFlag = true;
          smp.release();
        } else {
          smp.release();
        }
        cb.await();
        smp.acquire();
        if (!isRaceFinishedFlag) {
          System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
          isRaceFinishedFlag = true;
          smp.release();
        }else {
          smp.release();
        }
      }

    } catch (InterruptedException | BrokenBarrierException e) {
      e.printStackTrace();
    }
  }
}
