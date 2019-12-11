package coza.stoem;
import static spark.Spark.*;


public class App{

    public static void main(String[] arguments){

        get("/", (request,response) -> {
            return "seccess for home";
        });

        post("/capture",(request,response) -> {
            Transaction user = new Transaction(request.queryParams("restuarant"));

            return "success for capture";

        });
    }

}