import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Machine machine = new Machine();
        Menu menu = null;

        System.out.println("   자팡기자판기  ");
        while(true){
            System.out.println("1. 상품 구매(사용자 메뉴)\n2. 상품 관리(관리자 메뉴)");
            System.out.print("메뉴 번호를 입력하세요 :) ");
            switch(scanner.nextInt()){
                case 1:
                    menu = new UserMenu(machine);
                    menu.showItems();
                    menu.doProcess();
                    break;
                case 2:
                    menu = new AdminMenu(machine);
                    menu.showItems();
                    menu.showMenus();
                    menu.doProcess(scanner.nextInt());
                    break;
            }




        }



    }

}
