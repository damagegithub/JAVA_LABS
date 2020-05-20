package sync;

public class U1901Main {
    public static void main(String[] args) throws CloneNotSupportedException {

        U1901Bank mainBank = new U1901Bank();

        U1901Thread threadOne = new U1901Thread(mainBank, 100, 2000);
        threadOne.setName("ThreadOne");
        threadOne.setPriority(Thread.MAX_PRIORITY);
        threadOne.start();

        U1901Thread threadTwo = new U1901Thread(mainBank, 50, 300);
        threadTwo.setName("ThreadTwo");
        threadTwo.setPriority(Thread.MAX_PRIORITY);
        threadTwo.start();

        System.out.println("CurrentThread: " + Thread.currentThread().getName());
        // Without "synchronized"
        // Before Thread: ThreadTwo, From: 220, To: 0
        // Before Thread: ThreadOne, From: 220, To: 0
        // After Thread: ThreadTwo, From: 70, To: 50
        // After Thread: ThreadOne, From: 70, To: 150

        // With "synchronized"
        // Before Thread: ThreadOne, From: 220, To: 0
        // After Thread: ThreadOne, From: 120, To: 100
        // Before Thread: ThreadTwo, From: 120, To: 100
        // After Thread: ThreadTwo, From: 70, To: 150
    }
}
