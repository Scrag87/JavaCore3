package lesson5.hw;

import java.util.concurrent.Semaphore;

public class Tunnel extends Stage {
   static Semaphore smp = new Semaphore(2);
  public Tunnel() {
    this.length = 80;
    this.description = "Тоннель " + length + " метров " ;
    this.lastStage = false;
  }
  @Override
  public void go(Car c) {
    try {
      try {
      if( smp.availablePermits() == 0){
        System.out.println(c.getName() + " готовится к этапу(ждет): " + description + System.currentTimeMillis());
      }
        smp.acquire();
        System.out.println(c.getName() + " начал этап: " + description + System.currentTimeMillis());
        Thread.sleep(length / c.getSpeed() * 1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      } finally {
        System.out.println(c.getName() + " закончил этап: " + description + System.currentTimeMillis());
        smp.release();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
