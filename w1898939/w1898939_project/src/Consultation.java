import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

public class Consultation {
        private String consultationId;
        private double cost;
        private String dateTime;
        private int duration;
        private String note;
        private String patientId;
        private String doctorName;

        private String attachment;

        public String getConsultationId() {
                return consultationId;
        }

        public void setConsultationId(String consultationId) {
                this.consultationId = consultationId;
        }

        public String getAttachment() {
                return attachment;
        }

        public void setAttachment(String attachment) {
                this.attachment = attachment;
        }

        public int getDuration() {
                return duration;
        }

        public void setDuration(int duration) {
                this.duration = duration;
        }

        public Consultation() {
                AtomicInteger seq = new AtomicInteger();
                int nextVal = seq.incrementAndGet();
                setConsultationId(String.valueOf(nextVal));
        }



        public String getDoctorName() {
                return doctorName;
        }

        public void setDoctorName(String doctorName) {
                this.doctorName = doctorName;
        }

        public String getPatientId() {
                return patientId;
        }

        public void setPatientId(String patientId) {
                this.patientId = patientId;
        }

        public String getDateTime() {
                return dateTime;
        }

        public void setDateTime(String dateTime) {
                this.dateTime = dateTime;
        }

        public double getCost() {
                return cost;
        }

        public void setCost(double cost) {
                this.cost = cost;
        }

        public String getNote() {
                return note;
        }

        public void setNote(String note) {
                this.note = note;
        }

        public Consultation(String dateTime, double cost, String note) {
                this.dateTime = dateTime;
                this.cost = cost;
                this.note = note;
        }
        }

