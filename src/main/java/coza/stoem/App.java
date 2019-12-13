package coza.stoem;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import coza.stoem.services.DonorExtractor;
import coza.stoem.services.OrganisationExtractor;
import coza.stoem.services.TransactionService;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;


import static spark.Spark.*;


public class App{
    //set static resources directory
    static{
        staticFiles.location("/public");
        port(getPort());
    }

    static int getPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }




    public static void main(String[] arguments){
        TransactionService transactionService = new TransactionService();


        get("/get-stats", (request,response) -> {
            List<Transaction> ts = transactionService.getTransactions();
            Gson gson = new Gson();
            JsonElement element = gson.toJsonTree(ts, new TypeToken<List<Transaction>>() {}.getType());

            JsonArray jsonArray = element.getAsJsonArray();
            return jsonArray;
        });

        get("/", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            return new HandlebarsTemplateEngine().render(
                    new ModelAndView(model, "index.handlebars"));
        });

        get("/donate", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            return new HandlebarsTemplateEngine().render(
                    new ModelAndView(model, "form.handlebars"));
        });


        get("/request", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            return new HandlebarsTemplateEngine().render(
                    new ModelAndView(model, "mainform.handlebars"));
        });
        get("/selectingData", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            return new HandlebarsTemplateEngine().render(
                    new ModelAndView(model, "select.handlebars"));
        });

        get("/submitted", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            return new HandlebarsTemplateEngine().render(
                    new ModelAndView(model, "thank.handlebars"));
        });

        post("/submitted", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            OrganisationExtractor extract = new OrganisationExtractor(req.body());
            return new HandlebarsTemplateEngine().render(
                    new ModelAndView(model, "thank.handlebars"));
        });

        post("/capture-form", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            DonorExtractor extract = new DonorExtractor(req.body());
            System.out.println(extract.getLocation());
            System.out.println(extract.getFeedCount());
            return new HandlebarsTemplateEngine().render(
                    new ModelAndView(model, "select.handlebars"));
        });


        get("*", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            if(!req.pathInfo().startsWith("/static")){
                res.status(404);
                return new HandlebarsTemplateEngine().render(
                        new ModelAndView(model, "404.handlebars"));
            }
            return null;
        });
    }
}