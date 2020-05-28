package lesson1.homework;

import java.util.function.Consumer;
import lesson1.homework.task3.Apple;
import lesson1.homework.task3.Box;
import lesson1.homework.task3.Orange;

public class Main {
  public static void main(String[] args) {
    // task1();
    // task2();
    task3();
  }

  private static void task3() {
    Box<Apple> appleBox = new Box<>(new Apple(0));
    Box<Apple> appleBox2 = new Box<>(new Apple(0));
    Box<Orange> orangeBox = new Box<>(new Orange(0));
    Box<Orange> orangeBox2 = new Box<>(new Orange(0));

    printBoxes(orangeBox, orangeBox2, appleBox, appleBox2);

    orangeBox.add(new Orange());
    orangeBox.add(new Orange(2)); //HUUUUGE ORANGE!!!

    printBoxes(orangeBox, orangeBox2, appleBox, appleBox2);

    orangeBox.add(new Orange());

    printBoxes(orangeBox, orangeBox2, appleBox, appleBox2);
    printResultOfCompareBoxes(orangeBox, orangeBox2);

    System.out.println("move " + orangeBox.move(orangeBox2));
    System.out.println("move " + appleBox.move(appleBox2));

    printBoxes(orangeBox, orangeBox2, appleBox, appleBox2);

    appleBox.add(new Apple());

    printResultOfCompareBoxes(orangeBox2,appleBox);

    appleBox.add(new Apple());

    printBoxes(orangeBox, orangeBox2, appleBox, appleBox2);
    printResultOfCompareBoxes(orangeBox2,appleBox);

    appleBox.add(new Apple());
    printBoxes(orangeBox, orangeBox2, appleBox, appleBox2);
  }

  private static void printResultOfCompareBoxes(Box box1, Box box2) {
    System.out.print(
        "\t\tcompare boxes "
            + box1.getClassOfFruit()
            + " with "
            + box2.getClassOfFruit()
            + " is "
            + box1.compare(box2));
    System.out.println();
  }

  private static void printBoxes(Box... boxes) {
    System.out.println();
    for (int i = 0; i < boxes.length; i++) {
      Box box = boxes[i];
      System.out.print(
          "\t\t"
              + box.getClassOfFruit()
              + " weight in box "
              + (i + 1)
              + " is "
              + box.getWeight());
    }
    System.out.println();
    System.out.println();
  }

  private static void task2() {
    Integer[] ints = {1, 12, 3, 4, 5};
    Float[] floats = {1F, 12F, 3F, 4F, 5F};
    String[] strings = {
      "a", "b", "c", "d",
    };
    Task2 task2 = new Task2();

    System.out.println(task2.toList(ints).getClass().getName());
    System.out.println(task2.toList(floats).getClass().getName());
    System.out.println(task2.toList(strings).getClass().getName());

    System.out.println(task2.toList(ints));
    System.out.println(task2.toList(floats));
    System.out.println(task2.toList(strings));
  }

  private static void task1() {
    Consumer<? super Object> printer = c -> System.out.println("print " + c.toString());

    Task1<String> stringtask = new Task1<>(10);
    printer.accept(stringtask);
    System.out.println(stringtask.addToArray("World "));
    System.out.println(stringtask.addToArray("Hello "));
    System.out.println(stringtask.addToArray(" ! "));
    printer.accept(stringtask);
    stringtask.swap("World ", "Hello ");
    printer.accept(stringtask);

    Task1<Integer> integerTask = new Task1<>(4);
    printer.accept(integerTask);
    integerTask.addToArray(2);
    integerTask.addToArray(5);
    integerTask.addToArray(7);
    printer.accept(integerTask);
    integerTask.swap(2, 7);
    printer.accept(integerTask);
  }
}
