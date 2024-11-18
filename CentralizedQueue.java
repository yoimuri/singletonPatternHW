package singletonPattern;

public class CentralizedQueue {
    private static CentralizedQueue instance;
    private int currentQueueNumber;
    private boolean isQueueActive;

    private CentralizedQueue() {
        currentQueueNumber = 0;
        isQueueActive = true; 
    }

    public static synchronized CentralizedQueue getInstance() {
        if (instance == null) {
            instance = new CentralizedQueue();
        }
        return instance;
    }

    public synchronized int getNextQueueNumber() {
        if (isQueueActive) {
            currentQueueNumber++;
            return currentQueueNumber;
        } else {
            System.out.println("Queue is currently inactive.");
            return -1; 
        }
    }

    public synchronized void resetQueue(int resetNumber) {
        if (resetNumber >= 0) {
            currentQueueNumber = resetNumber;
            System.out.println("Queue has been reset to " + resetNumber);
        } else {
            System.out.println("Invalid reset number.");
        }
    }

    public synchronized void deactivateQueue() {
        isQueueActive = false;
        System.out.println("Queue system has been deactivated.");
    }

    public synchronized void reactivateQueue() {
        isQueueActive = true;
        System.out.println("Queue system is now active.");
    }

    public synchronized String getCurrentQueueNumber() {
        if (currentQueueNumber == 0) {
            return "No current queue.";
        } else {
            return "" + currentQueueNumber;
        }
    }
}
