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
  public void getEmail_grabsEmailFromStylistObject_String() {
    Stylist testStylist = new Stylist("Susan", "susan@test.com", "123-456-7890", 1);
    assertEquals("susan@test.com", testStylist.getEmail());
  }

  @Test
  public void getPhoneNumber_grabsPhoneNumberFromStylistObject_String() {
    Stylist testStylist = new Stylist("Susan", "susan@test.com", "123-456-7890", 1);
    assertEquals("123-456-7890", testStylist.getPhoneNumber());
  }

  @Test
  public void getHairSalonId_grabsHairSalonIdFromStylistObject_String() {
    Stylist testStylist = new Stylist("Susan", "susan@test.com", "123-456-7890", 1);
    assertEquals(1, testStylist.getHairSalonId());
  }

  @Test
  public void save_savesStylist_true() {
    Stylist testStylist = new Stylist("Susan", "susan@test.com", "123-456-7890", 1);
    testStylist.save();
    assertTrue(Stylist.all().get(0).equals(testStylist));
  }

  @Test
  public void equals_compareTwoHairSalonObjects_true() {
    Stylist testStylist1 = new Stylist("Susan", "susan@test.com", "123-456-7890", 1);
    Stylist testStylist2 = new Stylist("Susan", "susan@test.com", "123-456-7890", 1);
    assertEquals(true, testStylist1.equals(testStylist2));
  }

  @Test
  public void setName_updatesNameOfStylistObject_String() {
    Stylist testStylist = new Stylist("Susan", "susan@test.com", "123-456-7890", 1);
    testStylist.save();
    testStylist.setName("Susan Smith");
    testStylist.update();
    assertEquals("Susan Smith", testStylist.getName());
  }

  @Test
  public void setEmail_updatesEmailOfStylistObject_String() {
    Stylist testStylist = new Stylist("Susan", "susan@test.com", "123-456-7890", 1);
    testStylist.save();
    testStylist.setEmail("susan1@test.com");
    testStylist.update();
    assertEquals("susan1@test.com", testStylist.getEmail());
  }

  @Test
  public void setPhoneNumber_updatesPhoneNumberOfStylistObject_String() {
    Stylist testStylist = new Stylist("Susan", "susan@test.com", "123-456-7890", 1);
    testStylist.save();
    testStylist.setPhoneNumber("123-456-7891");
    testStylist.update();
    assertEquals("123-456-7891", testStylist.getPhoneNumber());
  }

  @Test
  public void setHairSalonId_updatesHairSalonIdOfStylistObject_String() {
    Stylist testStylist = new Stylist("Susan", "susan@test.com", "123-456-7890", 1);
    testStylist.save();
    testStylist.setHairSalonId(2);
    testStylist.update();
    assertEquals(2, testStylist.getHairSalonId());
  }

}
