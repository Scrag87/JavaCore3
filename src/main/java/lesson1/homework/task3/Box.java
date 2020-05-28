package lesson1.homework.task3;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit>  {
  private T fruit;
  private float weight = 0;
  private List<T> list = new ArrayList<>();

  public Box(T fruit) {
    this.fruit = fruit;
    if (fruit.weight == 0) {
      return;
    }
    this.weight = fruit.getWeight();
    list.add(fruit);
  }

  public float getWeight() {
    return weight;
  }

  public Box(float weight) {
    this.weight = weight;
  }

  public boolean compare(Box box) {
    return this.weight == box.weight;
  }

  public boolean move(Box<T> box) {
    if (this.list.isEmpty()) {
      System.out.print("Nothing to move!  ");
      return false;
    }
    box.list.addAll(this.list);
    recountWeight(box);
    this.weight = 0;
    this.list.clear();
    return true;
  }

  public boolean add(T fruit) {
    if (fruit.weight == 0 ){
      return false;
    }
    list.add(fruit);
    weight += fruit.getWeight();
    System.out.println("Add new fruit " + getClassOfFruit() + ". weight is " + fruit.weight);
    return true;
  }

  void recountWeight(Box<T> box) {
    box.weight = 0;
    for (int i = 0; i < box.list.size(); i++) {
      box.weight += box.list.get(i).weight;
    }
  }

  public String getClassOfFruit() {
    return this.fruit.getClass().getSimpleName();
  }


}
