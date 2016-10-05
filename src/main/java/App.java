import java.util.HashMap;
import java.util.Map;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;
import org.sql2o.*;
import java.sql.Date;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/index.vtl");
      model.put("hairsalons", HairSalon.all());
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      String name = request.queryParams("name");
      String location = request.queryParams("location");
      String website = request.queryParams("website");
      String description = request.queryParams("description");
      HairSalon hairsalon = new HairSalon(name, location, website, description);
      hairsalon.save();
      response.redirect("/");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/hairsalons/new", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/hairsalon-form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/hairsalons/:hairsalonid", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      int hairsalonid = Integer.parseInt(request.params(":hairsalonid"));
      HairSalon hairsalon = HairSalon.find(hairsalonid);
      model.put("hairsalon", hairsalon);
      model.put("stylists", hairsalon.getStylists());
      model.put("template", "templates/hairsalon.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/hairsalons/:hairsalonid/stylists", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      HairSalon hairsalon = HairSalon.find(Integer.parseInt(request.params(":hairsalonid")));
      model.put("hairsalon", hairsalon);
      model.put("stylists", hairsalon.getStylists());
      model.put("template", "templates/stylists.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/hairsalons/:hairsalonid/stylists/new", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/stylists-form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/stylists", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("stylists", Stylist.all());
      model.put("template", "templates/stylists.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/clients", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("clients", Client.all());
      model.put("template", "templates/clients.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    // post("/stylists", (request, response) -> {
    //   Map<String, Object> model = new HashMap<String, Object>();
    //   String name = request.queryParams("name");
    //   String location = request.queryParams("location");
    //   String website = request.queryParams("website");
    //   String description = request.queryParams("description");
    //   HairSalon hairsalon = new HairSalon(name, location, website, description);
    //   hairsalon.save();
    //   response.redirect("/stylists");
    //   return new ModelAndView(model, layout);
    // }, new VelocityTemplateEngine());

    get("/stylists/new", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/stylist-form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/stylists/:stylistId", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      int stylistId = Integer.parseInt(request.params(":stylistId"));
      Stylist stylist = Stylist.find(stylistId);
      model.put("stylist", stylist);
      model.put("clients", stylist.getClients());
      model.put("template", "templates/stylist.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());


  }
}
