import java.util.List;
import java.util.ArrayList;
import org.sql2o.*;
import java.sql.Date;

public class Client{
  private String name;
  private String email;
  private String phoneNumber;
  private Date appointment;
  private int id;
  private int stylistId;

  @Override
  public boolean equals(Object otherClient){
    if(!(otherClient instanceof Client)){
      return false;
    } else {
      Client newClient = (Client) otherClient;
      return this.getName().equals(newClient.getName()) &&
             this.getEmail().equals(newClient.getEmail()) &&
             this.getPhoneNumber().equals(newClient.getPhoneNumber()) &&
             this.getAppointment().equals(newClient.getAppointment()) &&
             this.getStylistId() == newClient.getStylistId() &&
             this.getId() == newClient.getId();
    }
  }

  public Client(String _name, String _email, String _phoneNumber, Date _appointment, int _stylistId) {
    this.name = _name;
    this.email = _email;
    this.phoneNumber = _phoneNumber;
    this.appointment = _appointment;
    this.stylistId = _stylistId;
  }

  public void setName(String _name) {
    this.name = _name;
  }

  public void setEmail(String _email) {
    this.email = _email;
  }

  public void setPhoneNumber(String _phoneNumber) {
    this.phoneNumber = _phoneNumber;
  }

  public void setAppointment(Date _appointment) {
    this.appointment = _appointment;
  }

  public void setStylistId(int _stylistId){
    this.stylistId = _stylistId;
  }

  public String getName() {
    return name;
  }

  public String getEmail() {
    return email;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public Date getAppointment() {
    return appointment;
  }

  public int getStylistId(){
    return stylistId;
  }

  public int getId() {
    return id;
  }

  public void save() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO clients (name, email, phonenumber, " +
                   "appointment, stylistid) VALUES (:name, :email, :phonenumber, " +
                   ":appointment, :stylistid);";
      this.id = (int) con.createQuery(sql, true)
        .addParameter("name", this.name)
        .addParameter("email", this.email)
        .addParameter("phonenumber", this.phoneNumber)
        .addParameter("appointment", this.appointment)
        .addParameter("stylistid", this.stylistId)
        .executeUpdate().getKey();
    }
  }

  public void update() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "UPDATE clients SET (name, email, phonenumber, appointment, stylistid) = (:name, :emali, :phonenumber, :appointment, :stylistid) WHERE id = :id;";
      con.createQuery(sql)
      .addParameter("name", this.name)
      .addParameter("email", this.email)
      .addParameter("phonenumber", this.phoneNumber)
      .addParameter("appointment", this.appointment)
      .addParameter("stylistid", this.stylistId)
      .addParameter("id", this.id)
      .executeUpdate();
    }
  }

  public static Client find(int id) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM clients WHERE id = :id;";
      Client client = con.createQuery(sql)
        .addParameter("id", id)
        .executeAndFetchFirst(Client.class);
        return client;
    }
  }

  public void delete() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "DELETE FROM clients WHERE id = :id;";
      con.createQuery(sql)
        .addParameter("id", this.id)
        .executeUpdate();
    }
  }



}
