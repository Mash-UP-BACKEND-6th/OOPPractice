package sum;

/**
 * Created by changmin on 2018. 12. 15..
 */
public class Operator {
    //오버 플로우는 생략한다.
    public static int add(int... numbers) {
        int output = 0;
        for(int number : numbers) {
            output += number;
        }
        return output;
    }
}
