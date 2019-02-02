import java.util.*;

public class Pung {
    Queue<Character> queue;
    HashMap<Integer, IndexFromTo> widthMap;
    HashMap<Integer, IndexFromTo> heightMap;
    Table table;
    int size;
    int hashKey; // 한 행에서 연속 일치되는 부분이 여러개 생길경우 맵의 key가 중복됨. 중복 없애기위해 더해줄 값.
    // ex. 1001, 2001, 3001 은 hashKey 가 1000으로 정해졌을 때, 첫번째 행에서 3개의 연속일치부분을 발견할 경우 각각의 키값들

    // 큐 구현해서 table내에 있는 ArrayList 가져다 옭겨 넣기(이 처음에 // 를 넣어줌 행이 바뀔때마다)
    public Pung(Table table) {
        this.table = table;
        this.size = table.size;
        int sizeLength = (Integer.valueOf(size)).toString().length();
        hashKey = 1;
        for(int i=1; i<=sizeLength; i++){
            hashKey *= 10;
        }
    }
    // 임시!!!
    public void test(){
        System.out.println("==== 가로 체크 ("+widthMap.size()+")");
        for( Integer r : widthMap.keySet()){
            Integer row = r % hashKey +1;
            System.out.println(row.toString()+"행에 연속 일치가 있습니다.");
            System.out.println(widthMap.get(r));
        }
        System.out.println("==== 세로 체크 ("+heightMap.size()+")");
        for( Integer c : heightMap.keySet()){
            Integer col = c % hashKey +1;
            System.out.println(col.toString()+"열에 연속 일치가 있습니다.");
            System.out.println(heightMap.get(c));
        }
    }

    public boolean check() {
        widthMap = new HashMap<>();
        heightMap = new HashMap<>();
        boolean tobePung;
        int row =0;
        // 가로 체크
        for (String pattern : table.patterns) {
            tobePung = false;
            int count = 0;
            int from = 0;
            char start = pattern.charAt(0);
            //
            for (int i = 1; i < size; i++) {
                char current = pattern.charAt(i);
                if (start == current) {
                    count++;
                } else {
                    if (tobePung == true && start != '0') {
                        int key = row+(hashKey*(widthMap.size()));
                        widthMap.put(key, new IndexFromTo(from, from + count));
                    }
                    from = i;
                    start = current;
                    count = 0;
                    tobePung = false;
                }
                if (count == 2) { // 일치한 횟수가 2번이면 결국 세개의 숫자가 연속 일치한다는 뜻이므로
                    tobePung = true;
                }
            }
            // 한번더 체크(새롭게 숫자가 바뀔 때 보통 체크하는데 연속일치로 행이 끝나면 체크할 수 없으므로)
            if (tobePung == true && start != '0') {
                int key = row+(hashKey*(widthMap.size()));
                widthMap.put(key, new IndexFromTo(from, from + count));
            }
            row++; // 다음행 체크(for each문을 써서..)
        }

        // 세로 체크
        for(int i=0;i<size;i++){
            row = 0;
            tobePung = false;
            int count = 0;
            int from = 0;
            char start = 0;
            char current;
            for (String pattern : table.patterns) {
                if(row==0){
                    start = pattern.charAt(i);
                }else{
                    current = pattern.charAt(i);
                    if (start == current) {
                        count++;
                    } else {
                        if (tobePung == true && start != '0') {
                            int key = i+(hashKey*(heightMap.size()));
                            heightMap.put(key, new IndexFromTo(from, from + count));
                        }
                        from = row;
                        start = current;
                        count = 0;
                        tobePung = false;
                    }
                    if (count == 2) { // 일치한 횟수가 2번이면 결국 세개의 숫자가 연속 일치한다는 뜻이므로
                        tobePung = true;
                    }
                }
                row++;
            }
            if (tobePung == true && start != '0') {
                int key = i+(hashKey*(heightMap.size()));
                heightMap.put(key, new IndexFromTo(from, from + count));
            }
        }

        // Map에 저장된게 있는지 여부 boolean으로 리턴
        if(widthMap.size() == 0 && heightMap.size() ==0){
            return false;
        }else{
            return true;
        }
    }

    public void pung(){ // Map에 저장된 값들을 0으로 펑
        // 가로 펑
        for( Integer row : widthMap.keySet()){
            String origin = table.patterns.get(row%hashKey);
            char[] charArray = origin.toCharArray();
            for(int i = widthMap.get(row).from; i<=widthMap.get(row).to;i++){
                charArray[i]=0;
            }
            table.patterns.set(row%hashKey,new String(charArray));
        }
        // 세로 펑
        for(Integer col : heightMap.keySet()){
            int from = heightMap.get(col).from;
            int to = heightMap.get(col).to;
            for(int i= from;i<=to;i++){
                String origin = table.patterns.get(i);
                char[] charArray = origin.toCharArray();
                charArray[col%hashKey] = 0;
                table.patterns.set(i,new String(charArray));
            }
        }
    }

    public void arrange(){
        queue = new LinkedList<Character>();
        Queue<Character> tmpQueue = new LinkedList<Character>();
        ArrayList<String> reversePat = table.patterns;
        Collections.reverse(reversePat);
        // 아래서부터 넣어야 빈 공간 아래로 채울 수 있음

        // Queue에 넣기
        for(int i=0;i<size;i++){
            for(String s: reversePat){
                char[] charArray = s.toCharArray();
                queue.offer(Character.valueOf(charArray[i]));
                // 따로 저장하지 않고 읽어오기만!
            }
            queue.offer('/'); // 구분자
        }

        // Queue에서 빼기 (뺄때 0은 위로 가게)
        for(int i=0;i<size;i++) {
            int count = size;
            while (queue.peek() != '/') {
                if (queue.peek() == 0) {
                    queue.poll();
                } else {
                    tmpQueue.offer(queue.poll());
                    count--;
                }
            }
            // 나머지 0으로 채워주기
            while (count >= 1) {
                tmpQueue.offer(Character.valueOf('0'));
                count--;
            }
            tmpQueue.offer(queue.poll()); // 구분자 넘겨받기
        }

        //

        for(int i=0;i<size;i++){
            int order=0;
            for(String s : reversePat){
                char[] charArray = s.toCharArray();
                charArray[i] = tmpQueue.poll();
                table.patterns.set(order,new String(charArray));
                order++;
            }
            tmpQueue.poll(); // 구분자는 저장안해도되니까
            reversePat = table.patterns;
        }

        Collections.reverse(table.patterns);
    }


}
