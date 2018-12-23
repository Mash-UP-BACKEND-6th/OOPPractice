package sum;

import java.util.*;

/**
 * Created by changmin on 2018. 12. 15..
 * 이거 왜 하라 그랬는지 모르겠다...
 */
public class Sum {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("두 수를 입력하세요");
        int number1 = sc.nextInt();
        int number2 = sc.nextInt();
        int output = Operator.add(number1, number2);
        System.out.println(String.format("두 수의 합은 %d입니다.", output));
    }
}
