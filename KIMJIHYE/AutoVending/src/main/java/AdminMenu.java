import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class AdminMenu implements Menu {
    Scanner scanner = new Scanner(System.in);
    private Machine machine;
    private List<Item> items;
    private Map<Item,Integer> stocks;
    private Report report;

    public AdminMenu(Machine machine){
        this.machine = machine;
        items = machine.getItems();
        stocks = machine.getStocks();
        report = machine.getReport();
    }

    public void showItems(){
        System.out.println("번호 상품명 제조사 용량 가격 재고");
        for(Item item: items){
            System.out.print(item);
            System.out.println(stocks.get(item)+"개");
        }
    }

    public void showMenus(){
        System.out.println("========= 관리자 메뉴  =======");
        System.out.println("1. 재고 채우기");
        System.out.println("2. 사용자의 구매 이력 보기");
        System.out.print("메뉴 번호를 입력하세요 :) ");
    }

    public void doProcess(int menuNum){
        switch(menuNum){
            case 1:
                showItems();
                fillItems();
                break;
            case 2:
                report.print();
                break;
            default:
                System.out.println("잘못된 입력..");
                break;

        }
    }

    public void raisePrice(int itemId, int amount){
        Item item = machine.getItem(itemId);
        item.price += amount;
    }

    public void reducePrice(int itemId, int amount){
        Item item = machine.getItem(itemId);
        item.price -= amount;
    }

    public void fillItems(){
        int capacity = machine.getCapacity();
        Map<Item,Integer> needToBuy = new HashMap<>();

        for( Item item : stocks.keySet()){
            if(stocks.get(item) < capacity){
                int amount = capacity - stocks.get(item);
                //report.itemIn(item,amount);
                needToBuy.put(item,amount);
            }
        }

        String list="";
        for(Item item: needToBuy.keySet()){
            list+= item.name+" "+needToBuy.get(item)+"개, ";
        }
        list = list.substring(0,list.length()-2);

        System.out.println("재고를 꽉 채우려면");
        System.out.println(list+"가 필요합니다.");
        System.out.print("주문하시겠습니까? (Y/N) ");
        switch(scanner.next()){
            case "Y":
            case "y":
                for(Item item : needToBuy.keySet()){
                    machine.fill(item,needToBuy.get(item));
                }
                break;
            case "N":
            case "n":
                System.out.println("관리자 메뉴를 종료합니다. :)");
                System.out.println("=============================");
                break;
        }
    }





}
