import java.util.List;
import java.util.ArrayList;
import org.sql2o.*;

public class Board{
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

  public Stylist(String _name, String _email; String _phoneNumber; int _hairSalonId) {
    name = _name;
    email = _email;
    phoneNumber = _phoneNumber;
    hairSalonId = _hairSalonId;
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
      return con.createQuery(sql).executeAndFetch(Board.class);
    }
  }



  public List<Review> getReviews() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM reviews where boardId=:id;";
      return con.createQuery(sql)
        .addParameter("id", this.id)
        .executeAndFetch(Review.class);
    }
  }

  public void save(){
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO boards (name, imgURL, boardType, thickness, price, length, fin, tail, companyId, width) VALUES (:name, :imgURL, :boardType, :thickness, :price, :length, :fin, :tail, :companyId, :width)";
      this.id = (int) con.createQuery(sql, true)
        .addParameter("name", this.name)
        .addParameter("imgURL", this.imgURL)
        .addParameter("boardType", this.boardType)
        .addParameter("thickness", this.thickness)
        .addParameter("price", this.price)
        .addParameter("length", this.length)
        .addParameter("fin", this.fin)
        .addParameter("tail", this.tail)
        .addParameter("companyId", this.companyId)
        .addParameter("width", this.width)
        .executeUpdate().getKey();
    }
  }

  public static Board find(int id) {
    try(Connection con = DB.sql2o.open()){
      String sql = "SELECT * FROM boards where id=:id;";
      Board board = con.createQuery(sql)
        .addParameter("id", id)
        .executeAndFetchFirst(Board.class);
      return board;
    }
  }

  public void update()
    {
      try(Connection con = DB.sql2o.open()) {
        String sql = "UPDATE boards SET (name, imgURL, boardType, thickness, price, " +
                     "length, fin, tail, companyId, width) = (:name, :imgURL, :boardType, " +
                     ":thickness, :price, :length, :fin, :tail, :companyId, :width) WHERE id = :id;";
        con.createQuery(sql)
          .addParameter("name", this.name)
          .addParameter("imgURL", this.imgURL)
          .addParameter("boardType", this.boardType)
          .addParameter("thickness", this.thickness)
          .addParameter("price", this.price)
          .addParameter("length", this.length)
          .addParameter("fin", this.fin)
          .addParameter("tail", this.tail)
          .addParameter("companyId", this.companyId)
          .addParameter("id", this.id)
          .addParameter("width", this.width)
          .executeUpdate();
    }
  }

  public void delete() {
    try(Connection con = DB.sql2o.open()) {
    String sql = "DELETE FROM boards WHERE id = :id;";
    con.createQuery(sql)
      .addParameter("id", id)
      .executeUpdate();
    }
  }
}
