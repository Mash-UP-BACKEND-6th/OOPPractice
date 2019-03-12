import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class VendingMachinePrompt {
    Scanner scanner;

    public VendingMachinePrompt(InputStream in) {
        this.scanner = new Scanner(in);
    }

    enum Commend {
        EXIT, INSERT_COIN, BUY, NONE;
        public static Commend getFromInt(int value){
            switch (value) {
                case 0:
                    return EXIT;
                case 1:
                    return INSERT_COIN;
                case 2:
                    return BUY;
                default:
                    return NONE;
            }
        }
    }

    public static void main(String[] args) {
        if(args.length == 0) {
            new VendingMachineServer().start(new VendingMachineImpl(), new VendingMachineManager(){
                @Override
                public void init(VendingMachine vendingMachine) {
                    for (int i = 0; i < 10; ++i) {
                        Product product = new Product("백산수", "농심", 1, 200, new Date(System.currentTimeMillis()));
                        vendingMachine.addStock(product);
                    }

                    for( int i = 0; i < 5; ++i) {
                        Product product = new Product("콜라", "코카콜라", 1, 200, new Date(System.currentTimeMillis()));
                        vendingMachine.addStock(product);
                    }

                    for (int i = 0; i < 5; ++i) {
                        Product product = new Product("하늘보리", "웅진", 1, 500, new Date(System.currentTimeMillis()));
                        vendingMachine.addStock(product);
                    }
                }
            });
        } else {
            new VendingMachinePrompt(System.in).start(new VendingMachineImpl(), new VendingMachineManager(){
                @Override
                public void init(VendingMachine vendingMachine) {
                    for (int i = 0; i < 10; ++i) {
                        Product product = new Product("백산수", "농심", 1, 200, new Date(System.currentTimeMillis()));
                        vendingMachine.addStock(product);
                    }

                    for( int i = 0; i < 5; ++i) {
                        Product product = new Product("콜라", "코카콜라", 1, 200, new Date(System.currentTimeMillis()));
                        vendingMachine.addStock(product);
                    }

                    for (int i = 0; i < 5; ++i) {
                        Product product = new Product("하늘보리", "웅진", 1, 500, new Date(System.currentTimeMillis()));
                        vendingMachine.addStock(product);
                    }
                }
            });
        }
    }

    public void start(VendingMachine vendingMachine, VendingMachineManager vendingMachineManager) {
        vendingMachineManager.init(vendingMachine);

        Commend commend = Commend.EXIT;
        do {
            List<ProductInfo> productInfos = vendingMachine.getProductList();

            printMenu(productInfos);

            try {
                scanner.reset();
                commend = Commend.getFromInt(scanner.nextInt());

                switch (commend) {
                    case INSERT_COIN:
                        insertMoney(vendingMachine);
                        break;
                    case BUY:
                        buyProduct(vendingMachine, productInfos);
                        break;
                    case EXIT:
                        System.out.println("종료합니다.");
                        break;
                    default:
                        System.out.println("불가능합니다.");
                }
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
                scanner.reset();
            }
        } while(commend != Commend.EXIT);

        for(Product product : vendingMachine.getRecords()) {
            System.out.println(product);
        }
    }

    public void printMenu(List<ProductInfo> productInfos) {
        System.out.println("무엇을 하시겠습니까? 종료:0");
        System.out.println("1. 돈 넣기");

        if (0 < productInfos.size()) {
            System.out.println("2. 구매하기");
        }
    }

    public Product buyProduct(VendingMachine vendingMachine, List<ProductInfo> productInfos) {
        if(0 < productInfos.size()) {
            int index = 1;
            for (ProductInfo info : productInfos) {
                System.out.print(index + " : ");
                System.out.println(info);
                index += 1;
            }
            System.out.println("어느것을 구매하시겠습니까?");
            int choice = scanner.nextInt();

            if(0 > choice || productInfos.size()-1 < choice ) {
                System.out.println();
            }

            Product buy = vendingMachine.buy(productInfos.get(choice-1));

            System.out.println(buy.getName() + " 구매했습니다.");
            return buy;
        } else {
            System.out.println("불가능합니다.");
            return null;
        }
    }

    public void insertMoney(VendingMachine vendingMachine) {
        System.out.println("얼마를 넣으시겠습니까?");
        int money = scanner.nextInt();
        vendingMachine.insertMoney(money);
    }
}
