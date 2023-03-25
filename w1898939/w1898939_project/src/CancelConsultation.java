import javax.swing.*;

public class CancelConsultation extends JFrame {
    public static void cancelConsultation(String consultationId) {
        Consultation consultation = new Consultation();
        Patient patient = new Patient();

        while (!WestminsterSkinConsultationManager.consultations.isEmpty()) {
            for (Consultation c : WestminsterSkinConsultationManager.consultations) {
                if (c.getConsultationId().equals(consultationId)) {
                    consultation = c;
                }
            }

        WestminsterSkinConsultationManager.consultations.remove(consultation);

        for (Patient p : WestminsterSkinConsultationManager.patients) {
            if (p.getPatientId().equals(consultation.getPatientId())) {
                patient = p;
            }
        }

        WestminsterSkinConsultationManager.consultations.remove(consultation);
        WestminsterSkinConsultationManager.patients.remove(patient);

    }
}
}
