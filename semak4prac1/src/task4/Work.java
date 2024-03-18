package task4;

public class Work {
    public static void main(String[] args) {
        Clinic clinic = new Clinic();
        for (int i = 1; i <= 20; i++) {
            new Patient(clinic, "Пациент " + i).start();
        }

        while (true) {
            try {
                Patient patient = clinic.getNextPatient();
                patient.visitDoctor();
                patient.goToMRI();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Максимальная длина очереди: " + clinic.getMaxQueueLength());
        }

    }
}
