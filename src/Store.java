public class Store {
    private Counter[] products = new Counter[100];
    public Store() {
        for (int i=0; i < products.length; i++) {
            products[i] = new Counter(10000);
        }
    }
    public void buyProducts(int cod1, int cod2, int cod3) {
        synchronized(products[cod1]){
            synchronized(products[cod2]){
                synchronized(products[cod3]){

                    /*
                    Have sequential "synchronized" his can cause deadlock:
                    Deadlock occurs when a thread A is waiting for thread B
                    and thread B is also waiting for thread A
                     */

                    products[cod1].decrement();
                    products[cod2].decrement();
                    products[cod3].decrement();
                }
            }
        }
    }
    public int totalStock() {
        int sum = 0;
        for (int i=0; i < products.length; i++) {
            sum += products[i].value();
        }
        return sum;
    }
}
