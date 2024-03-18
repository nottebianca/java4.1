package task2;

import java.util.concurrent.CopyOnWriteArrayList;
public class Writer implements Runnable {
    private CopyOnWriteArrayList<Integer> listOfNumbers;
    public Writer(CopyOnWriteArrayList<Integer> listOfNumbers) {
        this.listOfNumbers = listOfNumbers;
    }
    @Override
    public void run() {
        int number = 0;
        while (listOfNumbers.size() < 20) {
            listOfNumbers.add(number++);
            System.out.println("Запись: " + number);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
