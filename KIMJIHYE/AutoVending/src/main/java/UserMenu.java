import java.util.List;
import java.util.Scanner;

public class UserMenu implements Menu {
    Scanner scanner = new Scanner(System.in);
    private Machine machine;
    private Report report;
    List<Item> items;
    int minPrice;

    public UserMenu(Machine machine) {
        this.machine = machine;
        items = machine.getItems();
        report = machine.getReport();

        minPrice = items.get(0).price;
        for (Item item : items) {
            if (item.price < minPrice) {
                minPrice = item.price;
            }
        }

        System.out.println("===========  상품 구매 ==========");
    }

    public void doProcess() {
        boolean isEnd = false;
        while (true) {
            System.out.print("돈을 넣으세요 :) ");
            int money = scanner.nextInt();
            machine.setMoney(machine.getMoney() + money);
            if (showCanBuy(machine.getMoney())) {
                System.out.print("원하는 상품을 선택하세요 :) ");
                int itemId = scanner.nextInt();
                String item = machine.getItem(itemId).name;
                machine.buy(itemId);
                System.out.println(item + "을 구입했습니다.");
                report.write(item);
                System.out.println("더 구매하시겠습니까? (Y/N) ");
                switch (scanner.next()) {
                    case "Y":
                    case "y":
                        break;
                    case "N":
                    case "n":
                        System.out.println("거스름돈 " + machine.getMoney() + "원을 가져가세요 :) ");
                        machine.setMoney(0);
                        isEnd = true;
                        break;
                    default:
                        System.out.println("잘못된 입력.. 처음으로 이동합니다.");
                }
            } else {
                continue;
            }
            System.out.println("=======================================");
            if (isEnd) {
                break;
            }
        }

    }

    public void showItems() {
        System.out.println("번호 상품명 제조사 용량 가격");
        for (Item item : items) {
            System.out.println(item);
        }
    }

    public boolean showCanBuy(int money) {
        if (money < minPrice) {
            System.out.println("돈이 너무 적습니다.. 더 넣어주세요.. ");
            return false;
        } else {
            System.out.println(money + "원으로 살 수 있는 음료");
            System.out.println("=> ");

            for (Item item : items) {
                if (item.price <= money) {
                    System.out.println(item.itemId + ". " + item.name + " " + item.price + "원");
                }
            }
            return true;
        }
    }

}
