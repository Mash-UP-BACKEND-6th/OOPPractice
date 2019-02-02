public class IndexFromTo{
    int from;
    int to;

    public IndexFromTo(int from, int to){
        this.from = from;
        this.to = to;
    }

    @Override
    public String toString() {
        int f = from +1;
        int t = to +1;
        // 프롬프트용 인덱스값 (1부터 시작하도록)
        return f+"번째부터 "+t+"번째까지 연속 일치";
    }
}