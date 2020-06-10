package lesson5.hw;

public abstract class Stage {
  volatile boolean lastStage;
  protected int length;
  protected String description =" " +System.currentTimeMillis();
  public String getDescription() {
    return description;
  }
  public abstract void go(Car c);
}
