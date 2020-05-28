package lesson1.homework.task3;

public class Orange extends Fruit  {

  public Orange() {
    this.weight=1.0F;
  }
  public Orange(float weight){
    this.weight = weight;
  }
  @Override
  public float getWeight() {
    return weight;
  }


}
