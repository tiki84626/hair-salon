import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;

public class StylistTest {
  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void stylist_instantiatesCorrectly_true() {
    Stylist testStylist = new Stylist("Susan", "susan@test.com", "123-456-7890", 1);
    assertEquals(true, testStylist instanceof Stylist);
  }

  @Test
  public void getName_grabsNameFromStylistObject_String() {
    Stylist testStylist = new Stylist("Susan", "susan@test.com", "123-456-7890", 1);
    assertEquals("Susan", testStylist.getName());
  }

  @Test
  public void getPhoneNumber_grabsPhoneNumberFromStylistObject_String() {
    Stylist testStylist = new Stylist("Susan", "susan@test.com", "123-456-7890", 1);
    assertEquals("123-456-7890", testStylist.getPhoneNumber());
  }

  @Test
  public void getEmail_grabsEmailFromStylistObject_String() {
    Stylist testStylist = new Stylist("Susan", "susan@test.com", "123-456-7890", 1);
    assertEquals("susan@test.com", testStylist.getEmail());
  }

  @Test
  public void getHairSalonId_grabsHairSalonIdFromStylistObject_String() {
    Stylist testStylist = new Stylist("Susan", "susan@test.com", "123-456-7890", 1);
    assertEquals(1, testStylist.getHairSalonId());
  }

}
