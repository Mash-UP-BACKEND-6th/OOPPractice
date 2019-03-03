import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Prompt {

    public static void main(String[] args) throws IOException {
        int size=6;
        int rank = 0;
        List<Integer> numbers = new ArrayList<Integer>();

        System.out.println("로또 시작.");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //
        Machine machine = new Machine();

        System.out.println("1-45에 해당하는 숫자 "+size+"개를 입력하세요. (ex.1 3 23 4 6 7)");
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        while(st.hasMoreTokens()){
            numbers.add(Integer.parseInt(st.nextToken()));
        }

        Lotto myLotto = new Lotto(numbers);

        machine.check(myLotto);

        machine.print();
    }

}
