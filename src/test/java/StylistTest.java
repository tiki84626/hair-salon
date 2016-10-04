import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;

public class StylistTest {
  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void stylist_instantiatesCorrectly_true() {
    Stylist testStylist = new Stylist("Susan Smith", "susansmith@gmail.com", "123-456-7890", 1);
    assertEquals(true, testStylist instanceof Stylist);
  }

}
