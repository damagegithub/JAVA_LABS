package sync;

public class U1901Thread extends Thread {
    U1901Bank bankWork;
    int intTrans;
    long lngSleep;

    public U1901Thread(U1901Bank bank, int trans, long sleep) {
        bankWork = bank;
        intTrans = trans;
        lngSleep = sleep;
    }

    public void run() {
        bankWork.calc(intTrans, lngSleep);
    }
}

