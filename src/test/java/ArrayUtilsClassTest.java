import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.util.Arrays;
import java.util.Collection;
import lesson6.ArrayUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class ArrayUtilsClassTest {

  ArrayUtils arrayUtils;

  Integer[] inputArr;
  Integer[] resultArr;

  public ArrayUtilsClassTest(Integer[] inputArr, Integer[] resultArr) {
    this.inputArr = inputArr;
    this.resultArr = resultArr;
  }

  @Before
  public void initialize() {
    arrayUtils = new ArrayUtils();
  }

  @Parameterized.Parameters
  public static Collection testCases() {
    return Arrays.asList(
        new Integer[][][] {
          {{1, 2, 3, 4, 5, 6, 7, 8}, {5, 6, 7, 8}},
          {{1, 2, 3, 4, 5, 6, 4, 8}, {8}},
          {{1, 4, 3, 9, 5, 6, 7, 8}, {3, 9, 5, 6, 7, 8}},
          {{1, 2, 3, 4, 5, 6, 7, 4}, {}},
        });
  }

  @Test
  public void name() {
    System.out.println("input: " + Arrays.toString(inputArr));
    ArrayUtils arrayUtils = new ArrayUtils();
    Integer[] resArr = arrayUtils.after4NumberExtractor(inputArr);
    System.out.println("output: " + Arrays.toString(resArr));
    assertThat(resArr, equalTo(resArr));
  }

   @Test(expected = RuntimeException.class)
  public void shouldThrowRuntimeException() {
    ArrayUtils arrayUtils = new ArrayUtils();
    arrayUtils.after4NumberExtractor(new Integer[]{1, 2, 3, 9, 5, 8, 7, 1});
  }

}
