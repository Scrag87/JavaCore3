package lesson5.hw;

import java.util.concurrent.CyclicBarrier;

public class Car implements Runnable {
  private static int CARS_COUNT;
  static CyclicBarrier cb = new CyclicBarrier(4);
  private final Race race;
  private final int speed;
  private final String name;
  private static volatile boolean isRaceStartedFlag;

  public String getName() {
    return name;
  }

  public int getSpeed() {
    return speed;
  }

  public Car(Race race, int speed) {
    this.race = race;
    this.speed = speed;
    CARS_COUNT++;
    this.name = "Участник #" + CARS_COUNT;
    System.out.println(name + ". Speed: " +speed);
  }

  @Override
  public void run() {
    try {
      System.out.println(this.name + " готовится " + System.currentTimeMillis());
      Thread.sleep(500 + (int) (Math.random() * 800));
      System.out.println(this.name + " готов " + System.currentTimeMillis());
      cb.await();
      if (!isRaceStartedFlag ) {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
        isRaceStartedFlag = true;
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    for (int i = 0; i < race.getStages().size(); i++) {
      race.getStages().get(i).go(this);
    }
  }
}
