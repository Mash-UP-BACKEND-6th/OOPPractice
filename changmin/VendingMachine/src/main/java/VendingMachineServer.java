import static spark.Spark.get;
import static spark.Spark.post;
import static spark.Spark.staticFileLocation;

import com.google.gson.Gson;

public class VendingMachineServer {
    private Gson gson = new Gson();
    public void start(VendingMachineImpl vendingMachine, VendingMachineManager vendingMachineManager) {
        vendingMachineManager.init(vendingMachine);

        staticFileLocation("/static");

        get("/", (req, res) -> {
            res.redirect("/index.html");
            return "index";
        });

        get("/insertMoney", (req, res) ->{
            int money = req.queryMap("money").integerValue();
            vendingMachine.insertMoney(money);
            return gson.toJson(vendingMachine.getInsertedMoney());
        });

        get("/menu", (req, res) -> {
            res.type("application/json");
            return gson.toJson(vendingMachine.getProductList());
        });

        post("/selectMenu", (req, res) -> {
            System.out.println(req.body());
            ProductInfo productInfo = gson.fromJson(req.body(), ProductInfo.class);
            vendingMachine.buy(productInfo);
            return gson.toJson(vendingMachine.getInsertedMoney());
        });

        get("/exit", (req, res) -> {
            return MessageManager.getMessage("종료합니다.");
        });

        get("/record", (req, res) -> {
            return gson.toJson(vendingMachine.getRecords());
        });
    }
}
