import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;

public class HairSalonTest{
  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void hairSalon_instanitatesCorrectly_true() {
    HairSalon testHairSalon = new HairSalon("Ginger Salon", "Portland, OR", "http://www.gingersalon.com/", "A tiny salon with three locations, and just two chairs at each location, we specialize in everything fabulous. Period.");
    assertEquals(true, testHairSalon instanceof HairSalon);
  }

  @Test
  public void getName_grabsNameFromHairSalonObject_String() {
    HairSalon testHairSalon = new HairSalon("Ginger Salon", "Portland, OR", "http://www.gingersalon.com/", "A tiny salon with three locations, and just two chairs at each location, we specialize in everything fabulous. Period.");
    assertEquals("Ginger Salon", testHairSalon.getName());
  }

  @Test
  public void setName_updatesNameOfHairSalonObject_String() {
    HairSalon testHairSalon = new HairSalon("Ginger Salon", "Portland, OR", "http://www.gingersalon.com/", "A tiny salon with three locations, and just two chairs at each location, we specialize in everything fabulous. Period.");
    testHairSalon.save();
    testHairSalon.setName("Ginger Salon");
    testHairSalon.update();
    assertEquals("Ginger Salon", testHairSalon.getName());
  }

  @Test
  public void getLocation_grabsLocationFromCompanyObject_String() {
    HairSalon testHairSalon = new HairSalon("Ginger Salon", "Portland, OR", "http://www.gingersalon.com/", "A tiny salon with three locations, and just two chairs at each location, we specialize in everything fabulous. Period.");
    assertEquals("Portland, OR", testHairSalon.getLocation());
  }

  @Test
  public void setLocation_updatesLocationOfHairSalonObject_String() {
    HairSalon testHairSalon = new HairSalon("Ginger Salon", "Portland, OR", "http://www.gingersalon.com/", "A tiny salon with three locations, and just two chairs at each location, we specialize in everything fabulous. Period.");
    testHairSalon.save();
    testHairSalon.setLocation("Portland, OR");
    testHairSalon.update();
    assertEquals("Portland, OR", testHairSalon.getLocation());
  }

  @Test
  public void getWebsite_grabsWebsiteFromCompanyObject_String() {
    HairSalon testHairSalon = new HairSalon("Ginger Salon", "Portland, OR", "http://www.gingersalon.com/", "A tiny salon with three locations, and just two chairs at each location, we specialize in everything fabulous. Period.");
    assertEquals("http://www.gingersalon.com/", testHairSalon.getWebsite());
  }

  @Test
  public void setWebsite_updatesWebsiteOfHairSalonObject_String() {
    HairSalon testHairSalon = new HairSalon("Ginger Salon", "Portland, OR", "http://www.gingersalon.com/", "A tiny salon with three locations, and just two chairs at each location, we specialize in everything fabulous. Period.");
    testHairSalon.save();
    testHairSalon.setWebsite("http://www.gingersalon.com/");
    testHairSalon.update();
    assertEquals("http://www.gingersalon.com/", testHairSalon.getWebsite());
  }

  @Test
  public void getDescription_grabsDescriptionFromCompanyObject_String() {
    HairSalon testHairSalon = new HairSalon("Ginger Salon", "Portland, OR", "http://www.gingersalon.com/", "A tiny salon with three locations, and just two chairs at each location, we specialize in everything fabulous. Period.");
    assertEquals("A tiny salon with three locations, and just two chairs at each location, we specialize in everything fabulous. Period.", testHairSalon.getDescription());
  }

  @Test
  public void setDescription_updatesDescriptionOfHairSalonObject_String() {
    HairSalon testHairSalon = new HairSalon("Ginger Salon", "Portland, OR", "http://www.gingersalon.com/", "A tiny salon with three locations, and just two chairs at each location, we specialize in everything fabulous. Period.");
    testHairSalon.save();
    testHairSalon.setDescription("A tiny salon with three locations, and just two chairs at each location, we specialize in everything fabulous. Period.");
    testHairSalon.update();
    assertEquals("A tiny salon with three locations, and just two chairs at each location, we specialize in everything fabulous. Period.", testHairSalon.getDescription());
  }

  @Test
  public void all_findsAllCompanies_true() {
    HairSalon testHairSalon1 = new HairSalon("Ginger Salon", "Portland, OR", "http://www.gingersalon.com/", "A tiny salon with three locations, and just two chairs at each location, we specialize in everything fabulous. Period.");
    testHairSalon1.save();
    HairSalon testHairSalon2 = new HairSalon("Enhance", "Portland, OR", "http://enhanceportland.com/", "A place to sit back, relax, and have one of our experienced stylist create the look you desire.");
    testHairSalon2.save();
    assertEquals(true, HairSalon.all().contains(testHairSalon1));
    assertEquals(true, HairSalon.all().contains(testHairSalon2));
  }

  @Test
  public void getId_grabsIdFromHairSalonObject_true() {
    HairSalon testHairSalon = new HairSalon("Ginger Salon", "Portland, OR", "http://www.gingersalon.com/", "A tiny salon with three locations, and just two chairs at each location, we specialize in everything fabulous. Period.");
    testHairSalon.save();
    assertTrue(testHairSalon.getId() > 0);
  }

  @Test
  public void find_findsHairSalonAssociatedWithId_true() {
    HairSalon testHairSalon1 = new HairSalon("Ginger Salon", "Portland, OR", "http://www.gingersalon.com/", "A tiny salon with three locations, and just two chairs at each location, we specialize in everything fabulous. Period.");
    testHairSalon1.save();
    HairSalon testHairSalon2 = new HairSalon("Enhance", "Portland, OR", "http://enhanceportland.com/", "A place to sit back, relax, and have one of our experienced stylist create the look you desire.");
    testHairSalon2.save();
    assertEquals(HairSalon.find(testHairSalon2.getId()), testHairSalon2);
  }

  @Test
  public void getStylists_retrievesStylistsFromHairSalonObject_true() {
    HairSalon testHairSalon = new HairSalon("Ginger Salon", "Portland, OR", "http://www.gingersalon.com/", "A tiny salon with three locations, and just two chairs at each location, we specialize in everything fabulous. Period.");
    int hairsalonid = testHairSalon.getId();
    Stylist testStylist1 = new Stylist("Susan", "123-456-7890", "susan@test.com", hairsalonid);
    testStylist1.save();
    Stylist testStylist2 = new Stylist("Barb", "123-456-7890", "barb@gmail.com", hairsalonid);
    testStylist2.save();
    assertTrue(testHairSalon.getStylists().contains(testStylist1));
    assertTrue(testHairSalon.getStylists().contains(testStylist2));
  }

  @Test
  public void equals_compareTwoHairSalonObjects_true() {
    HairSalon testHairSalon1 = new HairSalon("Ginger Salon", "Portland, OR", "http://www.gingersalon.com/", "A tiny salon with three locations, and just two chairs at each location, we specialize in everything fabulous. Period.");
    HairSalon testHairSalon2 = new HairSalon("Ginger Salon", "Portland, OR", "http://www.gingersalon.com/", "A tiny salon with three locations, and just two chairs at each location, we specialize in everything fabulous. Period.");
    assertEquals(true, testHairSalon1.equals(testHairSalon2));
  }

  @Test
  public void save_savesHairSalon_true() {
    HairSalon testHairSalon = new HairSalon("Ginger Salon", "Portland, OR", "http://www.gingersalon.com/", "A tiny salon with three locations, and just two chairs at each location, we specialize in everything fabulous. Period.");
    testHairSalon.save();
    assertTrue(HairSalon.all().get(0).equals(testHairSalon));
  }

}
