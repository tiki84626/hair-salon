import java.util.List;
import java.util.ArrayList;
import org.sql2o.*;

public class HairSalon {
  private String name;
  private String location;
  private String website;
  private String description;
  private List<Stylist> stylists;
  private int id;

  @Override
  public boolean equals(Object otherHairSalon) {
    if (!(otherHairSalon instanceof HairSalon)) {
      return false;
    } else {
      HairSalon newHairSalon = (HairSalon) otherHairSalon;
      return this.getName().equals(newHairSalon.getName()) &&
             this.getLocation().equals(newHairSalon.getLocation()) &&
             this.getWebsite().equals(newHairSalon.getWebsite()) &&
             this.getDescription().equals(newHairSalon.getDescription()) &&
             this.getId() == newHairSalon.getId();
    }
  }

  public HairSalon(String _name, String _location, String _website, String _description) {
      name = _name;
      location = _location;
      website = _website;
      description = _description;
    }

  public void setName(String _name) {
    this.name = _name;
  }

  public void setLocation(String _location) {
    this.location = _location;
  }

  public void setWebsite(String _website) {
    this.website = _website;
  }

  public void setDescription(String _description) {
    this.description = _description;
  }

  public String getName() {
    return name;
  }

  public String getLocation() {
    return location;
  }

  public String getWebsite() {
    return website;
  }

  public String getDescription() {
    return description;
  }

  public int getId() {
    return id;
  }

  public static List<HairSalon> all() {
    String sql = "SELECT * FROM hair_salons;";
    try(Connection con = DB.sql2o.open()){
      return con.createQuery(sql).executeAndFetch(HairSalon.class);
    }
  }

  public static HairSalon find(int id) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM hair_salons where id = :id;";
      HairSalon hair_salon = con.createQuery(sql)
        .addParameter("id", id)
        .executeAndFetchFirst(HairSalon.class);
      return hair_salon;
    }
  }

  public List<Stylist> getStylists() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM stylists WHERE hairsalonid = :id;";
      return con.createQuery(sql)
        .addParameter("id", id)
        .executeAndFetch(Stylist.class);
    }
  }

  public void save() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO hair_salons (name, location, website, " +
                   "description) VALUES (:name, :location, :website, " +
                   ":description);";
      this.id = (int) con.createQuery(sql, true)
        .addParameter("name", this.name)
        .addParameter("location", this.location)
        .addParameter("website", this.website)
        .addParameter("description", this.description)
        .executeUpdate().getKey();
    }
  }

  public void update() {
      try(Connection con = DB.sql2o.open()) {
        String sql = "UPDATE hair_salons SET name = :name, location = :location, " +
                     "website = :website, description = :description WHERE id = :id;";

        con.createQuery(sql)
          .addParameter("name", this.name)
          .addParameter("location", this.location)
          .addParameter("website", this.website)
          .addParameter("description", this.description)
          .addParameter("id", this.id)
          .executeUpdate();
    }
  }

  public void delete() {
    try(Connection con = DB.sql2o.open()) {
    String sql = "DELETE FROM hair_salons WHERE id = :id;";
    con.createQuery(sql)
      .addParameter("id", id)
      .executeUpdate();
    }
  }
}
