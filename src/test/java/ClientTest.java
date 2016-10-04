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

}
