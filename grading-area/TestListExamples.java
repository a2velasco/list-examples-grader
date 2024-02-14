import static org.junit.Assert.*;
import org.junit.*;
import java.util.Arrays;
import java.util.List;

class IsMoon implements StringChecker {
  public boolean checkString(String s) {
    return s.equalsIgnoreCase("moon");
  }
}

public class TestListExamples {
  @Test (timeout = 500)
  public void testMergeRightEnd() {
    List<String> left = Arrays.asList("a", "b", "c");
    List<String> right = Arrays.asList("a", "d");
    List<String> merged = ListExamples.merge(left, right);
    List<String> expected = Arrays.asList("a", "a", "b", "c", "d");
    assertEquals(expected, merged);
  }

  @Test (timeout = 500)
  public void testMergeLeftEnd() {
    List<String> left = Arrays.asList("a", "b", "c");
    List<String> right = Arrays.asList("a", "d");
    List<String> merged = ListExamples.merge(right, left);
    List<String> expected = Arrays.asList("a", "a", "b", "c", "d");
    assertEquals(expected, merged);
  }

  @Test (timeout = 500)
  public void testFilterOneMoon() {
    IsMoon sc = new IsMoon();
    List<String> input = Arrays.asList("The", "brown", "moon", "dog", "ran.");
    List<String> filtered = ListExamples.filter(input, sc);
    List<String> expected = Arrays.asList("moon");
    assertEquals(expected, filtered);
  }

  @Test (timeout = 500)
  public void testFilterMultiMoon() {
    IsMoon sc = new IsMoon();
    List<String> input = Arrays.asList("The", "brown", "moon", "dog", "MOON", "ran.", "mOoN");
    List<String> filtered = ListExamples.filter(input, sc);
    List<String> expected = Arrays.asList("moon", "MOON", "mOoN");
    assertEquals(expected, filtered);
  }
}
