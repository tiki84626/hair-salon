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
             this.getId() == newStylist.getId() &&
             this.getHairSalonId() == newStylist.getHairSalonId();
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
      String sql = "SELECT * FROM clients where stylistId=:id;";
      return con.createQuery(sql)
        .addParameter("id", this.id)
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

}