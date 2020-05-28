package lesson1.homework.task3;

public class Apple extends Fruit {

  public Apple() {
    this.weight= getWeight();
  }
  public Apple(float weight){
    this.weight = weight;
  }

  @Override
  public float getWeight() {
    return 1.5F;
  }

 
}
