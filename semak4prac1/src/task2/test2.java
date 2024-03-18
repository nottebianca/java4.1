package task2;

import java.util.concurrent.CopyOnWriteArrayList;
public class test2 {
    public static void main(String[] args) {
        CopyOnWriteArrayList<Integer> listOfNumbers = new CopyOnWriteArrayList<>();

        Reader reader = new Reader(listOfNumbers);
        Writer writer = new Writer(listOfNumbers);


        Thread readerThread = new Thread(reader);
        Thread writerThread = new Thread(writer);

        readerThread.start();
        writerThread.start();
    }
}
