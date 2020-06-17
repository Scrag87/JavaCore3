package lesson6;

import java.util.Arrays;
import lombok.extern.log4j.Log4j;
import org.apache.log4j.Level;

/**
 * Написать метод, которому в качестве аргумента передается не пустой одномерный целочисленный
 * массив. Метод должен вернуть новый массив, который получен путем вытаскивания из исходного
 * массива элементов, идущих после последней четверки. Входной массив должен содержать хотя бы одну
 * четверку, иначе в методе необходимо выбросить RuntimeException. Написать набор тестов для этого
 * метода (по 3-4 варианта входных данных). Вх: [ 1 2 4 4 2 3 4 1 7 ] -> вых: [ 1 7 ].
 */
@Log4j
public class ArrayUtils {

 private boolean fourNotHere = true;
  private int lastPositionOfFour = -1;

  public Integer[] after4NumberExtractor(Integer[] arr) {
    log.setLevel(Level.WARN);
    for (int i = 0; i < arr.length; i++) {
      log.debug("fourNotHere status " + fourNotHere);
      log.debug("lastPositionOfFour " + lastPositionOfFour);

      if (arr[i] == 4) {
        fourNotHere = false;
        lastPositionOfFour = i;
      }
    }
    if (fourNotHere) {
      throw new RuntimeException("4NotHere!");
    } else {
      return Arrays.copyOfRange(arr, lastPositionOfFour + 1, arr.length);
    }
  }
}
