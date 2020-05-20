package sync;

public class U1901Bank {
    public int intTo;
    public int intFrom = 220;

    synchronized void calc(int intTransaction, long lngTimeout) {

        System.out.println(
                "Before Thread: " + Thread.currentThread().getName() + ", From: " + intFrom + ", To: " + intTo);

        intFrom -= intTransaction;
        try {
            Thread.sleep(lngTimeout);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        intTo += intTransaction;

        System.out
                .println("After Thread: " + Thread.currentThread().getName() + ", From: " + intFrom + ", To: " + intTo);
    }
}

