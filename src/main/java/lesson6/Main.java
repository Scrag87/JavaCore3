package lesson6;

import java.util.Arrays;
import org.apache.log4j.Logger;




public class Main {
  // Совсем не было времени. В течении недели пришлю Вам ДЗ.
  private static final org.apache.log4j.Logger log = Logger.getLogger(Main.class);
  public static void main(String[] args) {
    ArrayUtils arrayUtils = new ArrayUtils();
    log.info(Arrays.toString(arrayUtils.after4NumberExtractor(new Integer[]{1, 2, 3, 9, 5, 8, 7,
        1})));
  }
}
