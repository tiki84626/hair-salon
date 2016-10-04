import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.sql.Date;

public class ClientTest {
  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void client_instantiatesCorrectly_true() {
    Date testClientAppointment = Date.valueOf("2016-10-22");
    Client testClient = new Client("Bob", "bob@test.com", "123-456-7890", testClientAppointment, 1);
    assertEquals(true, testClient instanceof Client);
  }

  @Test
  public void getName_grabsNameFromClientObject_String() {
    Date testClientAppointment = Date.valueOf("2016-10-22");
    Client testClient = new Client("Bob", "bob@test.com", "123-456-7890", testClientAppointment, 1);
    assertEquals("Bob", testClient.getName());
  }

  @Test
  public void getEmail_grabsEmailFromClientObject_String() {
    Date testClientAppointment = Date.valueOf("2016-10-22");
    Client testClient = new Client("Bob", "bob@test.com", "123-456-7890", testClientAppointment, 1);
    assertEquals("bob@test.com", testClient.getEmail());
  }

  @Test
  public void getPhoneNumber_grabsPhoneNumberFromClientObject_String() {
    Date testClientAppointment = Date.valueOf("2016-10-22");
    Client testClient = new Client("Bob", "bob@test.com", "123-456-7890", testClientAppointment, 1);
    assertEquals("123-456-7890", testClient.getPhoneNumber());
  }

  @Test
  public void getAppointment_grabsAppointmentFromClientObject_String() {
    Date testClientAppointment = Date.valueOf("2016-10-22");
    Client testClient = new Client("Bob", "bob@test.com", "123-456-7890", testClientAppointment, 1);
    assertEquals(testClientAppointment, testClient.getAppointment());
  }

  @Test
  public void getStylistId_grabsStylistIdFromClientObject_String() {
    Date testClientAppointment = Date.valueOf("2016-10-22");
    Client testClient = new Client("Bob", "bob@test.com", "123-456-7890", testClientAppointment, 1);
    assertEquals(1, testClient.getStylistId());
  }

  @Test
  public void equals_compareTwoHairSalonObjects_true() {
    Date testClientAppointment = Date.valueOf("2016-10-22");
    Client testClient1 = new Client("Bob", "bob@test.com", "123-456-7890", testClientAppointment, 1);
    Client testClient2 = new Client("Bob", "bob@test.com", "123-456-7890", testClientAppointment, 1);
    assertEquals(true, testClient1.equals(testClient2));
  }

  @Test
  public void save_savesClient_true() {
    Date testClientAppointment = Date.valueOf("2016-10-22");
    Client testClient = new Client("Bob", "bob@test.com", "123-456-7890", testClientAppointment, 1);
    testClient.save();
    assertTrue(Client.all().get(0).equals(testClient));
  }

}
