class Counter {
    private int cnt = 0;
    public Counter(int init) {
        cnt = init;
    }
    public void increment() {
        cnt++; //CRITICAL SECTION
    }
    public void decrement() {
        cnt--; //CRITICAL SECTION
    }
    public int value() {
        return cnt;
    }
}