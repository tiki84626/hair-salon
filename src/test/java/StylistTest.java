import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;

public class StylistTest {
  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void stylist_instantiatesCorrectly_true() {
    Stylist testStylist = new Stylist("Barbara Smith", "barb.sm1th@gmail.com");
    assertEquals(true, testStylist instanceof Stylist);
  }

}
