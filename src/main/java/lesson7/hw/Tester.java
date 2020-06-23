package lesson7.hw;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Tester {
  Map<Method, Integer> executePriority = new HashMap<>();

  public void testThis(Class<?> cl) {

    for (Method m : cl.getMethods()) {
      if (m.isAnnotationPresent(Test.class)) {
        executePriority.put(m, m.getAnnotation(Test.class).setPriority());
      }
    }
    System.out.println("map " + executePriority);

    Map<Method,Integer> sortedExec =
        executePriority.entrySet().stream()
            .sorted(Map.Entry.comparingByValue())
            .collect(Collectors.toMap(
                Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

    System.out.println(sortedExec);

    sortedExec.forEach(
        (x, y) -> {
          System.out.println("" + y);
          try {
            x.invoke(null);
            System.out.println("pass");
          } catch (Exception e) {
            e.printStackTrace();
            System.out.println("fail");
          }
        });
  }
}
