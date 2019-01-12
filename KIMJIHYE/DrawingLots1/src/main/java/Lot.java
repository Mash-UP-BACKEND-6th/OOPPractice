import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Lot {
    int lotsNum, losingNum;
    HashMap<Integer,String> lots = new HashMap<>();
    Set<Integer> loseIdx = new HashSet<>();

    public Lot(int lotsNum, int losing){
        this.lotsNum = lotsNum;
        this.losingNum = losing;
        shuffle();
    }

    public void shuffle(){
        Random random = new Random();
        // 초기화
        lots.clear();
        loseIdx.clear();

        // 꽝을 넣을 랜덤숫자 뽑기
        while(loseIdx.size() != losingNum){
            loseIdx.add(random.nextInt(lotsNum)+1);
        }

        for(int i=1; i<=lotsNum; i++){
            lots.put(i,"통 과");
        }

        for(Integer key : loseIdx){
            lots.put(key,"  꽝 ");
        }

    }

    public String getResult(Integer key){
        return lots.get(key);
    }

}
