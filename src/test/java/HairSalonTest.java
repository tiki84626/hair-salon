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

//   @Test
//   public void setName_setsNameFromHairSalonObject_String() {
//     HairSalon testHairSalon = new HairSalon("Ginger Salon", "Portland, OR", "http://www.gingersalon.com/", "A tiny salon with three locations, and just two chairs at each location, we specialize in everything fabulous. Period.");
//     assertEqual
//   }
//
//
//
//   @Test
//   public void getLocation_grabsLocationFromCompanyObject_String() {
//     Company testCompany = new Company("Bear Surfboards", "Milan, Italy", "http://www.bearsurfboards.com/wp-content/uploads/2016/03/logo_bear.png", "http://www.bearsurfboards.com/", "In 1977 John Milius developed the Bear surfboard brand for the movie Big Wednesday.");
//     assertEquals("Milan, Italy", testCompany.getLocation());
//   }
//
//   @Test
//   public void getURL_grabsImgURLFromCompanyObject_String() {
//     Company testCompany = new Company("Bear Surfboards", "Milan, Italy", "http://www.bearsurfboards.com/wp-content/uploads/2016/03/logo_bear.png", "http://www.bearsurfboards.com/", "In 1977 John Milius developed the Bear surfboard brand for the movie Big Wednesday.");
//     assertEquals("http://www.bearsurfboards.com/wp-content/uploads/2016/03/logo_bear.png", testCompany.getURL());
//   }
//
//   @Test
//   public void getWebsite_grabsWebsiteFromCompanyObject_String() {
//     Company testCompany = new Company("Bear Surfboards", "Milan, Italy", "http://www.bearsurfboards.com/wp-content/uploads/2016/03/logo_bear.png", "http://www.bearsurfboards.com/", "In 1977 John Milius developed the Bear surfboard brand for the movie Big Wednesday.");
//     assertEquals("http://www.bearsurfboards.com/", testCompany.getWebsite());
//   }
//
//   @Test
//   public void getDescription_grabsDescriptionFromCompanyObject_String() {
//     Company testCompany = new Company("Bear Surfboards", "Milan, Italy", "http://www.bearsurfboards.com/wp-content/uploads/2016/03/logo_bear.png", "http://www.bearsurfboards.com/", "In 1977 John Milius developed the Bear surfboard brand for the movie Big Wednesday.");
//     assertEquals("In 1977 John Milius developed the Bear surfboard brand for the movie Big Wednesday.", testCompany.getDescription());
//   }
//
//   @Test
//   public void all_findsAllCompanies_true() {
//     Company testCompany1 = new Company("Bear Surfboards", "Milan, Italy", "http://www.bearsurfboards.com/wp-content/uploads/2016/03/logo_bear.png", "http://www.bearsurfboards.com/", "In 1977 John Milius developed the Bear surfboard brand for the movie Big Wednesday.");
//     testCompany1.save();
//     Company testCompany2 = new Company("Hack Surfboards", "Oceanside, California", "http://www.hacksurfboards.com/site/wp-content/themes/hack/images/hack-surfboards-machete-logo.png", "http://www.hacksurfboards.com/", "Sample description");
//     testCompany2.save();
//     assertEquals(true, Company.all().contains(testCompany1));
//     assertEquals(true, Company.all().contains(testCompany2));
//   }
//
//   @Test
//   public void getId_grabsIdFromCompanyObject_true() {
//     Company testCompany = new Company("Bear Surfboards", "Milan, Italy", "http://www.bearsurfboards.com/wp-content/uploads/2016/03/logo_bear.png", "http://www.bearsurfboards.com/", "In 1977 John Milius developed the Bear surfboard brand for the movie Big Wednesday.");
//     testCompany.save();
//     assertTrue(testCompany.getId() > 0);
//   }
//
//   @Test
//   public void find_findsCompanyAssociatedWithId_true() {
//     Company testCompany1 = new Company("Bear Surfboards", "Milan, Italy", "http://www.bearsurfboards.com/wp-content/uploads/2016/03/logo_bear.png", "http://www.bearsurfboards.com/", "In 1977 John Milius developed the Bear surfboard brand for the movie Big Wednesday.");
//     testCompany1.save();
//     Company testCompany2 = new Company("Hack Surfboards", "Oceanside, California", "http://www.hacksurfboards.com/site/wp-content/themes/hack/images/hack-surfboards-machete-logo.png", "http://www.hacksurfboards.com/", "Sample description");
//     testCompany2.save();
//     assertEquals(Company.find(testCompany2.getId()), testCompany2);
//   }
//
//   // @Test
//   // public void getBoards_initiallyReturnsEmptyList_ArrayList() {
//   //   Company testCompany = new Company("Bear Surfboards", "Milan, Italy", "http://www.bearsurfboards.com/wp-content/uploads/2016/03/logo_bear.png", "http://www.bearsurfboards.com/", "In 1977 John Milius developed the Bear surfboard brand for the movie Big Wednesday.");
//   //   testCompany.save();
//   //   Board testBoard1 = new Board("Al Merrick", "https://www.downthelinesurf.co.uk/media/catalog/product/cache/1/image/1000x/9df78eab33525d08d6e5fb8d27136e95/4/-/4-utility-deck-692px.jpg", "Shortboard", 2.25, 800.00, 18.25, "5'6''", 3, "Squash Tail", 1);
//   //
//   //   Board testBoard2 = new Board("Hack Surfboard", "https://www.someurl.com/x.jpg", "Shortboard", 2.25, 800.00, 18.25, "5'6''", 3, "Squash Tail", 2);
//   //   Board[] boards = new Board[] {testBoard1, testBoard2};
//   //
//   //   assertEquals([testBoard1, testBoard2], testCompany.getBoards().containsAll(Arrays.asList(boards)));
//   // }
//
//   @Test
//   public void equals_returnsTrueIfNameIsSame_true() {
//     Company testCompany1 = new Company("Bear Surfboards", "Milan, Italy", "http://www.bearsurfboards.com/wp-content/uploads/2016/03/logo_bear.png", "http://www.bearsurfboards.com/", "In 1977 John Milius developed the Bear surfboard brand for the movie Big Wednesday.");
//     Company testCompany2 = new Company("Bear Surfboards", "Milan, Italy", "http://www.bearsurfboards.com/wp-content/uploads/2016/03/logo_bear.png", "http://www.bearsurfboards.com/", "In 1977 John Milius developed the Bear surfboard brand for the movie Big Wednesday.");
//     assertTrue(testCompany1.equals(testCompany2));
//   }
//
//   @Test
//   public void save_savesCompany_true() {
//     Company testCompany = new Company("Bear Surfboards", "Milan, Italy", "http://www.bearsurfboards.com/wp-content/uploads/2016/03/logo_bear.png", "http://www.bearsurfboards.com/", "In 1977 John Milius developed the Bear surfboard brand for the movie Big Wednesday.");
//     testCompany.save();
//     assertTrue(Company.all().get(0).equals(testCompany));
//   }
//
//   @Test
//   public void update_updatesCompany_true() {
//     Company testCompany = new Company("nametest1", "localtest1", "imgURLtest1", "websitetest1", "descriptiontest1");
//     testCompany.save();
//     testCompany.update("nametest2", "localtest2", "imgURLtest2", "websitetest2", "descriptiontest2");
//     assertEquals("nametest2", Company.find(testCompany.getId()).getName());
//   }
// }
