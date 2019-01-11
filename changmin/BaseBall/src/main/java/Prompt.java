import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Prompt {
    private Scanner scanner = new Scanner(System.in);

    public List<Integer> getInputs() {
        List<Integer> inputs = new ArrayList<>();
        System.out.print("3자리 숫자를 입력하세요:");
        String input = scanner.nextLine();

        for(String token : input.split("")) {
            inputs.add(Integer.parseInt(token));
        }

        return inputs;
    }
}
