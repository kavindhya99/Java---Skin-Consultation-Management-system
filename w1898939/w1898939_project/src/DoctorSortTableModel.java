import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class DoctorSortTableModel extends AbstractTableModel {
    private String[] columnNames = {"Name","Surname","Date","Mobile Number","Medical License No","Specialisation"};
    private ArrayList<Doctor> doctors;
    public DoctorSortTableModel(ArrayList<Doctor> personList){
        doctors = personList;
    }


    @Override
    public int getRowCount() {
        return doctors.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object temp = null;
        if (columnIndex == 0) {
            temp = doctors.get(rowIndex).getName();
        }
        else if (columnIndex == 1) {
            temp = doctors.get(rowIndex).getSurName();
        }
        else if (columnIndex == 2) {
            temp = doctors.get(rowIndex).getDate();
        }
        else if (columnIndex == 3) {
            temp = doctors.get(rowIndex).getMobileNumber();
        }
        else if (columnIndex == 4) {
            temp = doctors.get(rowIndex).getMedicalLicenseNumber();
        }
        else if (columnIndex == 5) {
            temp = doctors.get(rowIndex).getSpecialisation();
        }
        return temp;
    }
    public String getColumnName(int col) {
        return columnNames[col];
    }
}


