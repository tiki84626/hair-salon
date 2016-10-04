import java.util.List;
import java.util.ArrayList;
import org.sql2o.*;

public class Stylist{
  private String name;
  private String email;
  private String phoneNumber;
  private int id;
  private int hairSalonId;
  private List<Client> clients;

  @Override
  public boolean equals(Object otherStylist){
    if(!(otherStylist instanceof Stylist)){
      return false;
    } else {
      Stylist newStylist = (Stylist) otherStylist;
      return this.getName().equals(newStylist.getName()) &&
             this.getEmail().equals(newStylist.getEmail()) &&
             this.getPhoneNumber().equals(newStylist.getPhoneNumber()) &&
             this.getHairSalonId() == newStylist.getHairSalonId() &&
             this.getId() == newStylist.getId();
    }
  }

  public Stylist(String _name, String _email, String _phoneNumber, int _hairSalonId) {
    this.name = _name;
    this.email = _email;
    this.phoneNumber = _phoneNumber;
    this.hairSalonId = _hairSalonId;
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

  public void setHairSalonId(int _hairSalonId){
    this.hairSalonId = _hairSalonId;
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

  public int getHairSalonId(){
    return hairSalonId;
  }

  public int getId() {
    return id;
  }

  public static List<Stylist> all() {
    String sql = "SELECT * FROM stylists;";
    try(Connection con = DB.sql2o.open()){
      return con.createQuery(sql).executeAndFetch(Stylist.class);
    }
  }

  public List<Client> getClients() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM clients WHERE stylistid = :id;";
      return con.createQuery(sql)
        .addParameter("id", id)
        .executeAndFetch(Client.class);
    }
  }

  public void save() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO stylists (name, email, phonenumber, " +
                   "hairsalonid) VALUES (:name, :email, :phonenumber, " +
                   ":hairsalonid);";
      this.id = (int) con.createQuery(sql, true)
        .addParameter("name", this.name)
        .addParameter("email", this.email)
        .addParameter("phonenumber", this.phoneNumber)
        .addParameter("hairsalonid", this.hairSalonId)
        .executeUpdate().getKey();
    }
  }

  public void update() {
      try(Connection con = DB.sql2o.open()) {
        String sql = "UPDATE stylists SET name = :name, email = :email, " +
                     "phonenumber = :phonenumber, hairsalonid = :hairsalonid " +
                     "WHERE id = :id;";

        con.createQuery(sql)
          .addParameter("name", this.name)
          .addParameter("email", this.email)
          .addParameter("phonenumber", this.phoneNumber)
          .addParameter("hairsalonid", this.hairSalonId)
          .addParameter("id", this.id)
          .executeUpdate();
    }
  }

  public static Stylist find(int id) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM stylists where id = :id;";
      Stylist stylist = con.createQuery(sql)
        .addParameter("id", id)
        .executeAndFetchFirst(Stylist.class);
      return stylist;
    }
  }

  public void delete() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "DELETE FROM stylists WHERE id = :id;";
      con.createQuery(sql)
      .addParameter("id", id)
      .executeUpdate();
    }
  }

}
