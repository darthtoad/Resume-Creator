import java.util.ArrayList;
import java.util.HashMap;

import models.Resume;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import static spark.Spark.*;
import java.util.Map;

/**
 * Created by Guest on 1/9/18.
 */
public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");

        get("/", (request, response) -> {
            Resume.clearAll();
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        post("/new", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String company = request.queryParams("company");
            String jobTitle = request.queryParams("jobTitle");
            String jobDescription = request.queryParams("jobDescription");
            String dateStarted = request.queryParams("dateStarted");
            String dateEnded = request.queryParams("dateEnded");
            Resume newResume = new Resume(company, jobTitle, jobDescription, dateStarted, dateEnded);
            ArrayList allJobs = Resume.getAll();
            model.put("allJobs", allJobs);
            return new ModelAndView(model, "display.hbs");
        }, new HandlebarsTemplateEngine());

        get("/display", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            ArrayList allJobs = Resume.getAll();
            model.put("allJobs", allJobs);
            return  new ModelAndView(model, "display.hbs");
        }, new HandlebarsTemplateEngine());
    }
}
