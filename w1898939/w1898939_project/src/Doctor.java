import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.Date;

public class Doctor extends Patient{
    private int MedicalLicenseNumber;
    private String Specialisation;

    public Doctor() {

    }

    public Doctor(String john, String doe, Date date, String s, String surgeon, String s1, LocalDateTime now) {
        super();
    }

    public void setMedicalLicenseNumber(int MedicalLicenseNumber) {
        this.MedicalLicenseNumber = MedicalLicenseNumber;
    }
    public int getMedicalLicenseNumber() {
        return MedicalLicenseNumber;
    }

    public void setSpecialisation(String Specialisation) {
        this.Specialisation = Specialisation;
    }
    public String getSpecialisation() {
        return Specialisation;
    }
    public Doctor(int medicalLicenseNumber, String specialisation) {
        this.MedicalLicenseNumber = medicalLicenseNumber;
        this.Specialisation = specialisation;
    }





}


