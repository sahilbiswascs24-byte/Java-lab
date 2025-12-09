class MessageThread extends Thread {
    String message;
    int interval; 
    int count; 

    MessageThread(String msg, int time, int count) {
        this.message = msg;
        this.interval = time;
        this.count = count;
    }

    public void run() {
        try {
            for (int i = 1; i <= count; i++) {
                System.out.println(message);
                Thread.sleep(interval);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread Interrupted");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        
        MessageThread t1 = new MessageThread("BMS College of Engineering", 10000, 5);

       
        MessageThread t2 = new MessageThread("CSE", 2000, 10);

        t1.start();
        t2.start();
    }
}