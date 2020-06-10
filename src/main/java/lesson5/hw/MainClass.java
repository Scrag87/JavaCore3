package lesson5.hw;

public class MainClass {
  public static final int CARS_COUNT = 4;
  public static void main(String[] args) {

    Race race = new Race(new Road(60, false), new Tunnel(), new Road(40, true));
    Car[] cars = new Car[CARS_COUNT];
    for (int i = 0; i < cars.length; i++) {
      cars[i] = new Car(race, 10 + (int) (Math.random() * 30)+ (int) (Math.random() * 10));
    }

    System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
    for (int i = 0; i < cars.length; i++) {
      new Thread(cars[i]).start();
    }
  }
  /**
   * Все участники должны стартовать одновременно, несмотря на разное время подготовки.
   * В тоннель не может одновременно заехать больше половины участников (условность).
   * Первый участник, пересекший финишную черту, объявляется победителем (в момент
   * пересечения этой самой черты).
   * Победитель должен быть только один (ситуация с 0 или 2+победителями недопустима).
   * Когда все завершат гонку, нужно выдать объявление об окончании.
   * Можно корректировать классы (в том числе конструктор машин) и добавлять объекты классов из
   * пакета java.util.concurrent.
   */
}
