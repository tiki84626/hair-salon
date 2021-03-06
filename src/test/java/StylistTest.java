import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.sql.Date;

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

  @Test
  public void getId_grabsIdFromStylistObject_true() {
    Stylist testStylist = new Stylist("Susan", "susan@test.com", "123-456-7890", 1);
    testStylist.save();
    assertTrue(testStylist.getId() > 0);
  }

  @Test
  public void all_grabsAllStylists_true() {
    Stylist testStylist1 = new Stylist("Susan", "susan@test.com", "123-456-7890", 1);
    testStylist1.save();
    Stylist testStylist2 = new Stylist("Barb", "barb@test.com", "456-123-7890", 2);
    testStylist2.save();
    assertEquals(true, Stylist.all().get(0).equals(testStylist1));
    assertEquals(true, Stylist.all().get(1).equals(testStylist2));
  }

  @Test
  public void find_findsStylistAssociatedWithId_true() {
    Stylist testStylist1 = new Stylist("Susan", "susan@test.com", "123-456-7890", 1);
    testStylist1.save();
    Stylist testStylist2 = new Stylist("Barb", "barb@test.com", "456-123-7890", 2);
    testStylist2.save();
    assertEquals(Stylist.find(testStylist2.getId()), testStylist2);
  }

  @Test
  public void getClients_retrievesClientsFromStylistObject_true() {
    Stylist testStylist = new Stylist("Susan", "susan@test.com", "123-456-7890", 1);
    int stylistid = testStylist.getId();
    Date client1Appointment = Date.valueOf("2016-10-22");
    Client testClient1 = new Client("Bob", "bob@test.com", "123-456-7890", client1Appointment, stylistid);
    testClient1.save();
    Date client2Appointment = Date.valueOf("2016-10-28");
    Client testClient2 = new Client("Anna", "anna@test.com", "456-123-7890", client2Appointment, stylistid);
    testClient2.save();
    assertTrue(testStylist.getClients().get(0).equals(testClient1) &&
               testStylist.getClients().get(1).equals(testClient2));
  }

}
