import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Prompt {
    Scanner scanner = new Scanner(System.in);
    public List<Integer> getNumber(int n) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; ++i) {
            System.out.println("숫자를 입력하세요");
            int input = Integer.parseInt(scanner.nextLine());
            list.add(input);
        }
        return list;
    }

    public void print(String string) {
        System.out.println(string);
    }

}
