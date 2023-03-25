import java.util.Date;

public class Person {
    private  String Name;
    private String SurName;
    private String date;
    private int MobileNumber;

    public void setName(String Name)
    {
        this.Name=Name;
    }
    public String getName()
    {
        return Name;
    }
    public void setSurName(String SurName) {
        this.SurName = SurName;
    }
    public String getSurName() {
        return SurName;
    }
    public void setDate(String date)
    {
        this.date=date;
    }

    public String getDate() {
        return date;
    }

    public void setMobileNumber(int MobileNumber) {
        this.MobileNumber = MobileNumber;
    }

    public int getMobileNumber() {
        return MobileNumber;
    }
}
