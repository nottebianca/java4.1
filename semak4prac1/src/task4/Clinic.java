package task4;

import java.util.LinkedList;
import java.util.Queue;

public class Clinic {
    private final Object lock = new Object();
    private final Queue<Patient> queue = new LinkedList<>();
    private int maxQueueLength = 0;

    public void addPatient(Patient patient) {
        synchronized (lock) {
            queue.add(patient);
            maxQueueLength = Math.max(maxQueueLength, queue.size());
            lock.notify();
        }
    }

    public Patient getNextPatient() throws InterruptedException {
        synchronized (lock) {
            while (queue.isEmpty()) {
                lock.wait();
            }
            return queue.poll();
        }
    }

    public int getMaxQueueLength() {
        return maxQueueLength;
    }
}
