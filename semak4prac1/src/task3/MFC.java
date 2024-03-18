package task3;

import java.util.Random;


public class MFC {
    public static void main(String[] args) {
        Window window1 = new Window("Молодые");
        Window window2 = new Window("Пожилые");
        Window window3 = new Window("Бизнесмены");

        Window[] windows = {window1, window2, window3};

        String[] categories = {"Молодые", "Пожилые", "Бизнесмены"};

        Random random = new Random();

        int[] totalCustomers = new int[3];
        int[] leftCustomers = new int[3];

        for (int i = 0; i < 50; i++) {
            People people = new People(categories[random.nextInt(categories.length)]);

            int windowIndex = random.nextInt(windows.length);
            Window selectedWindow = windows[windowIndex];

            if (!selectedWindow.isAcceptable(people) || selectedWindow.isBusy()) {
                leftCustomers[getIndex(people.getCategory())]++;
            } else {
                selectedWindow.setBusy(true);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                selectedWindow.setBusy(false);
            }

            totalCustomers[getIndex(people.getCategory())]++;
        }

        for (int i = 0; i < categories.length; i++) {
            double percentage = (double) leftCustomers[i] / totalCustomers[i] * 100;
            System.out.println("Процент ушедших граждан в категории " + categories[i] + ": " + percentage + "%");
        }
    }

    public static int getIndex(String category) {
        switch (category) {
            case "Молодые":
                return 0;
            case "Пожилые":
                return 1;
            case "Бизнесмены":
                return 2;
            default:
                return -1;
        }
    }
}
