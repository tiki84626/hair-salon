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

  @Test
  public void all_grabsAllClients_true() {
    Date client1Appointment = Date.valueOf("2016-10-22");
    Client testClient1 = new Client("Bob", "bob@test.com", "123-456-7890", client1Appointment, 1);
    testClient1.save();
    Date client2Appointment = Date.valueOf("2016-10-28");
    Client testClient2 = new Client("Anna", "anna@test.com", "456-123-7890", client2Appointment, 1);
    testClient2.save();
    assertEquals(true, Client.all().get(0).equals(testClient1));
    assertEquals(true, Client.all().get(1).equals(testClient2));
  }

  @Test
  public void setName_updatesNameOfClientObject_String() {
    Date testClientAppointment = Date.valueOf("2016-10-22");
    Client testClient = new Client("Bob", "bob@test.com", "123-456-7890", testClientAppointment, 1);
    testClient.save();
    testClient.setName("Nick");
    assertEquals("Nick", testClient.getName());
  }

  @Test
  public void setEmail_updatesEmailOfClientObject_String() {
    Date testClientAppointment = Date.valueOf("2016-10-22");
    Client testClient = new Client("Bob", "bob@test.com", "123-456-7890", testClientAppointment, 1);
    testClient.save();
    testClient.setEmail("bob1@test.com");
    assertEquals("bob1@test.com", testClient.getEmail());
  }

  @Test
  public void setPhoneNumber_updatesPhoneNumberOfClientObject_String() {
    Date testClientAppointment = Date.valueOf("2016-10-22");
    Client testClient = new Client("Bob", "bob@test.com", "123-456-7890", testClientAppointment, 1);
    testClient.save();
    testClient.setPhoneNumber("986-987-3578");
    assertEquals("986-987-3578", testClient.getPhoneNumber());
  }

  @Test
  public void setAppointment_updatesAppointmentOfClientObject_String() {
    Date testClientAppointment = Date.valueOf("2016-10-22");
    Client testClient = new Client("Bob", "bob@test.com", "123-456-7890", testClientAppointment, 1);
    testClient.save();
    Date newAppointment = Date.valueOf("2016-10-23");
    testClient.setAppointment(newAppointment);
    assertEquals(newAppointment, testClient.getAppointment());
  }

  @Test
  public void setStylistId_updatesStylistIdOfClientObject_String() {
    Date testClientAppointment = Date.valueOf("2016-10-22");
    Client testClient = new Client("Bob", "bob@test.com", "123-456-7890", testClientAppointment, 1);
    testClient.save();
    testClient.setStylistId(2);
    assertEquals(2, testClient.getStylistId());
  }

  @Test
  public void find_findsClientWithSameId_true() {
    Date testClientAppointment = Date.valueOf("2016-10-22");
    Client testClient = new Client("Bob", "bob@test.com", "123-456-7890", testClientAppointment, 1);
    testClient.save();
    assertEquals(Client.find(testClient.getId()), testClient);
  }

}
