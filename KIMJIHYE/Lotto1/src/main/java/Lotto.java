import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Lotto {
    int size;
    int preSize; // 예비숫자 개수
    List<Integer> numbers = new ArrayList<Integer>();

    // 정답 Lotto
    public Lotto(){
        size = 7;
        preSize = 1;
        Random random = new Random();
        int rand;
        // 랜덤 숫자 6개 생성
        for(int i=0;i<size-1;i++){
            rand = random.nextInt(45)+1;
            if(numbers.contains(rand)){
                i--;
                continue;
            }else{
                numbers.add(rand);
            }
        }
        // 예비 숫자 1개 랜덤 생성
        rand = random.nextInt(45)+1;
        while(true){
            if (!numbers.contains(rand)) {
                numbers.add(rand);
                break;
            }
        }
    }

    // 사용자 Lotto
    public Lotto(List<Integer> numbers){
        size=6;
        preSize= 0;
        this.numbers = numbers;
    }

    public String toString(){
        return numbers.toString();
    }

}
