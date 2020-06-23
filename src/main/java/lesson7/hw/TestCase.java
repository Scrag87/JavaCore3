package lesson7.hw;

@TestTargetClass
public class TestCase {
  int x = 2;
  int y = 3;
  int result = 5;

  @Test(setPriority = 5)
  public void someTestCase() throws Exception {
    int q = 3;
    int w = 3;
    if (!(q + w == 5)){
      throw new Exception();
    }
  }

  @Test(setPriority =1)
  public void someTestCase2() throws Exception {
    int q = 2;
    int w = 3;
    if (!(q + w == 5)){
      throw new Exception();
    }
  }
}
