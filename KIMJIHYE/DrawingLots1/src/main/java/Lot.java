package firstVersion;

import java.util.HashMap;
import java.util.Random;

public class Lot {
    int peopleN = 0;
    int losingN = 0;
    HashMap<String,String> lots = new HashMap<>();

    public void prepare(){
        lots.clear();
        String result = "꽝";

        for(int i=0;i<peopleN;i++){
            if(i == losingN-1)
                result="통과";
            lots.put(String.valueOf(i),result);
        }
    }

    public void shuffle(){
        Random random = new Random();
        for(int i=0;i<lots.size();i++){
            int randIndex = random.nextInt(lots.size());
            String oldLot = String.valueOf(i);
            String newLot = String.valueOf(randIndex);

            String temp = lots.get(oldLot);
            lots.replace(oldLot,lots.get(newLot));
            lots.replace(newLot,temp);
        }
    }

    public String getResult(String selectedLot){
        return lots.get(selectedLot);
    }

    public void showAll(){

    }
}
