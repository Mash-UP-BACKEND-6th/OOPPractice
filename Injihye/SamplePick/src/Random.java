import java.util.*;

public class Random {

    public static void main(String[] args) {
        List<Map<String, Integer>> list = new ArrayList<>();

        Integer personNum;
        String personName;
        Scanner scanner = new Scanner(System.in);
        System.out.println("인원수");
        personNum = scanner.nextInt();
        System.out.println("입력하신 인원수는 " + personNum + "명 입니다.");
        scanner.nextLine();

        for (int i = 0; i < personNum; i++) {
            Map<String, Integer> data = new HashMap<>();
            data.clear();
            System.out.println(i + "번째사람 별명입력");
            personName = scanner.nextLine();
            data.put(personName, (int) (Math.random() * 101));
            list.add(data);
        }

        int index = 0;
        int max = 0;
        for (int i = 0; i < personNum; i++) {
            if ( list.get(i).values().size() > 0) {
                max =  list.get(i).values().size();
                index = i;
            }
        }

        System.out.println("첫번째" + list.get(0));
        System.out.println("첫번째 값 " + list.get(0).values());
        System.out.println("list : " + list);
        System.out.println("\n당첨자는 " + list.get(index).toString());

    }
}

/*class MyData {
    private String personName;
    private Integer personNum;

    public MyData(String personName, Integer personNum) {
        this.personName = personName;
        this.personNum = personNum;
    }

    public String getPersonName() {
        return personName;
    }

    public Integer getPersonNum() {
        return personNum;
    }
}*/
