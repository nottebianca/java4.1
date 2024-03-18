package task4;

import java.util.Random;

public class Patient extends Thread {
    private final Clinic clinic;
    private final String name;

    public Patient(Clinic clinic, String name) {
        this.clinic = clinic;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(new Random().nextInt(300) + 300);
            clinic.addPatient(this); // Добавление пациента в очередь
            System.out.println(name + " прибыл(а) в поликлинику.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void visitDoctor() {
        try {
            System.out.println(name + " находится у терапевта.");
            // Задержка для имитации времени обследования
            Thread.sleep(new Random().nextInt(600) + 200);
            System.out.println(name + " завершил(а) прием у терапевта.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void goToMRI() {
        try {
            System.out.println(name + " проходит МРТ.");
            Thread.sleep(new Random().nextInt(600) + 200);
            System.out.println(name + " завершил(а) прохождение МРТ.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
