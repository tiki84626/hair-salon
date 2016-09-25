import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;

public class HairSalonTest{
  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void hairSalon_instanitatesCorrectly_true() {
    HairSalon testHairSalon = new HairSalon("Ginger Salon", "Portland, OR", "http://www.gingersalon.com/", "A tiny salon with three locations, and just two chairs at each location, we specialize in everything fabulous. Period.");
    assertEquals(true, testHairSalon instanceof HairSalon);
  }
  
}
