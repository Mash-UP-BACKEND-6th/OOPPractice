import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * Prompt의 책임 : 입출력 스트림 제어
 */
public class Prompt {
    Scanner scanner;
    PrintStream printer;

    public Prompt(InputStream inputStream, OutputStream outputStream) {
        this.scanner = new Scanner(inputStream);
        this.printer = new PrintStream(outputStream);
    }

    public int getNumber(String message) {
        printer.print(message);
        int number = Integer.parseInt(scanner.nextLine());
        return number;
    }

    public void println(String message) {
        printer.println(message);
    }

    public static void main(String[] arsg) {
        Prompt prompt = new Prompt(System.in, System.out);
        int people = prompt.getNumber("인원 수를 입력하세요. : ");
        int lose = prompt.getNumber("꽝의 개수를 입력하세요. : ");

        DrawingMachine dm = new DrawingMachine();
        dm.shuffle(people, lose);
        String message = String.format("1부터 %s 까지 수를 입력하세요.(1보다 작으면 종료) : ", people);
        while (true) {
            int number = prompt.getNumber(message);
            if (number < 1) {
                break;
            }

            if (dm.check(number)) {
                prompt.println("통과");
            } else {
                prompt.println("꽝");
            }
        }
    }
}
